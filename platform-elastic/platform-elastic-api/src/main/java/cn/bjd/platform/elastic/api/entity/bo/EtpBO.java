package cn.bjd.platform.elastic.api.entity.bo;



import cn.bjd.platform.elastic.api.entity.*;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11.
 */
public class EtpBO extends Etp{

    /**
     * 所属门类
     */
    private String industryCategory;

    /**
     * 所属大类
     */
    private String industryBigType;

    /**
     * 所属中类
     */
    private String industryMiddleType;

    /**
     * 所属小类
     */
    private String industrySmallType;

    /**
     * 股东出资信息
     */
    private List<EtpShareholder> etpShareholderList;

    /**
     * 企业高管:主要人员信息
     */
    private List<EtpSeniorManager> etpSeniorManagerList;

    /**
     * 企业变更信息
     */
    private List<EtpAlter> etpAlterList;

    /**
     * 分支机构
     */
    private List<EtpBranch> etpBranchList;

    /**
     * 股权出质登记信息
     */
    private List<EtpStock> etpStockList;

    /**
     * 股权变更信息
     */
    private List<EtpStockChange> etpStockChangeList;

    /**
     * 股权冻结历史信息
     */
    private List<EtpSharesFrost> etpSharesFrostList;

    /**
     * 动产抵押信息
     */
    private List<EtpChattel> etpChattelList;

    /**
     * 列入经营异常名录信息
     */
    private List<EtpAbnormal> etpAbnormalList;

    /**
     * 列入严重违法失信企业名单（黑名单）信息
     */
    private List<EtpIllegal> etpIllegalList;

    /**
     * 行政处罚信息
     */
    private List<EtpPunish> etpPunishList;

    /**
     * 行政许可证信息
     */
    private List<EtpLicence> etpLicenceList;

    /**
     * 失信
     */
    private List<CrdBreakfaith> crdBreakfaithList;

    /**
     * 裁判文书
     */
    private List<CrdCourt> crdCourtList;

    /**
     * 法院公告
     */
    private List<CrdCourtpub> crdCourtpubList;

    /**
     * 被执行人
     */
    private List<CrdExecuted> crdExecutedList;

    /**
     * 企业税收、海关评级信息
     */
    private SteadyOperationScore steadyOperationScore;

    /**
     * 税收违法
     */
    private List<TaxLegel> taxLegelList;

    /**
     * 企业评分
     */
    private EtpSingleScore etpSingleScore;

    /**
     * Gets industryCategory
     *
     * @return value of industryCategory
     */
    public String getIndustryCategory() {
        return industryCategory;
    }

    /**
     * @param industryCategory
     */
    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    /**
     * Gets industryBigType
     *
     * @return value of industryBigType
     */
    public String getIndustryBigType() {
        return industryBigType;
    }

    /**
     * @param industryBigType
     */
    public void setIndustryBigType(String industryBigType) {
        this.industryBigType = industryBigType;
    }

    /**
     * Gets industryMiddleType
     *
     * @return value of industryMiddleType
     */
    public String getIndustryMiddleType() {
        return industryMiddleType;
    }

    /**
     * @param industryMiddleType
     */
    public void setIndustryMiddleType(String industryMiddleType) {
        this.industryMiddleType = industryMiddleType;
    }

    /**
     * Gets industrySmallType
     *
     * @return value of industrySmallType
     */
    public String getIndustrySmallType() {
        return industrySmallType;
    }

    /**
     * @param industrySmallType
     */
    public void setIndustrySmallType(String industrySmallType) {
        this.industrySmallType = industrySmallType;
    }

    /**
     * Gets etpShareholderList
     *
     * @return value of etpShareholderList
     */
    public List<EtpShareholder> getEtpShareholderList() {
        return etpShareholderList;
    }

    /**
     * @param etpShareholderList
     */
    public void setEtpShareholderList(List<EtpShareholder> etpShareholderList) {
        this.etpShareholderList = etpShareholderList;
    }

    /**
     * Gets etpSeniorManagerList
     *
     * @return value of etpSeniorManagerList
     */
    public List<EtpSeniorManager> getEtpSeniorManagerList() {
        return etpSeniorManagerList;
    }

    /**
     * @param etpSeniorManagerList
     */
    public void setEtpSeniorManagerList(List<EtpSeniorManager> etpSeniorManagerList) {
        this.etpSeniorManagerList = etpSeniorManagerList;
    }

    /**
     * Gets etpAlterList
     *
     * @return value of etpAlterList
     */
    public List<EtpAlter> getEtpAlterList() {
        return etpAlterList;
    }

    /**
     * @param etpAlterList
     */
    public void setEtpAlterList(List<EtpAlter> etpAlterList) {
        this.etpAlterList = etpAlterList;
    }

    /**
     * Gets etpBranchList
     *
     * @return value of etpBranchList
     */
    public List<EtpBranch> getEtpBranchList() {
        return etpBranchList;
    }

    /**
     * @param etpBranchList
     */
    public void setEtpBranchList(List<EtpBranch> etpBranchList) {
        this.etpBranchList = etpBranchList;
    }

    /**
     * Gets etpStockList
     *
     * @return value of etpStockList
     */
    public List<EtpStock> getEtpStockList() {
        return etpStockList;
    }

    /**
     * @param etpStockList
     */
    public void setEtpStockList(List<EtpStock> etpStockList) {
        this.etpStockList = etpStockList;
    }

    /**
     * Gets etpStockChangeList
     *
     * @return value of etpStockChangeList
     */
    public List<EtpStockChange> getEtpStockChangeList() {
        return etpStockChangeList;
    }

    /**
     * @param etpStockChangeList
     */
    public void setEtpStockChangeList(List<EtpStockChange> etpStockChangeList) {
        this.etpStockChangeList = etpStockChangeList;
    }

    /**
     * Gets etpSharesFrostList
     *
     * @return value of etpSharesFrostList
     */
    public List<EtpSharesFrost> getEtpSharesFrostList() {
        return etpSharesFrostList;
    }

    /**
     * @param etpSharesFrostList
     */
    public void setEtpSharesFrostList(List<EtpSharesFrost> etpSharesFrostList) {
        this.etpSharesFrostList = etpSharesFrostList;
    }

    /**
     * Gets etpChattelList
     *
     * @return value of etpChattelList
     */
    public List<EtpChattel> getEtpChattelList() {
        return etpChattelList;
    }

    /**
     * @param etpChattelList
     */
    public void setEtpChattelList(List<EtpChattel> etpChattelList) {
        this.etpChattelList = etpChattelList;
    }

    /**
     * Gets etpAbnormalList
     *
     * @return value of etpAbnormalList
     */
    public List<EtpAbnormal> getEtpAbnormalList() {
        return etpAbnormalList;
    }

    /**
     * @param etpAbnormalList
     */
    public void setEtpAbnormalList(List<EtpAbnormal> etpAbnormalList) {
        this.etpAbnormalList = etpAbnormalList;
    }

    /**
     * Gets etpIllegalList
     *
     * @return value of etpIllegalList
     */
    public List<EtpIllegal> getEtpIllegalList() {
        return etpIllegalList;
    }

    /**
     * @param etpIllegalList
     */
    public void setEtpIllegalList(List<EtpIllegal> etpIllegalList) {
        this.etpIllegalList = etpIllegalList;
    }

    /**
     * Gets etpPunishList
     *
     * @return value of etpPunishList
     */
    public List<EtpPunish> getEtpPunishList() {
        return etpPunishList;
    }

    /**
     * @param etpPunishList
     */
    public void setEtpPunishList(List<EtpPunish> etpPunishList) {
        this.etpPunishList = etpPunishList;
    }

    /**
     * Gets etpLicenceList
     *
     * @return value of etpLicenceList
     */
    public List<EtpLicence> getEtpLicenceList() {
        return etpLicenceList;
    }

    /**
     * @param etpLicenceList
     */
    public void setEtpLicenceList(List<EtpLicence> etpLicenceList) {
        this.etpLicenceList = etpLicenceList;
    }

    /**
     * Gets crdBreakfaithList
     *
     * @return value of crdBreakfaithList
     */
    public List<CrdBreakfaith> getCrdBreakfaithList() {
        return crdBreakfaithList;
    }

    /**
     * @param crdBreakfaithList
     */
    public void setCrdBreakfaithList(List<CrdBreakfaith> crdBreakfaithList) {
        this.crdBreakfaithList = crdBreakfaithList;
    }

    /**
     * Gets crdCourtList
     *
     * @return value of crdCourtList
     */
    public List<CrdCourt> getCrdCourtList() {
        return crdCourtList;
    }

    /**
     * @param crdCourtList
     */
    public void setCrdCourtList(List<CrdCourt> crdCourtList) {
        this.crdCourtList = crdCourtList;
    }

    /**
     * Gets crdCourtpubList
     *
     * @return value of crdCourtpubList
     */
    public List<CrdCourtpub> getCrdCourtpubList() {
        return crdCourtpubList;
    }

    /**
     * @param crdCourtpubList
     */
    public void setCrdCourtpubList(List<CrdCourtpub> crdCourtpubList) {
        this.crdCourtpubList = crdCourtpubList;
    }

    /**
     * Gets crdExecutedList
     *
     * @return value of crdExecutedList
     */
    public List<CrdExecuted> getCrdExecutedList() {
        return crdExecutedList;
    }

    /**
     * @param crdExecutedList
     */
    public void setCrdExecutedList(List<CrdExecuted> crdExecutedList) {
        this.crdExecutedList = crdExecutedList;
    }

    /**
     * Gets steadyOperationScore
     *
     * @return value of steadyOperationScore
     */
    public SteadyOperationScore getSteadyOperationScore() {
        return steadyOperationScore;
    }

    /**
     * @param steadyOperationScore
     */
    public void setSteadyOperationScore(SteadyOperationScore steadyOperationScore) {
        this.steadyOperationScore = steadyOperationScore;
    }

    /**
     * Gets taxLegelList
     *
     * @return value of taxLegelList
     */
    public List<TaxLegel> getTaxLegelList() {
        return taxLegelList;
    }

    /**
     * @param taxLegelList
     */
    public void setTaxLegelList(List<TaxLegel> taxLegelList) {
        this.taxLegelList = taxLegelList;
    }

    /**
     * Gets etpSingleScore
     *
     * @return value of etpSingleScore
     */
    public EtpSingleScore getEtpSingleScore() {
        return etpSingleScore;
    }

    /**
     * @param etpSingleScore
     */
    public void setEtpSingleScore(EtpSingleScore etpSingleScore) {
        this.etpSingleScore = etpSingleScore;
    }
}
