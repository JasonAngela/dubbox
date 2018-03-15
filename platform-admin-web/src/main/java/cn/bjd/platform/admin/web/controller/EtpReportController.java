package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.Dto.EtpPlatformDto;
import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.admin.web.pdf.PDFKit;
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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;


@Validated
@RestController
@RequestMapping("/v1/etp")
public class EtpReportController extends BaseController {

    @Autowired
    private IEtpBOService etpBOService;

    @Autowired
    private IIndustryBOService industryBOService;



    @GetMapping(value = "/{etpId}/read")
    public ApiResponse read(@PathVariable("etpId") String etpId) {
        ApiResponse response = ApiResponse.getInstances();
        ReadDTO dto = etpBOService.findReadByEtpId(etpId);
        return response.success().setResult(dto);
    }

    @GetMapping(value = "/{etpId}/basicInformation")
    public ApiResponse basic(@PathVariable("etpId") String etpId) {
        ApiResponse response = ApiResponse.getInstances();
        EtpBasicDTO dto = etpBOService.findBasicById(etpId);
        return response.success().setResult(dto);
    }

    @GetMapping(value = "/{etpId}/aptitude")
    public ApiResponse aptitude(@PathVariable("etpId") String etpId) {
        ApiResponse response = ApiResponse.getInstances();
        EtpAptitudeDTO dto = etpBOService.findEtpAptitudeById(etpId);
        return response.success().setResult(dto);
    }

    @GetMapping(value = "/{etpId}/riskInformation")
    public ApiResponse risk(@PathVariable("etpId") String etpId) {
        ApiResponse response = ApiResponse.getInstances();
        RiskDTO dto = etpBOService.findRiskById(etpId);
        return response.success().setResult(dto);
    }

    @GetMapping(value = "/{etpId}/industry")
    public ApiResponse industry(@PathVariable("etpId") String etpId) {
        ApiResponse response = ApiResponse.getInstances();
        IndustryDTO dto = industryBOService.findIndustryById(etpId);
        return response.success().setResult(dto);
    }


    @GetMapping(value = "/{etpId}/atlas")
    public ApiResponse atlas(@PathVariable("etpId") String etpId) {
        ApiResponse response = ApiResponse.getInstances();
        /*IndustryDTO dto = industryBOService.findIndustryById(etpId);*/
        AtlasDTO dto = etpBOService.findAtlasById(etpId);
        return response.success().setResult(dto);
    }

    @GetMapping(value = "/{etpId}/report/download")
    public ApiResponse downLoadEtpReport(@PathVariable("etpId") String etpId, HttpServletResponse downResponse) throws ParseException, IOException {
        ApiResponse response = ApiResponse.getInstances();

        ReadDTO dto = etpBOService.findReadByEtpId(etpId);
        EtpBasicDTO basicDto = etpBOService.findBasicById(etpId);
        EtpAptitudeDTO aptitudeDto = etpBOService.findEtpAptitudeById(etpId);
        RiskDTO riskDto = etpBOService.findRiskById(etpId);
        IndustryDTO industryDTO = industryBOService.findIndustryById(etpId);
        AtlasDTO atlasDTO = etpBOService.findAtlasById(etpId);


        EtpPlatformDto etpDto = new EtpPlatformDto();
        etpDto.setRead(dto);
        etpDto.setBasic(basicDto);
        etpDto.setAptitude(aptitudeDto);
        etpDto.setRisk(riskDto);
        etpDto.setIndustry(industryDTO);
        etpDto.setAtlas(atlasDTO);


        //dto包含就可以了
        PDFKit kit = new PDFKit();
        kit.setSaveFilePath(System.getProperty("java.io.tmpdir") + File.separator + "etp2.pdf");
        String saveFilePath = kit.exportToFile("etp2.pdf", etpDto);
        //模板接受
        File f = new File(saveFilePath);
        if (f.exists()) {
            FileInputStream fis = new FileInputStream(f);
            String filename = URLEncoder.encode(f.getName(), "utf-8"); //解决中文文件名下载后乱码的问题
            byte[] b = new byte[fis.available()];
            fis.read(b);
            downResponse.setCharacterEncoding("utf-8");
            downResponse.setHeader("Content-Disposition", "attachment; filename=" + filename);
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
        return response.success().setResult("下载成功");
    }
}