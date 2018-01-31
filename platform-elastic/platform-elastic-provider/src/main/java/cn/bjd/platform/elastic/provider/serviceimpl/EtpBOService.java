package cn.bjd.platform.elastic.provider.serviceimpl;


import cn.bjd.platform.elastic.api.entity.*;
import cn.bjd.platform.elastic.api.entity.bo.EtpBO;
import cn.bjd.platform.elastic.api.entity.dto.EtpDTO;
import cn.bjd.platform.elastic.api.exception.ServiceException;
import cn.bjd.platform.elastic.api.service.IEtpBOService;
import cn.bjd.platform.elastic.provider.mapper.CrdBreakfaithMapper;
import cn.bjd.platform.elastic.provider.mapper.CrdCourtMapper;
import cn.bjd.platform.elastic.provider.mapper.CrdCourtpubMapper;
import cn.bjd.platform.elastic.provider.mapper.CrdExecutedMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpAbnormalMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpAlterMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpBranchMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpChattelMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpIllegalMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpLicenceMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpPunishMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpSeniorManagerMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpShareholderMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpSharesFrostMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpStockChangeMapper;
import cn.bjd.platform.elastic.provider.mapper.EtpStockMapper;
import cn.bjd.platform.elastic.provider.mapper.SteadyOperationScoreMapper;
import cn.bjd.platform.elastic.provider.mapper.TaxLegelMapper;
import cn.bjd.platform.elastic.provider.utils.BeanUtils;
import cn.bjd.platform.elastic.provider.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Autowired
    private IndustryService industryService;

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
        String tax = steadyOperationScore==null?"":steadyOperationScore.getTaxRate();

        //获取海关评级
        String customs = steadyOperationScore==null?"":steadyOperationScore.getCustomRate();

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
        return etpDTO;
    }
}
