package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.system.api.entity.SysCount;
import cn.bjd.platform.system.api.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/sys/count")
public class SysCountController extends BaseController {

    /**
     * 系统用户服务
     */
    @Autowired
    private ISystemService systemService;


    /**
     * 企业数据
     *
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/number")
    public Integer getDataForCompany() {
        List<String> list = new ArrayList<String>();
        list.add("ETPCOUNT");
        list.add("ETPAVG");
        list.add("ETPACC");
        list.add("REGYEAR");
        list.add("ENTCANCEL");
        list.add("ETPSUM");
        list.add("ETPADD");
        return systemService.countForCompany(list);
    }

    /**
     * 法律数据
     *
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/law")
    public Integer getDataForLaw() {
        List<String> list = new ArrayList<String>();
        list.add("COURTPUB");
        list.add("EXECUTED");
        list.add("COURT");
        list.add("BREAKFAITH");
        return systemService.countForCompany(list);
    }

    /**
     * 企业数量分区域统计
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/countByArea")
    public List<SysCount> getCountForCompanyArea(SysCount count) {

        //其余省市在页面传入
        List<SysCount> list = null;
        if (count == null) {
            count = new SysCount();
        }

        count.setCategory("ETPCOUNT");
        list = systemService.countGroupByProvinceAndCity(count);
        return list;
    }

    /**
     * 增长 消亡曲线
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/riseAndDiea")
    public Map<String, List<SysCount>> getCurveRiseAndDie(SysCount count) {
        Map<String, List<SysCount>> map = new HashMap<>();
        if (count == null) {
            count = new SysCount();
        }

        count = getLevel(count);
        //增长
        count.setCategory("ETPADD");
        //查询出增长曲线
        List<SysCount> riseList = systemService.countCompanyCommon(count);
        map.put("rise", riseList);
        count.setCategory("ENTCANCEL");
        List<SysCount> dieList = systemService.countCompanyCommon(count);
        map.put("die", dieList);
        return map;
    }


    public SysCount getLevel(SysCount count) {
        if (StringUtils.isEmpty(count.getProvince()) && StringUtils.isEmpty(count.getCity()) && StringUtils.isEmpty(count.getArea())) {
            count.setLevel(1);
        } else if (!StringUtils.isEmpty(count.getProvince()) && StringUtils.isEmpty(count.getCity()) && StringUtils.isEmpty(count.getArea())) {
            count.setLevel(1);
        } else if (!StringUtils.isEmpty(count.getProvince()) && !StringUtils.isEmpty(count.getCity()) && StringUtils.isEmpty(count.getArea())) {
            count.setLevel(2);
        } else if (!StringUtils.isEmpty(count.getProvince()) && !StringUtils.isEmpty(count.getCity()) && !StringUtils.isEmpty(count.getArea())) {
            count.setLevel(3);
        }
        return count;
    }

    /**
     * 企业历史数量分区域变化
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/hisChangeData")
    public Map<String, List<SysCount>> getCompanyHistoricalChangeData(SysCount count) {
        Map<String, List<SysCount>> map = null;
        if (count == null) {
            count = new SysCount();
        }
        count.setCategory("ETPLIVE");

        map = systemService.mapGroupByPlace(count);
        return map;
    }


    /**
     * 企业平均
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/avg")
    public Map<String, String> avg(SysCount count) {
        Map<String, String> map = new HashMap<>();
        if (count == null) {
            count = new SysCount();
        }
        count.setCategory("REGCAPITAL");//平均注册资本
        List<SysCount> capital = systemService.getCount(count);


        return map;
    }


    /**
     * 行业分类统计
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/industryClassify")
    public List<SysCount> getCountIndustryClassify(SysCount count) {
        List<SysCount> list = null;
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setCategory("INDUSTRY");
        list = systemService.countIndustryCustomsTaxTop(count);
        return list;
    }

    /**
     * top10
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/top10")
    public List<SysCount> getCountTop10(SysCount count) {
        List<SysCount> list = null;
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setCategory("INDUSTRY");
        count.setTop("10");
        list = systemService.countIndustryCustomsTaxTop(count);
        return list;
    }

    /**
     * 行业历史数据变化
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/industryHistoryClassify")
    public List<SysCount> getCountIndustryHistoryClassify(SysCount count) {
        List<SysCount> list = null;
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setCategory("INDUSTRY");
        list = systemService.industryHistoryByYear(count);
        return list;
    }

    /**
     * 涉诉信息统计
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/involveAppeal")
    public Map<String, List<SysCount>> getCountInvolvedInAppeal(SysCount count) {
        Map<String, List<SysCount>> map = new HashMap<>();
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setCategory("COURTPUB");
        List<SysCount> list1 = systemService.countDSelect(count);
        map.put("COURTPUB", list1);
        count.setCategory("EXECUTED");
        List<SysCount> list2 = systemService.countDSelect(count);
        map.put("EXECUTED", list2);
        count.setCategory("BREAKFAITH");
        List<SysCount> list3 = systemService.countDSelect(count);
        map.put("BREAKFAITH", list3);
        count.setCategory("COURT");
        List<SysCount> list4 = systemService.countDSelect(count);
        map.put("COURT", list4);
        return map;
    }

    /**
     * 违法统计
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/countIllegal")
    public Map<String, List<SysCount>> getCountIllegalStatistics(SysCount count) {
        Map<String, List<SysCount>> map = new HashMap<>();
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setType("D");
        count.setCategory("CUSTOMS");
        List<SysCount> list1 = systemService.countDSelect(count);
        map.put("CUSTOMS", list1);
        count.setCategory("TAX");
        List<SysCount> list2 = systemService.countDSelect(count);
        map.put("TAX", list2);
        return map;
    }

    /**
     * 涉诉信息历史变化
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/involveAppealHistory")
    public Map<String, List<SysCount>> getCountInvolvedInAppealHistory(SysCount count) {
        Map<String, List<SysCount>> map = new HashMap<>();
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setCategory("COURTPUBYEAR");
        List<SysCount> list1 = systemService.countCompanyCommon(count);
        map.put("COURTPUB", list1);
        count.setCategory("EXECUTEDYEAR");
        List<SysCount> list2 = systemService.countCompanyCommon(count);
        map.put("EXECUTED", list2);
        count.setCategory("BREAKFAITHYEAR");
        List<SysCount> list3 = systemService.countCompanyCommon(count);
        map.put("BREAKFAITH", list3);
        count.setCategory("COURTYEAR");
        List<SysCount> list4 = systemService.countCompanyCommon(count);
        map.put("COURT", list4);
        return map;
    }

    /**
     * 违法信息历史变化
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/countIllegalHistory")
    public Map<String, List<SysCount>> getCountIllegalStatisticsHistory(SysCount count) {
        Map<String, List<SysCount>> map = new HashMap<>();
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setType("D");
        count.setCategory("CUSTOMS");
        List<SysCount> list1 = systemService.countCompanyCommon(count);
        map.put("CUSTOMS", list1);
        count.setCategory("TAX");
        List<SysCount> list2 = systemService.countCompanyCommon(count);
        map.put("TAX", list2);
        return map;
    }

    /**
     * 海关企业评级
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/customsLevel")
    public List<SysCount> getCountCUSTOMSLevel(SysCount count) {
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setCategory("CUSTOMS");
        List<SysCount> list = systemService.countIndustryCustomsTaxTop(count);
        return list;
    }

    /**
     * 税务统计评级
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/taxLevel")
    public List<SysCount> getCountTAXLevel(SysCount count) {
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setCategory("TAX");
        List<SysCount> list = systemService.countIndustryCustomsTaxTop(count);
        return list;
    }


    /**
     * 海关历史评级
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/customsHistoryLevel")
    public List<SysCount> getCountCUSTOMSHistoryLevel(SysCount count) {
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setCategory("CUSTOMS");
        List<SysCount> list = systemService.countCustomsTaxGradeHistory(count);
        return list;
    }

    /**
     * 税务历史变化
     *
     * @param count
     * @return
     */
    @PreAuthorize("hasAuthority('sys:count:view')")
    @GetMapping(value = "/taxHistoryLevel")
    public List<SysCount> getCountTAXHistoryLevel(SysCount count) {
        if (count == null) {
            count = new SysCount();
        }
        count = getLevel(count);
        count.setCategory("TAX");
        List<SysCount> list = systemService.countCustomsTaxGradeHistory(count);
        return list;
    }

}