package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.admin.web.security.utils.TokenUtil;
import cn.bjd.platform.common.api.Paging;
import cn.bjd.platform.common.utils.framework.ApiResponse;
import cn.bjd.platform.elastic.api.entity.dto.EtpEsDataDTO;
import cn.bjd.platform.elastic.api.service.IElasticService;
import cn.bjd.platform.elastic.api.service.IEtpBOService;
import cn.bjd.platform.system.api.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 白名单Controller
 *
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
     * @param regionCode
     * @return
     */
    @GetMapping(value = "/region/{regionCode}/statistics")
    public ApiResponse regionStatistics(@PathVariable("regionCode") String regionCode){
        ApiResponse response = ApiResponse.getInstances();
        return response.success().setResult(systemService.getDataForRegionByCode(regionCode));
    }

    /**
     * 企业查询接口
     * @param name
     * @param page
     * @return
     */
    @GetMapping(value = "/company")
    public ApiResponse companyByName(String name,Paging page){
        ApiResponse response = ApiResponse.getInstances();
        EtpEsDataDTO dto = null;
        try{
            dto = elasticService.findByKeyword(name,page.getPageNum(),page.getPageSize());
        }catch (Exception e){
            //无操作 暂时
        }
        return response.success().setResult(dto);
    }

    /**
     * 查询企业详细信息
     * @param id
     * @return
     */
    @GetMapping(value = "/company/{id}")
    public ApiResponse getCompanyById(@PathVariable("id") String id){
        ApiResponse response = ApiResponse.getInstances();
        return response.success().setResult(etpBOService.findById(id));
    }

    /**
     * 子区域基本信息
     * @param regionCode
     * @return
     */
    @GetMapping(value = "/region/{regionCode}/children")
    public ApiResponse getChildRegion(@PathVariable("regionCode") String regionCode){
        ApiResponse response = ApiResponse.getInstances();
        return response.success().setResult(systemService.getRegionAndChild(regionCode));
    }


    /**
     * 行业树
     * @return
     */
    @GetMapping(value = "/industry/tree")
    public ApiResponse getIndustryTree(){
        ApiResponse response = ApiResponse.getInstances();
        return response.success().setResult(systemService.getIndustryTree());
    }




}