package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.common.utils.framework.ApiResponse;
import cn.bjd.platform.elastic.api.entity.dto.*;
import cn.bjd.platform.elastic.api.service.IEtpBOService;
import cn.bjd.platform.elastic.api.service.IIndustryBOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Validated
@RestController
@RequestMapping("/v1/etp")
public class EtpReportController extends BaseController {

    @Autowired
    private IEtpBOService etpBOService;

    @Autowired
    private IIndustryBOService industryBOService;

    @GetMapping(value = "/{etpId}/read")
    public ApiResponse read(@PathVariable("etpId") String etpId){
        ApiResponse response = ApiResponse.getInstances();
        ReadDTO dto = etpBOService.findReadByEtpId(etpId);
        return response.success().setResult(dto);
    }

    @GetMapping(value = "/{etpId}/basicInformation")
    public ApiResponse basic(@PathVariable("etpId") String etpId){
        ApiResponse response = ApiResponse.getInstances();
        EtpBasicDTO dto = etpBOService.findBasicById(etpId);
        return response.success().setResult(dto);
    }

    @GetMapping(value = "/{etpId}/aptitude")
    public ApiResponse aptitude(@PathVariable("etpId") String etpId){
        ApiResponse response = ApiResponse.getInstances();
        EtpAptitudeDTO dto = etpBOService.findEtpAptitudeById(etpId);
        return response.success().setResult(dto);
    }

    @GetMapping(value = "/{etpId}/riskInformation")
    public ApiResponse risk(@PathVariable("etpId") String etpId){
        ApiResponse response = ApiResponse.getInstances();
        RiskDTO dto = etpBOService.findRiskById(etpId);
        return response.success().setResult(dto);
    }

    @GetMapping(value = "/{etpId}/industry")
    public ApiResponse industry(@PathVariable("etpId") String etpId){
        ApiResponse response = ApiResponse.getInstances();
        IndustryDTO dto = industryBOService.findIndustryById(etpId);
        return response.success().setResult(dto);
    }


    @GetMapping(value = "/{etpId}/atlas")
    public ApiResponse atlas(@PathVariable("etpId") String etpId){
        ApiResponse response = ApiResponse.getInstances();
        /*IndustryDTO dto = industryBOService.findIndustryById(etpId);*/
        AtlasDTO dto = etpBOService.findAtlasById(etpId);
        return response.success().setResult(dto);
    }

}