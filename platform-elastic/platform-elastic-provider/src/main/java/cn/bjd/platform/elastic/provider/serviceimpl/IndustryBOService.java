package cn.bjd.platform.elastic.provider.serviceimpl;


import cn.bjd.platform.elastic.api.entity.Etp;
import cn.bjd.platform.elastic.api.entity.Industry;
import cn.bjd.platform.elastic.api.entity.IndustrySeason;
import cn.bjd.platform.elastic.api.entity.IndustryTj;
import cn.bjd.platform.elastic.api.entity.IndustryTjType;
import cn.bjd.platform.elastic.api.entity.IndustryTz;
import cn.bjd.platform.elastic.api.entity.dto.IndustryDTO;
import cn.bjd.platform.elastic.api.service.IIndustryBOService;
import cn.bjd.platform.elastic.provider.mapper.EtpMapper;
import cn.bjd.platform.elastic.provider.mapper.IndustryMapper;
import cn.bjd.platform.elastic.provider.mapper.IndustrySeasonMapper;
import cn.bjd.platform.elastic.provider.mapper.IndustryTjMapper;
import cn.bjd.platform.elastic.provider.mapper.IndustryTjTypeMapper;
import cn.bjd.platform.elastic.provider.mapper.IndustryTzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11.
 */
@Service
@Transactional(readOnly = true)
public class IndustryBOService implements IIndustryBOService {

    /**
     * 企业基本信息
     */
    @Autowired
    private EtpMapper etpMapper;

    /**
     * 行业信息
     */
    @Autowired
    private IndustryMapper industryMapper;

    /**
     * 行业季节性波动
     */
    @Autowired
    private IndustrySeasonMapper industrySeasonMapper;

    /**
     * 产业链内部关联特征
     */
    @Autowired
    private IndustryTzMapper industryTzMapper;

    /**
     *
     */
    @Autowired
    private IndustryService industryService;

    /**
     * 产业各项经济指标
     */
    @Autowired
    private IndustryTjMapper industryTjMapper;

    /**
     * industryTjTypeMapper
     */
    @Autowired
    private IndustryTjTypeMapper industryTjTypeMapper;

    /**
     * 通过企业id获取行业信息
     *
     * @param id
     * @return EtpIndustryDTO
     */
    @Override
    public IndustryDTO findIndustryById(String id) {
        IndustryDTO industryDTO = new IndustryDTO();
        //企业信息
        Etp etp = etpMapper.findById(id);
        if (etp != null) {

            //企业对应的行业信息
            Industry industry = industryMapper.selectByPrimaryKey(etp.getIndustryId());

            if (industry == null) {
                return null;
            }

            //行业表现
            IndustryTjType industryTjTypeYs = industryTjTypeMapper.findIdByName("应收账款周转率（次）");
            IndustryTjType industryTjTypeCh = industryTjTypeMapper.findIdByName("存货周转率（次）");
            IndustryTj ysModel = industryTjMapper.findModel(industryTjTypeYs.getId(), etp.getIndustryId());
            IndustryTj chModel = industryTjMapper.findModel(industryTjTypeCh.getId(), etp.getIndustryId());

            //应收账款账期
            Double yszk = 0.00;
            if (ysModel != null && ysModel.getvAvg16() > 0) {
                yszk = 360 / ysModel.getvAvg16();
            }

            //存货周转时长
            Double chzz = 0.00;
            if (chModel != null && chModel.getvAvg16() > 0) {
                chzz = 360 / chModel.getvAvg16();
            }

            //行业平均税负
            Double addedTax = 0.00;
            if (industry.getAddedTax() != null) {
                addedTax = industry.getAddedTax().doubleValue();
            }

            //人工成本/营业收入
            Double rgcb = 0.00;
            if (industry.getRgcbZb() != null) {
                rgcb = industry.getRgcbZb().doubleValue();
            }

            //行业对应的季节性波动
            IndustrySeason industrySeason = industrySeasonMapper.findById(industry.getSeasonId());

            //为null赋值0
            if (industrySeason!=null){
                industrySeason = giveNum(industrySeason);
            }

            //产业链图片
            String hyImg = industry.getHyImg();

            //产业链内部关联特征
            List<IndustryTz> industryTzList = industryTzMapper.findByTzCode(industry.getTzCode());

            //完成行业信息转义
            String typeXxl = industryService.getCategory(etp.getIndustryPhy());

            //产业各项经济指标
            List<IndustryTj> industryTjList = industryTjMapper.findByTypeXxl(typeXxl);

            industryDTO.setId(id);
            industryDTO.setYszk(yszk);
            industryDTO.setChzz(chzz);
            industryDTO.setAddedTax(addedTax);
            industryDTO.setRgcb(rgcb);
            industryDTO.setHyImg(hyImg);
            industryDTO.setIndustrySeason(industrySeason);
            industryDTO.setIndustryTjList(industryTjList);
            industryDTO.setIndustryTzList(industryTzList);
        }


        return industryDTO;
    }

    /**
     * 为null赋值0
     *
     * @param industrySeason
     * @return IndustrySeason
     */
    private IndustrySeason giveNum(IndustrySeason industrySeason) {
        if (industrySeason.getM1() == null) {
            industrySeason.setM1(0.00);
        }
        if (industrySeason.getM2() == null) {
            industrySeason.setM2(0.00);
        }
        if (industrySeason.getM3() == null) {
            industrySeason.setM3(0.00);
        }
        if (industrySeason.getM4() == null) {
            industrySeason.setM4(0.00);
        }
        if (industrySeason.getM5() == null) {
            industrySeason.setM5(0.00);
        }
        if (industrySeason.getM6() == null) {
            industrySeason.setM6(0.00);
        }
        if (industrySeason.getM7() == null) {
            industrySeason.setM7(0.00);
        }
        if (industrySeason.getM8() == null) {
            industrySeason.setM8(0.00);
        }
        if (industrySeason.getM9() == null) {
            industrySeason.setM9(0.00);
        }
        if (industrySeason.getM10() == null) {
            industrySeason.setM10(0.00);
        }
        if (industrySeason.getM11() == null) {
            industrySeason.setM11(0.00);
        }
        if (industrySeason.getM12() == null) {
            industrySeason.setM12(0.00);
        }
        if (industrySeason.getM1() == null) {
            industrySeason.setM1(0.00);
        }
        if (industrySeason.getM1() == null) {
            industrySeason.setM1(0.00);
        }
        return industrySeason;
    }
}