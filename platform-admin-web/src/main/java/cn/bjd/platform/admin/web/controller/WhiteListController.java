package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.admin.web.security.utils.TokenUtil;
import cn.bjd.platform.common.api.Paging;
import cn.bjd.platform.common.utils.Exception.SystemException;
import cn.bjd.platform.common.utils.framework.ApiResponse;
import cn.bjd.platform.elastic.api.entity.dto.EtpEsDataDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpWhiteDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpWhiteDataDTO;
import cn.bjd.platform.elastic.api.service.IElasticService;
import cn.bjd.platform.elastic.api.service.IEtpBOService;
import cn.bjd.platform.system.api.service.ISystemService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

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

    /**
     * 白名单查询(其他参数暂时不考虑)
     * @param regionCode
     * @param count
     * @return
     */
    @GetMapping(value = "/region/{regionCode}/whiteList")
    public ApiResponse getWhiteList(@PathVariable("regionCode") String regionCode,String count){
        ApiResponse response = ApiResponse.getInstances();
        return response.success().setResult(elasticService.findWhiteList(regionCode,null,null,null,null,null,null,null,count));
    }

    /**
     * 导出接口
     * @return
     */
    @GetMapping(value = "/company/{regionCode}/export")
    public void downLoadFile(@PathVariable("regionCode") String regionCode,
                              Integer minScore,
                              Integer maxScore,
                              String industryId,
                              Integer startReg,
                              Integer endReg,
                              Integer startCap,
                              Integer endCap,
                              HttpServletResponse response) throws IOException,WriteException{
        //查询出数据 直接返回
        EtpWhiteDataDTO dto = elasticService.findWhiteList(regionCode,minScore,maxScore,industryId,startReg,endReg,startCap,endCap,"downLoad");
        if(null == dto){
            throw new SystemException("查询无数据");
        }

        List<EtpWhiteDTO> list = dto.getWhileList();
        if(CollectionUtils.isEmpty(list)){
            throw new SystemException("查询无企业数据");
        }
        OutputStream os = null;
        WritableWorkbook book = null;
        PrintWriter out = null;
        try{
            os = response.getOutputStream();// 取得输出流
            response.reset();// 清空输出流
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("企业详情.xls", "utf-8"));
            response.setContentType("application/msexcel");// 定义输出类型
            book = Workbook.createWorkbook(os);
            WritableSheet sheet = book.createSheet("企业白名单信息", 0);
            //第一列中文显示信息
            String[] columns = {"序号","企业类型","企业所在经度","企业所在纬度"};
            for (int i = 0; i < columns.length; i++) {
                sheet.addCell(new Label(i,0,columns[i]));
            }

            for(int i=0;i<list.size();i++){
                sheet.addCell(new Label(0,i+1,list.get(i).getId()));
                sheet.addCell(new Label(1,i+1,list.get(i).getCategory()));
                sheet.addCell(new Label(2,i+1,String.valueOf(list.get(i).getLat())));
                sheet.addCell(new Label(3,i+1,String.valueOf(list.get(i).getLng())));
            }

            book.write();
            response.flushBuffer();
            out = response.getWriter();
        }catch (Exception e){
            throw new SystemException("导出失败");
        }finally {
            if(null != book){
                book.close();
            }
            if(null != os){
                os.flush();
                os.close();
            }

            if(null != out){
                out.flush();
                out.close();
            }

        }



    }

}