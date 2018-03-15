package cn.bjd.platform.elastic.provider.serviceimpl;


import cn.bjd.platform.elastic.api.entity.*;
import cn.bjd.platform.elastic.api.entity.bo.EtpBO;
import cn.bjd.platform.elastic.api.entity.dto.*;
import cn.bjd.platform.elastic.api.exception.ServiceException;
import cn.bjd.platform.elastic.api.service.IEtpBOService;
import cn.bjd.platform.elastic.provider.mapper.*;
import cn.bjd.platform.elastic.provider.utils.BeanUtils;
import cn.bjd.platform.elastic.provider.utils.DateUtils;
import cn.bjd.platform.elastic.provider.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * Created by Administrator on 2018/1/11.
 */
@Service
@Transactional(readOnly = true)
public class EtpBOService implements IEtpBOService {

    /**
     * 企业基本信息
     */
    @Autowired
    private EtpMapper etpMapper;

    /**
     * 股东出资信息
     */
    @Autowired
    private EtpShareholderMapper etpShareholderMapper;

    /**
     * 企业高管:主要人员信息
     */
    @Autowired
    private EtpSeniorManagerMapper etpSeniorManagerMapper;

    /**
     * 企业变更信息
     */
    @Autowired
    private EtpAlterMapper etpAlterMapper;

    /**
     * 分支机构
     */
    @Autowired
    private EtpBranchMapper etpBranchMapper;


    /**
     * 商标
     */
    @Autowired
    private EtpBrandMapper etpBrandMapper;

    /**
     * 股权出质登记信息
     */
    @Autowired
    private EtpStockMapper etpStockMapper;

    /**
     * 股权变更信息
     */
    @Autowired
    private EtpStockChangeMapper etpStockChangeMapper;

    /**
     * 股权冻结历史信息
     */
    @Autowired
    private EtpSharesFrostMapper etpSharesFrostMapper;

    /**
     * 动产抵押信息
     */
    @Autowired
    private EtpChattelMapper etpChattelMapper;

    /**
     * 列入经营异常名录信息
     */
    @Autowired
    private EtpAbnormalMapper etpAbnormalMapper;

    /**
     * 列入严重违法失信企业名单（黑名单）信息
     */
    @Autowired
    private EtpIllegalMapper etpIllegalMapper;

    /**
     * 行政处罚信息
     */
    @Autowired
    private EtpPunishMapper etpPunishMapper;

    /**
     * 行政许可证信息
     */
    @Autowired
    private EtpLicenceMapper etpLicenceMapper;

    /**
     * 失信
     */
    @Autowired
    private CrdBreakfaithMapper crdBreakfaithMapper;

    /**
     * 裁判文书
     */
    @Autowired
    private CrdCourtMapper crdCourtMapper;

    /**
     * 法院公告
     */
    @Autowired
    private CrdCourtpubMapper crdCourtpubMapper;

    /**
     * 被执行人
     */
    @Autowired
    private CrdExecutedMapper crdExecutedMapper;

    /**
     * 税收、海关评级信息
     */
    @Autowired
    private SteadyOperationScoreMapper steadyOperationScoreMapper;

    /**
     * 税收违法
     */
    @Autowired
    private TaxLegelMapper taxLegelMapper;

    /**
     * 企业评分
     */
    @Autowired
    private EtpSingleScoreMapper etpSingleScoreMapper;

    @Autowired
    private IndustryService industryService;

    @Autowired
    private EtpScoreMapper etpScoreMapper;

    @Autowired
    private IndustryMapper industryMapper;

    @Autowired
    private LegalScoreMapper legalScoreMapper;

    /**
     * 根据企业名称获取对应的企业BO对象
     *
     * @param entName
     * @return
     */
    public EtpBO findByEntName(String entName) {
        if (StringUtils.isEmpty(entName)) {
            return null;
        }

        //查询企业基本信息
        Etp etp = etpMapper.findByEntName(entName);
        if (etp == null) {
            return null;
        }
        EtpBO etpBO = getEtpBOByEtp(etp);
        return etpBO;
    }

    private EtpBO getEtpBOByEtp(Etp etp) {
        if (etp == null) {
            return null;
        }
        //企业对象转换成企业BO对象
        EtpBO etpBO = new EtpBO();
        try {
            BeanUtils.copyProperties(etpBO, etp);
        } catch (Exception e) {
            throw new ServiceException(e);
        }

        String entName = etp.getEntName();

        //完成行业信息转义
        etpBO.setIndustryCategory(industryService.getCategory(etpBO.getIndustryPhy()));
        etpBO.setIndustryBigType(industryService.getBigCategory(etpBO.getIndustryId()));
        etpBO.setIndustryMiddleType(industryService.getMiddleCategory(etpBO.getIndustryId()));
        etpBO.setIndustrySmallType(industryService.getSmallCategory(etpBO.getIndustryId()));

        etpBO.setEtpShareholderList(etpShareholderMapper.findByEtpId(entName));
        etpBO.setEtpSeniorManagerList(etpSeniorManagerMapper.findByEtpId(entName));
        etpBO.setEtpAlterList(etpAlterMapper.findByEtpId(entName));
        etpBO.setEtpBranchList(etpBranchMapper.findByEtpId(entName));
        etpBO.setEtpStockList(etpStockMapper.findByEtpId(entName));
        etpBO.setEtpStockChangeList(etpStockChangeMapper.findByEtpId(entName));
        etpBO.setEtpSharesFrostList(etpSharesFrostMapper.findByEtpId(entName));
        etpBO.setEtpChattelList(etpChattelMapper.findByEtpId(entName));
        etpBO.setEtpAbnormalList(etpAbnormalMapper.findByEtpId(entName));
        etpBO.setEtpIllegalList(etpIllegalMapper.findByEtpId(entName));
        etpBO.setEtpPunishList(etpPunishMapper.findByEtpId(entName));
        etpBO.setEtpLicenceList(etpLicenceMapper.findByEtpId(entName));
        etpBO.setCrdBreakfaithList(crdBreakfaithMapper.findByEtpId(entName));
        etpBO.setCrdCourtList(crdCourtMapper.findByEtpId(entName, "defendant"));
        etpBO.setCrdCourtpubList(crdCourtpubMapper.findByEtpId(entName));
        etpBO.setCrdExecutedList(crdExecutedMapper.findByEtpId(entName));
        etpBO.setSteadyOperationScore(steadyOperationScoreMapper.findById(etp.getId()));
        etpBO.setTaxLegelList(taxLegelMapper.findByCompanyName(entName));
        etpBO.setEtpSingleScore(etpSingleScoreMapper.findById(etp.getId()));
        etpBO.setEtpBrandList(etpBrandMapper.findByEtpId(entName));
        return etpBO;
    }

    public Map<String, EtpBO> findByEntNameList(List<String> entNameList) {
        if (CollectionUtils.isEmpty(entNameList)) {
            return null;
        }

        //批量获取企业信息
        List<Etp> etpList = etpMapper.findByEntNameIn(entNameList);
        if (CollectionUtils.isEmpty(etpList)) {
            return null;
        }

        Map<String, EtpBO> etpBOMap = new HashMap<>(etpList.size());
        try {
            for (Etp etp : etpList) {
                EtpBO etpBO = new EtpBO();
                BeanUtils.copyProperties(etpBO, etp);
                //完成行业信息转义
                etpBO.setIndustryCategory(industryService.getCategory(etpBO.getIndustryPhy()));
                etpBO.setIndustryBigType(industryService.getBigCategory(etpBO.getIndustryId()));
                etpBO.setIndustryMiddleType(industryService.getMiddleCategory(etpBO.getIndustryId()));
                etpBO.setIndustrySmallType(industryService.getSmallCategory(etpBO.getIndustryId()));
                etpBOMap.put(etpBO.getEntName(), etpBO);
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }

        EtpBO etpBO = null;
        List<EtpShareholder> etpShareholderList = etpShareholderMapper.findByEtpIdIn(entNameList);
        for (EtpShareholder item : etpShareholderList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpShareholderList() == null) {
                etpBO.setEtpShareholderList(new ArrayList<>());
            }
            etpBO.getEtpShareholderList().add(item);
        }

        List<EtpSeniorManager> etpSeniorManagerList = etpSeniorManagerMapper.findByEtpIdIn(entNameList);
        for (EtpSeniorManager item : etpSeniorManagerList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpSeniorManagerList() == null) {
                etpBO.setEtpSeniorManagerList(new ArrayList<>());
            }
            etpBO.getEtpSeniorManagerList().add(item);
        }
        List<EtpAlter> etpAlterList = etpAlterMapper.findByEtpIdIn(entNameList);
        for (EtpAlter item : etpAlterList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpAlterList() == null) {
                etpBO.setEtpAlterList(new ArrayList<>());
            }
            etpBO.getEtpAlterList().add(item);
        }
        List<EtpBranch> etpBranchList = etpBranchMapper.findByEtpIdIn(entNameList);
        for (EtpBranch item : etpBranchList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpBranchList() == null) {
                etpBO.setEtpBranchList(new ArrayList<>());
            }
            etpBO.getEtpBranchList().add(item);
        }
        List<EtpStock> etpStockList = etpStockMapper.findByEtpIdIn(entNameList);
        for (EtpStock item : etpStockList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpStockList() == null) {
                etpBO.setEtpStockList(new ArrayList<>());
            }
            etpBO.getEtpStockList().add(item);
        }
        List<EtpStockChange> etpStockChangeList = etpStockChangeMapper.findByEtpIdIn(entNameList);
        for (EtpStockChange item : etpStockChangeList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpStockChangeList() == null) {
                etpBO.setEtpStockChangeList(new ArrayList<>());
            }
            etpBO.getEtpStockChangeList().add(item);
        }
        List<EtpSharesFrost> etpSharesFrostList = etpSharesFrostMapper.findByEtpIdIn(entNameList);
        for (EtpSharesFrost item : etpSharesFrostList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpSharesFrostList() == null) {
                etpBO.setEtpSharesFrostList(new ArrayList<>());
            }
            etpBO.getEtpSharesFrostList().add(item);
        }
        List<EtpChattel> etpChattelList = etpChattelMapper.findByEtpIdIn(entNameList);
        for (EtpChattel item : etpChattelList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpChattelList() == null) {
                etpBO.setEtpChattelList(new ArrayList<>());
            }
            etpBO.getEtpChattelList().add(item);
        }
        List<EtpAbnormal> etpAbnormalList = etpAbnormalMapper.findByEtpIdIn(entNameList);
        for (EtpAbnormal item : etpAbnormalList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpAbnormalList() == null) {
                etpBO.setEtpAbnormalList(new ArrayList<>());
            }
            etpBO.getEtpAbnormalList().add(item);
        }
        List<EtpIllegal> etpIllegalList = etpIllegalMapper.findByEtpIdIn(entNameList);
        for (EtpIllegal item : etpIllegalList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpIllegalList() == null) {
                etpBO.setEtpIllegalList(new ArrayList<>());
            }
            etpBO.getEtpIllegalList().add(item);
        }
        List<EtpPunish> etpPunishList = etpPunishMapper.findByEtpIdIn(entNameList);
        for (EtpPunish item : etpPunishList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpPunishList() == null) {
                etpBO.setEtpPunishList(new ArrayList<>());
            }
            etpBO.getEtpPunishList().add(item);
        }
        List<EtpLicence> etpLicenceList = etpLicenceMapper.findByEtpIdIn(entNameList);
        for (EtpLicence item : etpLicenceList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getEtpLicenceList() == null) {
                etpBO.setEtpLicenceList(new ArrayList<>());
            }
            etpBO.getEtpLicenceList().add(item);
        }
        List<CrdBreakfaith> crdBreakfaithList = crdBreakfaithMapper.findByPersonNameIn(entNameList);
        for (CrdBreakfaith item : crdBreakfaithList) {
            etpBO = etpBOMap.get(item.getPersonName());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getCrdBreakfaithList() == null) {
                etpBO.setCrdBreakfaithList(new ArrayList<>());
            }
            etpBO.getCrdBreakfaithList().add(item);
        }

        List<CrdCourt> crdCourtList = crdCourtMapper.findByEtpIdIn(entNameList, "defendant");
        for (CrdCourt item : crdCourtList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getCrdCourtList() == null) {
                etpBO.setCrdCourtList(new ArrayList<>());
            }
            etpBO.getCrdCourtList().add(item);
        }
        List<CrdCourtpub> crdCourtpubList = crdCourtpubMapper.findByEtpIdIn(entNameList);
        for (CrdCourtpub item : crdCourtpubList) {
            etpBO = etpBOMap.get(item.getEtpId());
            if (etpBO == null) {
                continue;
            }
            if (etpBO != null && etpBO.getCrdCourtpubList() == null) {
                etpBO.setCrdCourtpubList(new ArrayList<>());
            }
            etpBO.getCrdCourtpubList().add(item);
        }

        List<CrdExecuted> crdExecutedList = crdExecutedMapper.findByExecutedIn(entNameList);
        for (CrdExecuted item : crdExecutedList) {
            etpBO = etpBOMap.get(item.getExecuted());
            if (etpBO == null) {
                continue;
            }
            if (etpBO.getCrdExecutedList() == null) {
                etpBO.setCrdExecutedList(new ArrayList<>());
            }
            etpBO.getCrdExecutedList().add(item);
        }

        return etpBOMap;
    }

    public List<EtpBO> findInvestEtpByEntName(String entName, int type) {
        List<String> entNameList = null;
        if (type == 1) {
            entNameList = etpShareholderMapper.selectEtpIdByShareholder(entName);
        } else {
            entNameList = etpShareholderMapper.selectShareholderByEtpId(entName);
        }
        Map<String, EtpBO> etpBOMap = findByEntNameList(entNameList);
        List<EtpBO> etpBOList = null;
        if (etpBOMap != null && !etpBOMap.isEmpty()) {
            Set<Map.Entry<String, EtpBO>> entrySet = etpBOMap.entrySet();
            etpBOList = new ArrayList<>(entrySet.size());
            for (Map.Entry<String, EtpBO> entry : entrySet) {
                etpBOList.add(entry.getValue());
            }
        }
        return etpBOList;
    }

    public List<EtpBO> findInvestEtpByEntName(String entName) {
        return this.findInvestEtpByEntName(entName, 1);
    }

    public List<EtpBO> findBeInvestedEtpByEntName(String entName) {
        return this.findInvestEtpByEntName(entName, 2);
    }

    /**
     * 根据企业id获取对应的企业BO对象 返回DTO对象
     *
     * @param id
     * @return EtpDTO
     */
    @Override
    public EtpDTO findById(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }

        //查询企业基本信息
        Etp etp = etpMapper.findById(id);
        if (etp == null) {
            return null;
        }
        EtpBO etpBO = getEtpBOByEtp(etp);

        if (etpBO == null) {
            return null;
        }

        //获取税收评级
        SteadyOperationScore steadyOperationScore = etpBO.getSteadyOperationScore();
        String tax = steadyOperationScore == null ? "" : steadyOperationScore.getTaxRate();

        //获取海关评级
        String customs = steadyOperationScore == null ? "" : steadyOperationScore.getCustomRate();

        //获取涉讼数量
        Integer courtCount = crdBreakfaithMapper.findCountByEtpName(etpBO.getEntName())
                + crdCourtMapper.findCountByEtpName(etpBO.getEntName(), "defendant")
                + crdCourtpubMapper.findCountByEtpName(etpBO.getEntName())
                + crdExecutedMapper.findCountByExecuted(etpBO.getEntName());

        //获取违法数量
        Integer illegalCount = etpIllegalMapper.findCountByEtpId(id)
                + etpPunishMapper.findCountByEtpId(id) + taxLegelMapper.findCountByCompanyName(etpBO.getEntName());

        //将BO转为DTO
        EtpDTO etpDTO = new EtpDTO();
        etpDTO.setId(id);
        etpDTO.setEntName(etpBO.getEntName());
        etpDTO.setAddress(etpBO.getAddress());
        etpDTO.setRegDate(etpBO.getRegDate());
        etpDTO.setRegCapital(Double.parseDouble(etpBO.getRegCapital()));
        etpDTO.setLng(Double.parseDouble(etpBO.getLng()));
        etpDTO.setLat(Double.parseDouble(etpBO.getLat()));
        etpDTO.setCategoryName(etpBO.getIndustryCategory());
        etpDTO.setBigCategoryName(etpBO.getIndustryBigType());
        etpDTO.setMiddleCategoryName(etpBO.getIndustryMiddleType());
        etpDTO.setSmallCategoryName(etpBO.getIndustrySmallType());
        etpDTO.setCustoms(customs);
        etpDTO.setTax(tax);
        etpDTO.setCourtCount(courtCount);
        etpDTO.setIllegalCount(illegalCount);
        etpDTO.setEtpSingleScore(etpBO.getEtpSingleScore() == null ? 0 : etpBO.getEtpSingleScore().getEtpSingleScore());
        return etpDTO;
    }

    /**
     * 通过企业id获取资质能力 返回DTO
     *
     * @param id
     * @return EtpAptitudeDTO
     */
    @Override
    public EtpAptitudeDTO findEtpAptitudeById(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }

        //查询企业基本信息
        Etp etp = etpMapper.findById(id);
        if (etp == null) {
            return null;
        }
        EtpBO etpBO = getEtpBOByEtp(etp);
        if (etpBO == null) {
            return null;
        }

        //获取税收评级
        String tax = etpBO.getSteadyOperationScore().getTaxRate();

        //获取海关评级
        String customs = etpBO.getSteadyOperationScore().getCustomRate();

        //将BO转为DTO
        EtpAptitudeDTO etpAptitudeDTO = new EtpAptitudeDTO();
        etpAptitudeDTO.setId(id);
        etpAptitudeDTO.setEtpBrandList(etpBO.getEtpBrandList());
        etpAptitudeDTO.setEtpLicenceList(etpBO.getEtpLicenceList());
        etpAptitudeDTO.setTaxRate(tax);
        etpAptitudeDTO.setCustomRate(customs);
        return etpAptitudeDTO;
    }

    @Override
    public ReadDTO findReadByEtpId(String id) {
        Etp etp = etpMapper.findById(id);
        ReadDTO dto = new ReadDTO();
        if (etp != null) {
            dto.setAddress(etp.getAddress());
            dto.setEntName(etp.getEntName());
            dto.setNameLike(etp.getNameLike());
            dto.setRegCapital(etp.getRegCapital());
            dto.setRegDate(etp.getRegDate());
            dto.setLegalRep(etp.getLegalRep());
            dto.setRegState(etp.getRegStateCN());
            //通过公司名称去查询相应的评分
            if (!StringUtils.isEmpty(etp.getEntName())) {
                EtpScore score = etpScoreMapper.findByEntName(etp.getEntName());
                if (score != null) {
                    dto.setLegalScore(score.getTotalLegal());
                    dto.setIndustryScore(score.getTotalIndustry());
                    dto.setFinScore(score.getTotalFin());
                    dto.setEtpScore(score.getTotalEtp());
                    dto.setAreaScore(score.getTotalArea());
                    dto.setEtpTotalScore(score.getTotalEtpScore());
                }
            }

            //通过行业id去查询投向指引
            Integer industryId = etp.getIndustryId();
            if (industryId != null) {
                Industry industry = industryMapper.selectByPrimaryKey(industryId);
                if (industry != null) {
                    dto.setAccessStandar(industry.getCylZrbz());
                    dto.setAccessBasicStandar(industry.getCylJbzrtj());
                    dto.setRiskIdentify(industry.getCylFxsb());
                    dto.setRiskControlMeasures(industry.getCylFxgkcs());
                }
            }
        }

        return dto;
    }

    @Override
    public EtpBasicDTO findBasicById(String id) {
        Etp etp = etpMapper.findById(id);
        EtpBasicDTO basicDTO = new EtpBasicDTO();
        if (etp != null) {
            basicDTO.setCreditCode(etp.getUnIsCid());//统一社会信用代码
            basicDTO.setRegState(etp.getRegStateCN());
            basicDTO.setIndustry(etp.getIndustry());

            basicDTO.setRegDate(etp.getRegDate());
            basicDTO.setType(etp.getType());


            Date businessStart = etp.getBusinessStart();
            Date businessFinish = etp.getBusinessFinish();

            StringBuilder businessStartFinish = new StringBuilder("");
            if (businessStart != null) {
                businessStartFinish.append(DateUtils.format(businessStart, "yyyy-MM-dd"));
            }

            if (businessFinish != null) {
                businessStartFinish.append("-" + DateUtils.format(businessFinish, "yyyy-MM-dd"));
            } else {
                businessStartFinish.append("-无固定期限");
            }

            basicDTO.setBusinessStartFinish(businessStartFinish.toString());
            basicDTO.setLegalRep(etp.getLegalRep());

            basicDTO.setCheckDate(etp.getCheckDate());

            basicDTO.setRegCapital(etp.getRegCapital());
            basicDTO.setRegOffice(etp.getRegOffice());
            basicDTO.setBusinessScope(etp.getBusinessScope());
            basicDTO.setAddress(etp.getAddress());

            //通过名称查询股东信息
            List<EtpShareholder> etpShareholder = etpShareholderMapper.findByEtpId(etp.getEntName());
            String regCapital = etp.getRegCapital();
            if (StringUtils.isNotBlank(regCapital)) {
                for (EtpShareholder etpShareholderRate : etpShareholder) {
                    Double r = (etpShareholderRate.getConfusingAmount() / Double.parseDouble(regCapital)) * 100;
                    etpShareholderRate.setRate(r.toString() + "%");
                }
            }

            basicDTO.setEtpShareholder(etpShareholder);


            //成员信息
            List<EtpSeniorManager> etpSeniorManager = etpSeniorManagerMapper.findByEtpId(etp.getEntName());
            basicDTO.setEtpSeniorManager(etpSeniorManager);

            //对外投资
            //本公司对外投资情况
            List<Outward> outward = new ArrayList<>();
            List<String> outEtpShareholder = etpShareholderMapper.selectEtpIdByShareholder(etp.getEntName());
            if (!CollectionUtils.isEmpty(outEtpShareholder)) {
                for (String etpId : outEtpShareholder) {
                    Etp etpOutEtpShareholder = etpMapper.findByEntName(etpId);          //EtpShareholder中etpId存储的是entName
                    Outward outward1 = new Outward();
                    outward1.setEtpName(etpOutEtpShareholder.getEntName());
                    outward1.setLegalRep(etpOutEtpShareholder.getLegalRep());
                    outward1.setRegDate(etpOutEtpShareholder.getRegDate());
                    outward1.setRegStateCN(etpOutEtpShareholder.getRegStateCN());

                    EtpShareholder e = etpShareholderMapper.findByEtpIdAndShareholder(etpId, etp.getEntName());
                    if (e != null) {
                        outward1.setPaymentAmount(e.getPayment());
                        outward1.setConfusingAmount(e.getConfusingAmount());
                        //出资比例
                        Etp outEtp = etpMapper.findByEntName(etpId);

                        if (outEtp != null) {
                            String catipal = outEtp.getRegCapital();
                            outward1.setRate(String.valueOf(((e.getConfusingAmount() / Double.parseDouble(catipal)) * 100)) + "%");
                        }
                    }


                    outward.add(outward1);
                }
            }


            basicDTO.setOutward(outward);

            //变更信息
            List<EtpAlter> etpAlter = etpAlterMapper.findByEtpId(etp.getEntName());
            basicDTO.setEtpAlter(etpAlter);
        }


        return basicDTO;
    }

    @Override
    public RiskDTO findRiskById(String id) {

        //根据名称去查询裁判文书信息
        Etp etp = etpMapper.findById(id);
        RiskDTO dto = new RiskDTO();
        if (etp != null) {
            String entName = etp.getEntName();
            List<CrdCourt> crdCourt = crdCourtMapper.findByEtpId(entName, null);
            dto.setCrdCourt(crdCourt);

            List<CrdCourtpub> crdCourtPub = crdCourtpubMapper.findByEtpId(entName);
            dto.setCrdCourtPub(crdCourtPub);

            List<CrdExecuted> crdExecuted = crdExecutedMapper.findByEtpId(entName);
            dto.setCrdExecuted(crdExecuted);

            List<CrdBreakfaith> crdBreakfaith = crdBreakfaithMapper.findByEtpId(entName);
            dto.setCrdBreakfaith(crdBreakfaith);

            List<EtpAbnormal> etpAbnormal = etpAbnormalMapper.findByEtpId(entName);
            dto.setEtpAbnormal(etpAbnormal);

            List<EtpPunish> etpPunish = etpPunishMapper.findByEtpId(entName);
            dto.setEtpPunish(etpPunish);

            List<EtpStock> etpStock = etpStockMapper.findByEtpId(entName);
            dto.setEtpStock(etpStock);

            List<EtpChattel> etpChattel = etpChattelMapper.findByEtpId(entName);
            dto.setEtpChattel(etpChattel);


            List<String> relate2 = etpShareholderMapper.selectEtpIdByShareholder(entName);
            List<LegalScore> legalScore = new ArrayList<>();

            Set<String> relateName = new HashSet<>();
            List<EtpShareholder> relate1 = etpShareholderMapper.findByEtpId(entName);
            for (EtpShareholder e : relate1) {
                relateName.add(e.getShareholder());
                LegalScore l = legalScoreMapper.findByEntName(e.getShareholder());
                if (l != null) {
                    legalScore.add(l);
                }
            }

            for (String s : relate2) {
                relateName.add(s);
                LegalScore l = legalScoreMapper.findByEntName(s);
                if (l != null) {
                    legalScore.add(l);
                }
            }

            if (CollectionUtils.isEmpty(relateName)) {
                relateName.add("");
            }
            dto.setLegalScore(legalScore);
            List<CrdCourt> relateCrdCourt = crdCourtMapper.findByEtpIdIn(new ArrayList<>(relateName), null);
            dto.setRelateCrdCourt(relateCrdCourt);
        }


        return dto;
    }

    @Override
    public AtlasDTO findAtlasById(String id) {
        Etp etp = etpMapper.findById(id);
        AtlasDTO dto = new AtlasDTO();

        if (etp != null) {
            FamilyDTO family = new FamilyDTO();
            //先查询公司名称TYPE
            family.setName(etp.getEntName());
            family.setType(0);
            //children
            //第一层默认是7个
            List<FamilyDTO> listTypeOne = new ArrayList<>();

            List<LinkDTO> link = new ArrayList<>();
            List<NodesDTO> nodes = new ArrayList<>();

            String[] strTypeOne = {"股东", "对外投资", "法院公告", "裁判文书", "历史法人", "历史股东", "高管"};
            List<String> shareholder = etpShareholderMapper.selectShareholderByEtpId(etp.getEntName());
            List<String> shareholderTwo = etpShareholderMapper.selectEtpIdByShareholder(etp.getEntName());
            List<String> client = crdCourtpubMapper.findLikeClient(etp.getEntName());
            List<CrdCourt> court = crdCourtMapper.findByEtpId(etp.getEntName(), null);
            List<EtpAlter> alter = etpAlterMapper.findByEtpId(etp.getEntName());
            List<EtpSeniorManager> managerList = etpSeniorManagerMapper.findByEtpId(etp.getEntName());
            for (int i = 0; i < strTypeOne.length; i++) {
                FamilyDTO fTypeOne = new FamilyDTO();
                fTypeOne.setType(i + 1);
                fTypeOne.setName(strTypeOne[i]);
                //第二层
                //股东type为1
                //查询出公司股东信息

                if (i == 0) {
                    List<FamilyDTO> shareholderFamily = new ArrayList<>();
                    for (String str : shareholder) {
                        FamilyDTO shareholderOne = new FamilyDTO();
                        shareholderOne.setType(1);
                        shareholderOne.setName(str);
                        shareholderFamily.add(shareholderOne);

                        LinkDTO linkDTO = new LinkDTO();
                        linkDTO.setSource(str);
                        linkDTO.setTarget(etp.getEntName());
                        link.add(linkDTO);


                        NodesDTO nodesDTO = new NodesDTO();
                        nodesDTO.setName(str);
                        nodesDTO.setCategory(0);
                        nodesDTO.setType(1);
                        nodes.add(nodesDTO);


                    }
                    fTypeOne.setChildren(shareholderFamily);
                    listTypeOne.add(fTypeOne);
                }

                if (i == 1) {
                    //对外投资情况 type2
                    List<FamilyDTO> shareholderTwoFamily = new ArrayList<>();
                    NodesDTO node = new NodesDTO();
                    node.setName(etp.getEntName());
                    node.setCategory(null);
                    node.setType(null);
                    nodes.add(node);

                    for (String str : shareholderTwo) {
                        FamilyDTO shareholderTwoF = new FamilyDTO();
                        shareholderTwoF.setType(2);
                        shareholderTwoF.setName(str);
                        shareholderTwoFamily.add(shareholderTwoF);

                        LinkDTO linkDTO = new LinkDTO();
                        linkDTO.setSource(etp.getEntName());
                        linkDTO.setTarget(str);
                        link.add(linkDTO);


                        NodesDTO nodesDTO = new NodesDTO();
                        nodesDTO.setName(str);
                        nodesDTO.setCategory(0);
                        nodesDTO.setType(1);
                        nodes.add(nodesDTO);

                        //根据str查询对应公司
                        List<String> shareholderStr = etpShareholderMapper.selectEtpIdByShareholder(str);
                        for (String s : shareholderStr) {
                            LinkDTO linkStr = new LinkDTO();
                            linkStr.setSource(str);
                            linkStr.setTarget(s);
                            link.add(linkStr);


                            NodesDTO nodesStr = new NodesDTO();
                            nodesStr.setName(s);
                            nodesStr.setCategory(1);
                            nodesStr.setType(2);
                            nodes.add(nodesStr);
                        }

                    }
                    fTypeOne.setChildren(shareholderTwoFamily);
                    listTypeOne.add(fTypeOne);
                }

                if (i == 2) {
                    //法院公告  type3
                    //与本企业相关的法院公告公司显示

                    Set<String> set = new HashSet<>();
                    for (String str : client) {
                        //排除自己的公司 用SET保存
                        String[] strClient = str.split("、");
                        for (String sClient : strClient) {
                            if (!sClient.equals(etp.getEntName()) && sClient.contains("公司")) {
                                set.add(sClient);
                            }
                        }
                    }

                    List<FamilyDTO> pubThreeFamily = new ArrayList<>();
                    for (String s : set) {
                        FamilyDTO crdPub = new FamilyDTO();
                        crdPub.setType(3);
                        crdPub.setName(s);
                        pubThreeFamily.add(crdPub);
                    }

                    fTypeOne.setChildren(pubThreeFamily);
                    listTypeOne.add(fTypeOne);
                }

                if (i == 3) {
                    //裁判文书type4

                    Set<String> set = new HashSet<>();
                    for (CrdCourt c : court) {
                        String defendant = c.getDefendant();
                        String[] de = defendant.split("、");
                        for (String d : de) {
                            if (!d.equals(etp.getEntName()) && (d.contains("公司") || d.contains("支行") || d.contains("银行"))) {
                                set.add(d);
                            }
                        }

                        String plaintiff = c.getPlaintiff();
                        String[] pl = plaintiff.split("、");
                        for (String p : pl) {
                            if (!p.equals(etp.getEntName()) && (p.contains("公司") || p.contains("支行") || p.contains("银行"))) {
                                set.add(p);
                            }
                        }
                    }
                    List<FamilyDTO> pubFourFamily = new ArrayList<>();
                    for (String s : set) {
                        FamilyDTO courtF = new FamilyDTO();
                        courtF.setType(4);
                        courtF.setName(s);
                        pubFourFamily.add(courtF);
                    }

                    fTypeOne.setChildren(pubFourFamily);
                    listTypeOne.add(fTypeOne);
                }


                if (i == 4) {
                    //历史法人
                    List<FamilyDTO> pubFiveFamily = new ArrayList<>();
                    Set<String> set = new HashSet<>();
                    for (EtpAlter eAlter : alter) {
                        if (eAlter.getChangeEvent().equals("法定代表人变更")) {
                            String pre = eAlter.getPreChange();
                            //str.substring
                            //几区名字
                            String preName = "";
                            if (pre.contains(":")) {
                                preName = pre.substring(pre.lastIndexOf(":") + 1, pre.length()).trim();
                            }
                            if (pre.contains("：")) {
                                preName = pre.substring(pre.lastIndexOf("：") + 1, pre.length()).trim();
                            }

                            //去掉名词重复
                            set.add(preName);
                        }
                    }

                    for (String s : set) {
                        FamilyDTO eAlterF = new FamilyDTO();
                        eAlterF.setType(5);
                        eAlterF.setName(s);
                        pubFiveFamily.add(eAlterF);
                    }
                    fTypeOne.setChildren(pubFiveFamily);
                    listTypeOne.add(fTypeOne);
                }


                if (i == 5) {
                    //历史股东
                    List<FamilyDTO> hisSixFamily = new ArrayList<>();
                    Set<String> set = new HashSet<>();
                    for (EtpAlter eAlter : alter) {
                        //已经得到现在的股东了 把历史的都取出来 做对比  然后进行判断 得出是历史股东
                        if (eAlter.getChangeEvent().equals("投资人(股权)变更")) {
                            String pre = eAlter.getPreChange();
                            String[] pr = pre.split(";");
                            for (String p : pr) {
                                String preName = "";
                                if (p.contains(":")) {
                                    preName = p.substring(p.lastIndexOf(":") + 1, p.length()).trim();
                                }
                                if (p.contains("：")) {
                                    preName = p.substring(p.lastIndexOf("：") + 1, p.length()).trim();
                                }
                                set.add(preName);


                            }
                        }
                    }
                    for (String s : set) {
                        if (!shareholder.contains(s)) {
                            FamilyDTO fiveDto = new FamilyDTO();
                            fiveDto.setName(s);
                            fiveDto.setType(6);
                            hisSixFamily.add(fiveDto);
                        }
                    }

                    fTypeOne.setChildren(hisSixFamily);
                    listTypeOne.add(fTypeOne);
                }


                if (i == 6) {
                    List<FamilyDTO> hisSevenFamily = new ArrayList<>();
                    for (EtpSeniorManager manager : managerList) {
                        FamilyDTO f = new FamilyDTO();
                        f.setType(7);
                        f.setName(manager.getName());
                        hisSevenFamily.add(f);
                    }
                    fTypeOne.setChildren(hisSevenFamily);
                    listTypeOne.add(fTypeOne);
                }
            }

            family.setChildren(listTypeOne);
            dto.setFamily(family);

            RelateDTO relate = new RelateDTO();


            //公司对外投资

            relate.setLink(link);
            relate.setNodes(nodes);

            dto.setRelate(relate);
        }

        return dto;
    }
}