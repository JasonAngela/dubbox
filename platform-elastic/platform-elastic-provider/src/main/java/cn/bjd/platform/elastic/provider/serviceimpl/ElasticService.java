package cn.bjd.platform.elastic.provider.serviceimpl;


import cn.bjd.platform.elastic.provider.utils.DateUtils;
import cn.bjd.platform.elastic.api.entity.dto.EtpEsDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpEsDataDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpWhiteDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpWhiteDataDTO;
import cn.bjd.platform.elastic.api.service.IElasticService;
import org.apache.commons.lang3.math.NumberUtils;
import org.elasticsearch.action.search.*;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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

    /**
     * 设置所需返回的字段
     */
    private static String[] include = {"id", "entName", "regDate", "regCapital", "lng", "lat", "category"};

    private static String[] whiteList = {"id","lng", "lat", "category"};

    /**
     * 根据名称查询
     *
     * @param keyword
     * @param page
     * @param pageNum
     * @return
     */
    @Override
    public EtpEsDataDTO findByKeyword(String keyword, Integer page, Integer pageNum) throws ParseException {

        EtpEsDataDTO etpEsDataDTO = new EtpEsDataDTO();

        //获取查询
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("company").setTypes("etp")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        //需返回的字段
        searchRequestBuilder.setFetchSource(include, null);

        //名称查询
        SearchResponse response = searchRequestBuilder.setFrom(page * pageNum).setSize(pageNum).
                setQuery(QueryBuilders
                        .matchQuery("entName", keyword)).get();

        //返回空即返回
        if (null == response) {
            return null;
        }

        //取总数
        etpEsDataDTO.setTotal(response.getHits().totalHits);

        //取source中的数据
        Iterator<SearchHit> searchHitsIterator = response.getHits().iterator();

        //包装
        while (searchHitsIterator.hasNext()) {
            etpEsDataDTO.getCompanyList().add(new EtpEsDTO(searchHitsIterator.next().getSource()));
        }
        return etpEsDataDTO;
    }

    /**
     *
     * @param regionCode
     * @param startScore
     * @param endScore
     * @param industry
     * @param startReg
     * @param endReg
     * @param startCap
     * @param endCap
     * @param count
     * @return
     */
    @Override
    public EtpWhiteDataDTO findWhiteList(String regionCode, Integer startScore, Integer endScore, String industry, Integer startReg, Integer endReg, Integer startCap, Integer endCap, String count) {

        EtpWhiteDataDTO etpWhiteDataDTO = new EtpWhiteDataDTO();

        //获取查询
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("company").setTypes("etp").setFetchSource(true)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        //bool查询
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        //设置查询的字段
        searchRequestBuilder.setFetchSource(whiteList, null);

        //count 是数字
        if(NumberUtils.isNumber(count)){
            searchRequestBuilder.setFrom(0).setSize(Integer.parseInt(count));
        }else if("downLoad".equals(count)){
            searchRequestBuilder.setFrom(0).setSize(getCount(regionCode,startScore,endScore,industry,startReg,endReg,startCap,endCap));
        }else if("all".equals(count)){
            searchRequestBuilder.setFrom(0).setSize(getCount(regionCode,startScore,endScore,industry,startReg,endReg,startCap,endCap));
        }

        //区域代码
        if (!StringUtils.isEmpty(regionCode)) {
            queryBuilder.must(QueryBuilders.termQuery("countryCode.keyword", regionCode));
        }

        //判断行业字段是否存在
        if (!StringUtils.isEmpty(industry)) {
            queryBuilder.must(QueryBuilders.termQuery("category.keyword", industry));
        }

        //判断资本字段
        if (startCap != null && endCap != null) {

            queryBuilder.must(QueryBuilders.rangeQuery("regCapital").gte(startCap).lt(endCap));
        }

        //判断注册年限
        if (startReg != null && endReg != null) {
            queryBuilder.must(QueryBuilders.rangeQuery("regDate").gte(getRegDate(endReg)).lt(getRegDate(startReg)));
        }

        //返回数据
        SearchResponse response = searchRequestBuilder.setQuery(queryBuilder).get();

        //迭代数据
        Iterator<SearchHit> searchHitsIterator = response.getHits().iterator();

        //返回空即返回
        if (null == response) {
            return null;
        }

        etpWhiteDataDTO.setTotal(response.getHits().totalHits);
        //取数据
        while (searchHitsIterator.hasNext()) {
            etpWhiteDataDTO.getWhileList().add(new EtpWhiteDTO(searchHitsIterator.next().getSource()));
        }

        return etpWhiteDataDTO;
    }

    /**
     * 当前时间年份相减
     * @param reg
     * @return
     */
    private  String getRegDate(Integer reg){
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -reg);
        Date lo = calendar.getTime();
        return DateUtils.format(lo,"yyyy-MM-dd");
    }


    public int getCount(String regionCode, Integer startScore, Integer endScore, String industry, Integer startReg, Integer endReg, Integer startCap, Integer endCap) {


        //获取查询
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("company").setTypes("etp").setFetchSource(true)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        //bool查询
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        //设置查询的字段
        searchRequestBuilder.setFetchSource("", null);

        //区域代码
        if (!StringUtils.isEmpty(regionCode)) {
            queryBuilder.must(QueryBuilders.termQuery("countryCode.keyword", regionCode));
        }

        //判断行业字段是否存在
        if (!StringUtils.isEmpty(industry)) {
            queryBuilder.must(QueryBuilders.termQuery("category.keyword", industry));
        }

        //判断资本字段
        if (startCap != null && endCap != null) {

            queryBuilder.must(QueryBuilders.rangeQuery("regCapital").gte(startCap).lt(endCap));
        }

        //判断注册年限
        if (startReg != null && endReg != null) {
            queryBuilder.must(QueryBuilders.rangeQuery("regDate").gte(getRegDate(endReg)).lt(getRegDate(startReg)));
        }

        //返回数据
        SearchResponse response = searchRequestBuilder.setQuery(queryBuilder).get();

        //迭代数据
        Iterator<SearchHit> searchHitsIterator = response.getHits().iterator();

        //返回空即返回
        if (null == response) {
            return 0;
        }

        //总数
        return (int)response.getHits().totalHits;
    }

}
