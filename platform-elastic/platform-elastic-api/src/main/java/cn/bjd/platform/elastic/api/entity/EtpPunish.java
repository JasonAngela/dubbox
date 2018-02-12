package cn.bjd.platform.elastic.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 行政处罚信息
 */
public class EtpPunish implements EtpBase,Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 判决文书编号
     */
    private String decisionNum;

    /**
     * 违法行为类型
     */
    private String ilegalType;

    /**
     * 案由ID
     */
    private String caseId;

    /**
     * 处罚类型名称
     */
    private String punishTypeName;

    /**
     * 行政处罚内容
     */
    private String content;

    /**
     * 判决机关名称
     */
    private String officeName;

    /**
     * 判决日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date punishDate;

    /**
     * 公示日期
     */
    private Date publicDate;

    /**
     * 备注
     */
    private String remarks;

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
     * Gets decisionNum
     *
     * @return value of decisionNum
     */
    public String getDecisionNum() {
        return decisionNum;
    }

    /**
     * @param decisionNum
     */
    public void setDecisionNum(String decisionNum) {
        this.decisionNum = decisionNum;
    }

    /**
     * Gets ilegalType
     *
     * @return value of ilegalType
     */
    public String getIlegalType() {
        return ilegalType;
    }

    /**
     * @param ilegalType
     */
    public void setIlegalType(String ilegalType) {
        this.ilegalType = ilegalType;
    }

    /**
     * Gets caseId
     *
     * @return value of caseId
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * @param caseId
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    /**
     * Gets punishTypeName
     *
     * @return value of punishTypeName
     */
    public String getPunishTypeName() {
        return punishTypeName;
    }

    /**
     * @param punishTypeName
     */
    public void setPunishTypeName(String punishTypeName) {
        this.punishTypeName = punishTypeName;
    }

    /**
     * Gets content
     *
     * @return value of content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets officeName
     *
     * @return value of officeName
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * @param officeName
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    /**
     * Gets punishDate
     *
     * @return value of punishDate
     */
    public Date getPunishDate() {
        return punishDate;
    }

    /**
     * @param punishDate
     */
    public void setPunishDate(Date punishDate) {
        this.punishDate = punishDate;
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
     * Gets remarks
     *
     * @return value of remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
