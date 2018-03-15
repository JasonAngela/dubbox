package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.Dto.RegionDto;
import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.admin.web.pdf.PDFKit;
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
import cn.bjd.platform.system.api.entity.DataForRegion;
import cn.bjd.platform.system.api.entity.POJO.*;
import cn.bjd.platform.system.api.entity.SysCount;
import cn.bjd.platform.system.api.entity.SysIndustry;
import cn.bjd.platform.system.api.entity.SysRegion;
import cn.bjd.platform.system.api.service.ISystemService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

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
    public ApiResponse regionStatistics(@PathVariable("regionCode") String regionCode) throws ParseException, IOException {
        ApiResponse response = ApiResponse.getInstances();


        SysRegion region = systemService.getRegionByCode(regionCode);
        if (null == region) {
            return response.error("404").setResult("code对应省市区不存在");
        }

        DataForRegion data = systemService.getDataForRegionByCode(regionCode);

        return response.success().setResult(data);
    }


    /**
     * @param regionCode
     * @return
     */
    @GetMapping(value = "/region/{regionCode}/report")
    public ApiResponse getRegionReport(@PathVariable("regionCode") String regionCode) throws ParseException, IOException {
        ApiResponse response = ApiResponse.getInstances();

        SysRegion region = systemService.getRegionByCode(regionCode);
        if (null == region) {
            return response.error("404").setResult("code对应省市区不存在");
        }

        DataForRegion data = systemService.getDataForRegionByCode(regionCode);
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数

        //显然行业百分比计算

        data.setArea(region.getName());

        SysIndustry industry = new SysIndustry();
        industry.setArea(region.getName());
        industry.setLimitList(RegionDto.getLimitIndustryList());


        if (regionCode.substring(regionCode.length() - 4).equals("0000")) {
            //选择的是省
            industry.setLevel(1);
        } else if (regionCode.substring(regionCode.length() - 2).equals("00")) {
            industry.setLevel(2);
        } else {
            industry.setLevel(3);
        }
        Integer count = systemService.industryCount(industry);


        Limit limit = new Limit();
        limit.setCount(count);

        industry.setLimitList(null);
        Integer allCount = Integer.parseInt(data.getCount()) - count;
        limit.setAllCount(allCount);

        if (allCount != null && allCount.compareTo(0) != 0) {
            limit.setIndex(df.format((float) count / Integer.parseInt(data.getCount()) * 100) + "%");
        }

        data.getRegion().setLimit(limit);

        //调用白名单方法查询个数即可
        Register register = new Register();
        RegisterCapital capital = new RegisterCapital();

        Long totalCount = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, null, null);
        Long more20Millon = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, 2000, null);
        Long between10And20Millon = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, 1000, 2000);
        Long between8And10Millon = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, 800, 1000);
        Long between6And8Millon = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, 600, 800);
        Long between5And6Millon = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, 500, 600);
        Long between3And5Millon = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, 300, 500);
        Long between2And3Millon = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, 200, 300);
        Long between1And2Millon = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, 100, 200);
        Long between500And1000Thousand = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, 50, 100);
        Long lessThan500Thousand = elasticService.findWhiteCount(region.getName(), null, null, null, null, null, null, 50);


        capital.setMore20Millon(totalCount == 0L ? "0%" : df.format(((float) more20Millon / totalCount) * 100) + "%");
        capital.setBetween10And20Millon(totalCount == 0L ? "0%" : df.format(((float) between10And20Millon / totalCount) * 100) + "%");
        capital.setBetween8And10Millon(totalCount == 0L ? "0%" : df.format(((float) between8And10Millon / totalCount) * 100) + "%");
        capital.setBetween6And8Millon(totalCount == 0L ? "0%" : df.format(((float) between6And8Millon / totalCount) * 100) + "%");
        capital.setBetween5And6Millon(totalCount == 0L ? "0%" : df.format(((float) between5And6Millon / totalCount) * 100) + "%");
        capital.setBetween3And5Millon(totalCount == 0L ? "0%" : df.format(((float) between3And5Millon / totalCount) * 100) + "%");
        capital.setBetween2And3Millon(totalCount == 0L ? "0%" : df.format(((float) between2And3Millon / totalCount) * 100) + "%");
        capital.setBetween1And2Millon(totalCount == 0L ? "0%" : df.format(((float) between1And2Millon / totalCount) * 100) + "%");
        capital.setBetween500And1000Thousand(totalCount == 0L ? "0%" : df.format(((float) between500And1000Thousand / totalCount) * 100) + "%");
        capital.setLessThan500Thousand(totalCount == 0L ? "0%" : df.format(((float) lessThan500Thousand / totalCount) * 100) + "%");
        register.setRegisterCapital(capital);

        RegisterTime time = new RegisterTime();
        time.setMore10Year(totalCount == 0L ? "0%" : df.format(((float) elasticService.findWhiteCount(region.getName(), null, null, null, 10, null, null, null) / totalCount) * 100) + "%");
        time.setBetween9And10Year(totalCount == 0L ? "0%" : df.format(((float) elasticService.findWhiteCount(region.getName(), null, null, null, 8, 10, null, null) / totalCount) * 100) + "%");
        time.setBetween7And8Year(totalCount == 0L ? "0%" : df.format(((float) elasticService.findWhiteCount(region.getName(), null, null, null, 6, 8, null, null) / totalCount) * 100) + "%");
        time.setBetween5And6Year(totalCount == 0L ? "0%" : df.format(((float) elasticService.findWhiteCount(region.getName(), null, null, null, 4, 6, null, null) / totalCount) * 100) + "%");
        time.setBetween3And4Year(totalCount == 0L ? "0%" : df.format(((float) elasticService.findWhiteCount(region.getName(), null, null, null, 2, 4, null, null) / totalCount) * 100) + "%");
        time.setBetween1And2Year(totalCount == 0L ? "0%" : df.format(((float) elasticService.findWhiteCount(region.getName(), null, null, null, 1, 2, null, null) / totalCount) * 100) + "%");
        time.setLessThanOneYear(totalCount == 0L ? "0%" : df.format(((float) elasticService.findWhiteCount(region.getName(), null, null, null, null, 1, null, null) / totalCount) * 100) + "%");

        register.setRegisterTime(time);
        data.setRegister(register);

        GrowthAndDie growthAndDie = new GrowthAndDie();

        SysCount sysCount = new SysCount();
        //分别放省市区即可
        if (regionCode.substring(regionCode.length() - 4).equals("0000")) {
            //选择的是省
            sysCount.setProvince(region.getName());
            sysCount.setLevel(1);
        } else if (regionCode.substring(regionCode.length() - 2).equals("00")) {
            sysCount.setCity(region.getName());
            sysCount.setLevel(2);
        } else {
            sysCount.setArea(region.getName());
            sysCount.setLevel(3);
        }


        // sysCount.setArea(region.getName());
        //增长
        sysCount.setCategory("ETPADD");
        sysCount.setYear(11);
        sysCount.setTop(11);
        //查询出增长曲线
        List<SysCount> riseList = systemService.countCompanyCommon(sysCount);
        growthAndDie.setGrowthCurve(basicModelList(riseList));

        sysCount.setCategory("ENTCANCEL");
        List<SysCount> dieList = systemService.countCompanyCommon(sysCount);
        growthAndDie.setDieCurve(basicModelList(dieList));

        data.setGrowthAndDie(growthAndDie);


        Illegal illegal = new Illegal();

        //查询出11年的 因为需要得到增长率  必须查询出上一年的数据即可
        sysCount.setTop(4);
        sysCount.setCategory("COURTPUBYEAR");
        List<SysCount> list1 = systemService.countCompanyCommon(sysCount);
        illegal.setCourtPub(basicModelList(list1));

        sysCount.setCategory("EXECUTEDYEAR");
        List<SysCount> list2 = systemService.countCompanyCommon(sysCount);
        illegal.setExecuted(basicModelList(list2));

        sysCount.setCategory("BREAKFAITHYEAR");
        List<SysCount> list3 = systemService.countCompanyCommon(sysCount);
        illegal.setBreakFaith(basicModelList(list3));

        sysCount.setCategory("COURTYEAR");
        List<SysCount> list4 = systemService.countCompanyCommon(sysCount);
        illegal.setCourt(basicModelList(list4));


        data.setIllegal(illegal);

        return response.success().setResult(data);
    }


    List<BasicModel> basicModelList(List<SysCount> list) {
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        List<BasicModel> modelList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size() - 1; i++) {
                BasicModel model = new BasicModel();
                model.setValue(list.get(i).getValue());
                model.setRate(df.format(Double.parseDouble(list.get(i).getValue()) / 100) + "%");
                model.setYear(list.get(i).getYear());
                SysCount bCount = list.get(i + 1);
                if (bCount != null && !bCount.getValue().equals("0")) {
                    Integer aCount = Integer.parseInt(list.get(i).getValue());
                    Integer beCount = Integer.parseInt(bCount.getValue());
                    //model.setRate(df.format(((float) (aCount - beCount)  / beCount) * 100) + "%");
                }
                modelList.add(model);
            }
        }

        return modelList;
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
    public ApiResponse getIndustryTree(@PathVariable("regionCode") String regionCode, String type) {
        ApiResponse response = ApiResponse.getInstances();
        return response.success().setResult(systemService.getIndustryTree(regionCode, type));
    }

    /**
     * 白名单查询(其他参数暂时不考虑)
     *
     * @param regionCode
     * @param count
     * @return
     */
    @GetMapping(value = "/region/{regionCode}/whiteList")
    public ApiResponse getWhiteList(@PathVariable("regionCode") String regionCode, String count) throws ParseException, IOException {
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
        return response.success().setResult(elasticService.findWhiteList(region.getName(), null, null, null, null, null, null, null, count));
    }


    @PostMapping(value = "/region/{regionCode}/highRank")
    public ApiResponse getHighRank(@PathVariable("regionCode") String regionCode, @Valid @RequestBody RegionDto dto) throws ParseException, IOException {
        ApiResponse response = ApiResponse.getInstances();
        if (!NumberUtils.isNumber(regionCode)) {
            return response.error("405").setReason("参数无效");
        }

        if (!NumberUtils.isNumber(dto.getCount()) && !"all".equals(dto.getCount()) && "downLoad".equals(dto.getCount())) {
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

        List<String> industryIds = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dto.getIndustrys())) {
            Map<String, String> map = getIndustryIdIpathMap();
            for (String str : dto.getIndustrys()) {
                industryIds.add(map.isEmpty() ? "" : map.get(str).substring(map.get(str).lastIndexOf("/") + 1));
            }
        }

        return response.success().setResult(elasticService.findWhiteList(region.getName(), null, null, industryIds, null, null, null, null, dto.getCount()));
    }

    Map<String, String> getIndustryIdIpathMap() {
        Map<String, String> map = jwtTokenUtil.getIndustryIdIpathMap();
        if (map == null || map.isEmpty()) {
            map = new HashMap<>();
            List<SysIndustry> industryList = systemService.findIndustry();
            for (SysIndustry industry : industryList) {
                map.put(industry.getId(), industry.getIPath());
            }
            jwtTokenUtil.putIndustryIdIpathMap(industryList);
        }
        return map;
    }


    Map<String, String> getIndustryMap() {
        Map<String, String> map = jwtTokenUtil.getIndustryDetails();
        if (map == null || map.isEmpty()) {
            map = new HashMap<>();
            List<SysIndustry> industryList = systemService.findIndustry();
            for (SysIndustry industry : industryList) {
                map.put(industry.getIPath(), industry.getName());
            }
            jwtTokenUtil.putIndustryList(industryList);
        }
        return map;
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
        List<String> industryIds = new ArrayList<>();
        if (!StringUtils.isEmpty(industryId)) {
            SysIndustry industry = systemService.getIndustry(industryId);
            if (industry != null) {
                String iPath = industry.getIPath();
                String[] res = iPath.split("/");
                industryId = res[res.length - 1];
                industryIds.add(industryId);
            }
        }


        SysRegion region = systemService.getRegionByCode(regionCode);
        if (null == region) {
            return apiResponse.error("404").setResult("code对应省市区不存在");
        }

        EtpWhiteDataDTO dto = elasticService.findWhiteList(region.getName(), minScore, maxScore, industryIds, startReg, endReg, startCap, endCap, "downLoad");

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

            Map<String, String> map = getIndustryMap();

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

    /**
     * 下载区域报表
     *
     * @param regionCode
     * @return
     */
    @GetMapping(value = "/region/{regionCode}/report/dowload")
    public ApiResponse downLoadRegionReport(@PathVariable("regionCode") String regionCode, HttpServletResponse downResponse) throws ParseException, IOException {
        ApiResponse response = ApiResponse.getInstances();

        SysRegion region = systemService.getRegionByCode(regionCode);
        if (null == region) {
            return response.error("404").setResult("code对应省市区不存在");
        }

        //获取具体区域信息
        ApiResponse res = getRegionReport(regionCode);
        if (res != null && res.getResult() != null) {
            DataForRegion data = (DataForRegion) res.getResult();
            PDFKit kit = new PDFKit();

            kit.setSaveFilePath(System.getProperty("java.io.tmpdir") + File.separator + "region.pdf");
            String saveFilePath = kit.exportToFile("region.pdf", data);

            File f = new File(saveFilePath);
            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                String filename = URLEncoder.encode(f.getName(), "utf-8"); //解决中文文件名下载后乱码的问题
                byte[] b = new byte[fis.available()];
                fis.read(b);
                downResponse.setCharacterEncoding("utf-8");
                downResponse.setHeader("Content-Disposition", "attachment; filename=" + filename + "");
                downResponse.setContentType("application/pdf");
                //获取响应报文输出流对象
                ServletOutputStream out = downResponse.getOutputStream();
                //输出
                fis.close();
                out.write(b);
                out.flush();
                out.close();
                //下载后 删除文件
            }
        }

        return response.success().setResult("下载成功");
    }


}