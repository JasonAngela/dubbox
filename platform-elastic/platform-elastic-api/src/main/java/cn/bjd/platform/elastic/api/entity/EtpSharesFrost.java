package cn.bjd.platform.elastic.api.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/31.
 * 股权冻结历史信息
 */
public class EtpSharesFrost implements EtpBase {

    /**
     * 主键
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;


    /**
     * 被执行人
     */
    private String executor;

    /**
     * 协助公示通知书文号
     */
    private String executeNo;

    /**
     * 股权数额
     */
    private Double stockNum;

    /**
     * 股权数额--单位（万元）
     */
    private String stockNumUnit;

    /**
     * 股权数额--币种（人民币）
     */
    private String stockNumCapCur;

    /**
     * 裁决组织
     */
    private String decideOrg;

    /**
     * 冻结状态
     */
    private String frozenState;

    /**
     * 执行开始时间
     */
    private Date extStartDate;

    /**
     * 执行结束时间
     */
    private Date extEndDate;

    /**
     * 被执行人证件号码
     */
    private String extCardId;

    /**
     * 被执行人证件类型
     */
    private String extCardType;

    /**
     * 执行事项
     */
    private String extMatter;

    /**
     * 执行周期
     */
    private String extTerm;

    /**
     * 公示日期
     */
    private Date publicDate;

    /**
     * 执行裁定书文号
     */
    private String extJudgeNo;

    /**
     * 外部id
     */
    private String outId;

    /**
     * 外部企业id
     */
    private String outEtpId;

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets etpId
     *
     * @return value of etpId
     */
    public String getEtpId() {
        return etpId;
    }

    /**
     * @param etpId
     */
    public void setEtpId(String etpId) {
        this.etpId = etpId;
    }

    /**
     * Gets executor
     *
     * @return value of executor
     */
    public String getExecutor() {
        return executor;
    }

    /**
     * @param executor
     */
    public void setExecutor(String executor) {
        this.executor = executor;
    }

    /**
     * Gets executeNo
     *
     * @return value of executeNo
     */
    public String getExecuteNo() {
        return executeNo;
    }

    /**
     * @param executeNo
     */
    public void setExecuteNo(String executeNo) {
        this.executeNo = executeNo;
    }

    /**
     * Gets stockNum
     *
     * @return value of stockNum
     */
    public Double getStockNum() {
        return stockNum;
    }

    /**
     * @param stockNum
     */
    public void setStockNum(Double stockNum) {
        this.stockNum = stockNum;
    }

    /**
     * Gets stockNumUnit
     *
     * @return value of stockNumUnit
     */
    public String getStockNumUnit() {
        return stockNumUnit;
    }

    /**
     * @param stockNumUnit
     */
    public void setStockNumUnit(String stockNumUnit) {
        this.stockNumUnit = stockNumUnit;
    }

    /**
     * Gets stockNumCapCur
     *
     * @return value of stockNumCapCur
     */
    public String getStockNumCapCur() {
        return stockNumCapCur;
    }

    /**
     * @param stockNumCapCur
     */
    public void setStockNumCapCur(String stockNumCapCur) {
        this.stockNumCapCur = stockNumCapCur;
    }

    /**
     * Gets decideOrg
     *
     * @return value of decideOrg
     */
    public String getDecideOrg() {
        return decideOrg;
    }

    /**
     * @param decideOrg
     */
    public void setDecideOrg(String decideOrg) {
        this.decideOrg = decideOrg;
    }

    /**
     * Gets frozenState
     *
     * @return value of frozenState
     */
    public String getFrozenState() {
        return frozenState;
    }

    /**
     * @param frozenState
     */
    public void setFrozenState(String frozenState) {
        this.frozenState = frozenState;
    }

    /**
     * Gets extStartDate
     *
     * @return value of extStartDate
     */
    public Date getExtStartDate() {
        return extStartDate;
    }

    /**
     * @param extStartDate
     */
    public void setExtStartDate(Date extStartDate) {
        this.extStartDate = extStartDate;
    }

    /**
     * Gets extEndDate
     *
     * @return value of extEndDate
     */
    public Date getExtEndDate() {
        return extEndDate;
    }

    /**
     * @param extEndDate
     */
    public void setExtEndDate(Date extEndDate) {
        this.extEndDate = extEndDate;
    }

    /**
     * Gets extCardId
     *
     * @return value of extCardId
     */
    public String getExtCardId() {
        return extCardId;
    }

    /**
     * @param extCardId
     */
    public void setExtCardId(String extCardId) {
        this.extCardId = extCardId;
    }

    /**
     * Gets extCardType
     *
     * @return value of extCardType
     */
    public String getExtCardType() {
        return extCardType;
    }

    /**
     * @param extCardType
     */
    public void setExtCardType(String extCardType) {
        this.extCardType = extCardType;
    }

    /**
     * Gets extMatter
     *
     * @return value of extMatter
     */
    public String getExtMatter() {
        return extMatter;
    }

    /**
     * @param extMatter
     */
    public void setExtMatter(String extMatter) {
        this.extMatter = extMatter;
    }

    /**
     * Gets extTerm
     *
     * @return value of extTerm
     */
    public String getExtTerm() {
        return extTerm;
    }

    /**
     * @param extTerm
     */
    public void setExtTerm(String extTerm) {
        this.extTerm = extTerm;
    }

    /**
     * Gets publicDate
     *
     * @return value of publicDate
     */
    public Date getPublicDate() {
        return publicDate;
    }

    /**
     * @param publicDate
     */
    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    /**
     * Gets extJudgeNo
     *
     * @return value of extJudgeNo
     */
    public String getExtJudgeNo() {
        return extJudgeNo;
    }

    /**
     * @param extJudgeNo
     */
    public void setExtJudgeNo(String extJudgeNo) {
        this.extJudgeNo = extJudgeNo;
    }

    /**
     * Gets outId
     *
     * @return value of outId
     */
    public String getOutId() {
        return outId;
    }

    /**
     * @param outId
     */
    public void setOutId(String outId) {
        this.outId = outId;
    }

    /**
     * Gets outEtpId
     *
     * @return value of outEtpId
     */
    public String getOutEtpId() {
        return outEtpId;
    }

    /**
     * @param outEtpId
     */
    public void setOutEtpId(String outEtpId) {
        this.outEtpId = outEtpId;
    }
}
