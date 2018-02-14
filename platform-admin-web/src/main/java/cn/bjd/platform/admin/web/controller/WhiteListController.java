package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.Dto.RegionDto;
import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.admin.web.security.model.AuthUser;
import cn.bjd.platform.admin.web.security.utils.TokenUtil;
import cn.bjd.platform.common.api.Paging;
import cn.bjd.platform.common.utils.DateHelper;
import cn.bjd.platform.common.utils.Exception.SystemException;
import cn.bjd.platform.common.utils.framework.ApiResponse;
import cn.bjd.platform.common.web.util.WebUtils;
import cn.bjd.platform.elastic.api.entity.dto.EtpDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpEsDataDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpWhiteDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpWhiteDataDTO;
import cn.bjd.platform.elastic.api.service.IElasticService;
import cn.bjd.platform.elastic.api.service.IEtpBOService;
import cn.bjd.platform.system.api.entity.SysIndustry;
import cn.bjd.platform.system.api.entity.SysRegion;
import cn.bjd.platform.system.api.service.ISystemService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 白名单Controller
 */
@Validated
@RestController
@RequestMapping("/v1")
public class WhiteListController extends BaseController {


    /**
     * Token工具
     */
    @Autowired
    private TokenUtil jwtTokenUtil;


    @Autowired
    private ISystemService systemService;

    @Autowired
    private IElasticService elasticService;

    @Autowired
    private IEtpBOService etpBOService;

    /**
     * 区域统计接口
     *
     * @param regionCode
     * @return
     */
    @GetMapping(value = "/region/{regionCode}/statistics")
    public ApiResponse regionStatistics(@PathVariable("regionCode") String regionCode) {
        ApiResponse response = ApiResponse.getInstances();


        SysRegion region = systemService.getRegionByCode(regionCode);
        if (null == region) {
            return response.error("404").setResult("code对应省市区不存在");
        }

        /* AuthUser user = WebUtils.getCurrentUser();*/
        /*Boolean b = systemService.findUserRegion(user.getId(),regionCode);
        if(b.booleanValue() == false){
            return response.error("404").setResult("无访问此区域权限");
        }*/

        return response.success().setResult(systemService.getDataForRegionByCode(regionCode));
    }

    /**
     * 企业查询接口
     *
     * @param name
     * @param page
     * @return
     */
    @GetMapping(value = "/company")
    public ApiResponse companyByName(String name, Paging page) {
        ApiResponse response = ApiResponse.getInstances();

        if (StringUtils.isEmpty(name)) {
            return response.error("001").setReason("暂未搜索到相关公司信息");
        }

        if (name.length() <= 1) {
            return response.error("001").setReason("暂未搜索到相关公司信息");
        }

        List<String> tempList = Arrays.asList(RegionDto.getSensitiveWords());
        if (tempList.contains(name)) {
            //敏感词 直接调回
            return response.error("001").setReason("查询条件敏感，禁止查询");
        }

        if (page.getPageSize() > 100) {
            //超过100 按照100条处理
            page.setPageSize(100);
        }

        EtpEsDataDTO dto = null;
        try {
            dto = elasticService.findByKeyword(name, page.getPageNum(), page.getPageSize());
        } catch (Exception e) {
            //无操作 暂时
        }
        return response.success().setResult(dto);
    }

    /**
     * 查询企业详细信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/company/{id}")
    public ApiResponse getCompanyById(@PathVariable("id") String id) {
        ApiResponse response = ApiResponse.getInstances();
        EtpDTO dto = etpBOService.findById(id);
        if (null == dto) {
            return response.error("404").setResult("查询不到此企业信息");
        }
        return response.success().setResult(etpBOService.findById(id));
    }

    /**
     * 子区域基本信息
     *
     * @param regionCode
     * @return
     */
    @GetMapping(value = "/region/{regionCode}/children")
    public ApiResponse getChildRegion(@PathVariable("regionCode") String regionCode) {

        ApiResponse response = ApiResponse.getInstances();
        SysRegion region = systemService.getRegionByCode(regionCode);
        if (null == region) {
            return response.error("404").setResult("code对应省市区不存在");
        }
        return response.success().setResult(systemService.getRegionAndChild(regionCode));
    }


    /**
     * 行业树
     *
     * @return
     */
    @GetMapping(value = "/industry/{regionCode}/tree")
    public ApiResponse getIndustryTree(@PathVariable("regionCode") String regionCode) {
        ApiResponse response = ApiResponse.getInstances();
        return response.success().setResult(systemService.getIndustryTree(regionCode));
    }

    /**
     * 白名单查询(其他参数暂时不考虑)
     *
     * @param regionCode
     * @param count
     * @return
     */
    @GetMapping(value = "/region/{regionCode}/whiteList")
    public ApiResponse getWhiteList(@PathVariable("regionCode") String regionCode, String count) throws ParseException,IOException {
        ApiResponse response = ApiResponse.getInstances();
        if (!NumberUtils.isNumber(regionCode)) {
            return response.error("405").setReason("参数无效");
        }
        if (!NumberUtils.isNumber(count) && !"all".equals(count) && "downLoad".equals(count)) {
            return response.error("405").setReason("参数无效");
        }
        SysRegion region = systemService.getRegionByCode(regionCode);
        if (null == region) {
            return response.error("404").setResult("code对应省市区不存在");
        }
        AuthUser user = WebUtils.getCurrentUser();
        Boolean b = systemService.findUserRegion(user.getId(), regionCode);
        if (b.booleanValue() == false) {
            return response.error("404").setResult("无访问此区域权限");
        }
        return response.success().setResult(elasticService.findWhiteList(regionCode, null, null, null, null, null, null, null, count));
    }

    /**
     * 导出接口
     *
     * @return
     */
    @GetMapping(value = "/company/{regionCode}/export")
    public ApiResponse downLoadFile(@PathVariable("regionCode") String regionCode,
                                    Integer minScore,
                                    Integer maxScore,
                                    String industryId,
                                    Integer startReg,
                                    Integer endReg,
                                    Integer startCap,
                                    Integer endCap,
                                    HttpServletResponse response) throws IOException, WriteException, ParseException {
        ApiResponse apiResponse = ApiResponse.getInstances();

        if ((minScore != null && minScore < 0) || (maxScore != null && maxScore < 0)) {
            return apiResponse.error("404").setReason("分数区间不能小于0");
        }

        //查询出数据 直接返回
        AuthUser user = WebUtils.getCurrentUser();
        Boolean b = systemService.findUserRegion(user.getId(), regionCode);
        if (b.booleanValue() == false) {
            return apiResponse.error("404").setReason("无访问此区域权限");
        }

        //根据industryId查询行业code
        if (!StringUtils.isEmpty(industryId)) {
            SysIndustry industry = systemService.getIndustry(industryId);
            if (industry != null) {
                String iPath = industry.getIPath();
                String[] res = iPath.split("/");
                industryId = res[res.length - 1];
            }
        }

        EtpWhiteDataDTO dto = elasticService.findWhiteList(regionCode, minScore, maxScore, industryId, startReg, endReg, startCap, endCap, "downLoad");
        if (null == dto) {
            return apiResponse.error("404").setReason("查询无企业");
        }

        List<EtpWhiteDTO> list = dto.getWhileList();
        if (CollectionUtils.isEmpty(list)) {
            return apiResponse.error("404").setReason("查询无企业数据");
        }
        OutputStream os = null;
        WritableWorkbook book = null;
        PrintWriter out = null;
        try {
            os = response.getOutputStream();// 取得输出流
            response.reset();// 清空输出流
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("企业详情.xls", "utf-8"));
            response.setContentType("application/msexcel");// 定义输出类型
            book = Workbook.createWorkbook(os);
            WritableSheet sheet = book.createSheet("企业白名单信息", 0);
            //第一列中文显示信息
            String[] columns = {"企业名称", "行业门类", "行业大类", "行业中类", "企业所在经度", "企业所在纬度", "具体地址", "企业法人", "注册时间", "注册资本(万)"};
            for (int i = 0; i < columns.length; i++) {
                sheet.addCell(new Label(i, 0, columns[i]));
            }
            //行业名称从缓存中去查询
            //加载行业list去缓存

            Map<String, String> map = jwtTokenUtil.getIndustryDetails();
            if (map == null || map.isEmpty()) {
                map = new HashMap<>();
                List<SysIndustry> industryList = systemService.findIndustry();
                for (SysIndustry industry : industryList) {
                    map.put(industry.getIPath(), industry.getName());
                }
                jwtTokenUtil.putIndustryList(industryList);
            }

            for (int i = 0; i < list.size(); i++) {
                sheet.addCell(new Label(0, i + 1, list.get(i).getEntName()));
                sheet.addCell(new Label(1, i + 1, map.isEmpty() ? "" : map.get(list.get(i).getCategory())));
                sheet.addCell(new Label(2, i + 1, map.isEmpty() ? "" : map.get(list.get(i).getCategory() + "/" + list.get(i).getBigCategory())));
                sheet.addCell(new Label(3, i + 1, map.isEmpty() ? "" : map.get(list.get(i).getCategory() + "/" + list.get(i).getBigCategory() + "/" + list.get(i).getMiddleCategroy())));


                sheet.addCell(new Label(4, i + 1, String.valueOf(list.get(i).getLng())));
                sheet.addCell(new Label(5, i + 1, String.valueOf(list.get(i).getLat())));
                sheet.addCell(new Label(6, i + 1, list.get(i).getAddress()));
                sheet.addCell(new Label(7, i + 1, list.get(i).getLegalRep()));
                sheet.addCell(new Label(8, i + 1, list.get(i).getRegDate() == null ? "" : DateHelper.formatDate(list.get(i).getRegDate())));
                sheet.addCell(new Label(9, i + 1, list.get(i).getRegCapital() == null ? "" : String.valueOf(list.get(i).getRegCapital())));
            }

            book.write();
            response.flushBuffer();
            out = response.getWriter();
        } catch (Exception e) {
            throw new SystemException("导出失败");
        } finally {
            if (null != book) {
                book.close();
            }
            if (null != os) {
                os.flush();
                os.close();
            }

            if (null != out) {
                out.flush();
                out.close();
            }

        }

        return null;

    }

}