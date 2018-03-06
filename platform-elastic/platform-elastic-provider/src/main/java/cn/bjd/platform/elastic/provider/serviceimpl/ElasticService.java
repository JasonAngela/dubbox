package cn.bjd.platform.elastic.provider.serviceimpl;


import cn.bjd.platform.elastic.provider.utils.DateUtils;
import cn.bjd.platform.elastic.api.entity.dto.EtpEsDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpEsDataDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpWhiteDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpWhiteDataDTO;
import cn.bjd.platform.elastic.api.service.IElasticService;
import cn.bjd.platform.elastic.provider.utils.JacksonUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.search.*;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by admin on 2018/1/26 0026.
 */
@Service
@Transactional(readOnly = true)
public class ElasticService implements IElasticService {

    @Resource
    private TransportClient client;

    @Resource
    private RestClient restClient;

    /**
     * 关键字查询返回的字段
     */
    private static String[] include = {"id", "entName", "regDate", "regCapital", "lng", "lat", "category"};

    /**
     * 白名单查询返回的字段
     */
    private static String[] whiteList = {"id", "lng", "lat", "category"};


    /**
     * 白名单导出返回的字段
     */
    private static String[] exportWhiteList = {"id", "entName", "category", "bigCategory", "middleCategory"
            , "smallCategory", "lng", "lat", "address", "legalRep", "regDate", "regCapital"};

    /**
     * 根据名称查询
     *
     * @param keyword
     * @param page
     * @param pageNum
     * @return
     */
    @Override
    public EtpEsDataDTO findByKeyword(String keyword, Integer page, Integer pageNum) throws ParseException, IOException {

        EtpEsDataDTO etpEsDataDTO = new EtpEsDataDTO();

        //获取查询
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("company-etp").setTypes("etp")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        //需返回的字段
        searchRequestBuilder.setFetchSource(include, null);

        //从多少条数据开始
        Integer from = page == 1 ? 0 : page * pageNum;

        //名称查询
        searchRequestBuilder.setFrom(from).setSize(pageNum).
                setQuery(QueryBuilders
                        .matchQuery("entName", keyword));
        HttpEntity entity = new NStringEntity(searchRequestBuilder.toString(), ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest("GET", "/company-etp/etp/_search", Collections.<String, String>emptyMap(), entity);

        //返回空即返回
        if (null == response) {
            return null;
        }

        String entityStr = EntityUtils.toString(response.getEntity());
        Map<String, Object> entityMap = (Map<String, Object>) JacksonUtils.readValue(entityStr, Map.class).get("hits");

        //取总数
        etpEsDataDTO.setTotal(Integer.toUnsignedLong((Integer) entityMap.get("total")));

        //取source中的数据
        List<Map<String, Object>> source = (List<Map<String, Object>>) entityMap.get("hits");
        for (Map<String, Object> sourceMap : source) {
            etpEsDataDTO.getCompanyList().add(new EtpEsDTO((Map<String, Object>) sourceMap.get("_source")));
        }

        return etpEsDataDTO;
    }

    /**
     * 封装成返回MAp
     * @param regionCode
     * @param startScore
     * @param endScore
     * @param industrys
     * @param startReg
     * @param endReg
     * @param startCap
     * @param endCap
     * @param count
     * @return
     * @throws ParseException
     * @throws IOException
     */
    Map<String, Object> getResultMap(String regionCode, Integer startScore, Integer endScore, List<String> industrys, Integer startReg, Integer endReg, Integer startCap, Integer endCap, String count) throws ParseException, IOException {
        //获取查询
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("company-etp").setTypes("etp").setFetchSource(true)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        //bool查询
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();


        //all查询所有
        if (NumberUtils.isNumber(count)) {
            //设置白名单查询字段
            searchRequestBuilder.setFetchSource(whiteList, null);
            searchRequestBuilder.setFrom(0).setSize(Integer.parseInt(count));
        } else if ("downLoad".equals(count)) {
            //设置导出字段
            searchRequestBuilder.setFetchSource(exportWhiteList, null);
            searchRequestBuilder.setFrom(0).setSize(getCount(regionCode, startScore, endScore, industrys, startReg, endReg, startCap, endCap));
        } else if ("all".equals(count)) {
            //设置白名单查询字段
            searchRequestBuilder.setFetchSource(whiteList, null);
            searchRequestBuilder.setFrom(0).setSize(getCount(regionCode, startScore, endScore, industrys, startReg, endReg, startCap, endCap));
        }

        //区域代码
        if (!StringUtils.isEmpty(regionCode)) {
            queryBuilder.must(QueryBuilders.termQuery("countryCode", regionCode));
        }


        if (!CollectionUtils.isEmpty(industrys)) {
            BoolQueryBuilder industryBuilder = QueryBuilders.boolQuery();
            industryBuilder.should(QueryBuilders.termsQuery("category", industrys));
            industryBuilder.should(QueryBuilders.termsQuery("bigCategory", industrys));
            industryBuilder.should(QueryBuilders.termsQuery("middleCategory", industrys));
            industryBuilder.should(QueryBuilders.termsQuery("smallCategory", industrys));
            queryBuilder.must(industryBuilder);
        }

        //查询在营业的企业
        queryBuilder.must(QueryBuilders.termQuery("regState", 1));


        //得分过滤
        if (null != startScore || null != endScore) {
            queryBuilder.must(builderRange(QueryBuilders.rangeQuery("score"), startScore, endScore));
        }

        //判断资本字段
        if (null != startCap || null != endCap) {
            queryBuilder.must(builderRange(QueryBuilders.rangeQuery("regCapital"), startCap, endCap));
        }

        //判断注册年限
        if (null != startReg || null != endReg) {
            String start = null;
            String end = null;
            if (null != endReg) {
                start = getRegDate(endReg);
            }
            if (null != startReg) {
                end = getRegDate(startReg);
            }
            queryBuilder.must(builderRange(QueryBuilders.rangeQuery("regDate"), start, end));
        }

        searchRequestBuilder.setQuery(queryBuilder);

        HttpEntity entity = new NStringEntity(searchRequestBuilder.toString(), ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest("POST", "/company-etp/etp/_search", Collections.<String, String>emptyMap(), entity);

        //返回空即返回
        if (null == response) {
            return null;
        }
        String entityStr = EntityUtils.toString(response.getEntity());
        Map<String, Object> entityMap = (Map<String, Object>) JacksonUtils.readValue(entityStr, Map.class).get("hits");
        return entityMap;
    }



    /**
     * @param regionCode
     * @param startScore
     * @param endScore
     * @param industrys
     * @param startReg
     * @param endReg
     * @param startCap
     * @param endCap
     * @param count
     * @return
     */
    @Override
    public EtpWhiteDataDTO findWhiteList(String regionCode, Integer startScore, Integer endScore, List<String> industrys, Integer startReg, Integer endReg, Integer startCap, Integer endCap, String count) throws ParseException, IOException {
        EtpWhiteDataDTO etpWhiteDataDTO = new EtpWhiteDataDTO();

        Map<String, Object> entityMap = getResultMap(regionCode, startScore, endScore, industrys, startReg, endReg, startCap, endCap, count);

        //取总数
        etpWhiteDataDTO.setTotal(Integer.toUnsignedLong((Integer) entityMap.get("total")));

        //取source中的数据
        List<Map<String, Object>> source = (List<Map<String, Object>>) entityMap.get("hits");
        for (Map<String, Object> sourceMap : source) {
            etpWhiteDataDTO.getWhileList().add(new EtpWhiteDTO((Map<String, Object>) sourceMap.get("_source")));
        }
        return etpWhiteDataDTO;
    }

    /**
     * 单独获取企业个数
     * @param regionCode
     * @param startScore
     * @param endScore
     * @param industrys
     * @param startReg
     * @param endReg
     * @param startCap
     * @param endCap
     * @param count
     * @return
     * @throws ParseException
     * @throws IOException
     */
    @Override
    public Long findWhiteCount(String regionCode, Integer startScore, Integer endScore, List<String> industrys, Integer startReg, Integer endReg, Integer startCap, Integer endCap, String count) throws ParseException, IOException {
        Map<String, Object> entityMap = getResultMap(regionCode, startScore, endScore, industrys, startReg, endReg, startCap, endCap, count);
        return Integer.toUnsignedLong((Integer) entityMap.get("total"));
    }

    /**
     * 当前时间年份相减
     *
     * @param reg
     * @return
     */
    private String getRegDate(Integer reg) {
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -reg);
        Date lo = calendar.getTime();
        return DateUtils.format(lo, "yyyy-MM-dd");
    }


    public int getCount(String regionCode, Integer startScore, Integer endScore, List<String> industrys, Integer startReg, Integer endReg, Integer startCap, Integer endCap) throws IOException {


        //获取查询
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("company-etp").setTypes("etp").setFetchSource(true)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        //bool查询
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        //设置查询的字段
        searchRequestBuilder.setFetchSource("", null);

        //区域代码
        if (!StringUtils.isEmpty(regionCode)) {
            queryBuilder.must(QueryBuilders.termQuery("countryCode", regionCode));
        }


        if (!CollectionUtils.isEmpty(industrys)) {
            BoolQueryBuilder industryBuilder = QueryBuilders.boolQuery();
            industryBuilder.should(QueryBuilders.termsQuery("category", industrys));
            industryBuilder.should(QueryBuilders.termsQuery("bigCategory", industrys));
            industryBuilder.should(QueryBuilders.termsQuery("middleCategory", industrys));
            industryBuilder.should(QueryBuilders.termsQuery("smallCategory", industrys));
            queryBuilder.must(industryBuilder);
        }

        //判断行业字段是否存在
        /*if (!StringUtils.isEmpty(industry)) {
            BoolQueryBuilder industryBuilder = QueryBuilders.boolQuery();
            industryBuilder.should(QueryBuilders.termQuery("category", industry));
            industryBuilder.should(QueryBuilders.termQuery("bigCategory", industry));
            industryBuilder.should(QueryBuilders.termQuery("middleCategory", industry));
            industryBuilder.should(QueryBuilders.termQuery("smallCategory", industry));
            queryBuilder.must(industryBuilder);
        }*/

        //查询在营业的企业
        queryBuilder.must(QueryBuilders.termQuery("regState", 1));


        //得分过滤
        if (null != startScore || null != endScore) {
            queryBuilder.must(builderRange(QueryBuilders.rangeQuery("score"), startScore, endScore));
        }

        //判断资本字段
        if (null != startCap || null != endCap) {
            queryBuilder.must(builderRange(QueryBuilders.rangeQuery("regCapital"), startCap, endCap));
        }

        //判断注册年限
        if (null != startReg || null != endReg) {
            String start = null;
            String end = null;
            if (null != endReg) {
                start = getRegDate(endReg);
            }
            if (null != startReg) {
                end = getRegDate(startReg);
            }
            queryBuilder.must(builderRange(QueryBuilders.rangeQuery("regDate"), start, end));
        }

        searchRequestBuilder.setQuery(queryBuilder);

        HttpEntity entity = new NStringEntity(searchRequestBuilder.toString(), ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest("GET", "/company-etp/etp/_search", Collections.<String, String>emptyMap(), entity);


        String entityStr = EntityUtils.toString(response.getEntity());
        Map<String, Object> entityMap = (Map<String, Object>) JacksonUtils.readValue(entityStr, Map.class).get("hits");


        //返回空即返回
        if (null == response) {
            return 0;
        }

        //总数
        return (Integer) entityMap.get("total");
    }

    /**
     * 构建查询范围
     *
     * @param rangeQueryBuilder
     * @param start
     * @param end
     * @return
     */
    private RangeQueryBuilder builderRange(RangeQueryBuilder rangeQueryBuilder, Object start, Object end) {
        if (null != start) {
            rangeQueryBuilder.gte(start);
        }
        if (null != end) {
            rangeQueryBuilder.lte(end);
        }
        return rangeQueryBuilder;
    }
}
