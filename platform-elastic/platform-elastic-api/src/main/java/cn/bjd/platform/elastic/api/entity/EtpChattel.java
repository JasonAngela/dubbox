package cn.bjd.platform.elastic.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 动产抵押信息
 */
public class EtpChattel implements EtpBase,Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 登记编号
     */
    private String regNumber;

    /**
     * 登记日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date recordDate;

    /**
     * 登记机关
     */
    private String regAuthority;

    /**
     * 被担保债权数额（万）
     */
    private Double claimsAmount;

    /**
     * 货币单位
     */
    private String regcapcur;

    /**
     * 状态（1.有效 2 无效）
     */
    private String state;

    /**
     * 公示日期
     */
    private Date publicityDate;

    /**
     * 详情
     */
    private String detail;

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
     * Gets regNumber
     *
     * @return value of regNumber
     */
    public String getRegNumber() {
        return regNumber;
    }

    /**
     * @param regNumber
     */
    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    /**
     * Gets recordDate
     *
     * @return value of recordDate
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * @param recordDate
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * Gets regAuthority
     *
     * @return value of regAuthority
     */
    public String getRegAuthority() {
        return regAuthority;
    }

    /**
     * @param regAuthority
     */
    public void setRegAuthority(String regAuthority) {
        this.regAuthority = regAuthority;
    }

    /**
     * Gets claimsAmount
     *
     * @return value of claimsAmount
     */
    public Double getClaimsAmount() {
        return claimsAmount;
    }

    /**
     * @param claimsAmount
     */
    public void setClaimsAmount(Double claimsAmount) {
        this.claimsAmount = claimsAmount;
    }

    /**
     * Gets regcapcur
     *
     * @return value of regcapcur
     */
    public String getRegcapcur() {
        return regcapcur;
    }

    /**
     * @param regcapcur
     */
    public void setRegcapcur(String regcapcur) {
        this.regcapcur = regcapcur;
    }

    /**
     * Gets state
     *
     * @return value of state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets publicityDate
     *
     * @return value of publicityDate
     */
    public Date getPublicityDate() {
        return publicityDate;
    }

    /**
     * @param publicityDate
     */
    public void setPublicityDate(Date publicityDate) {
        this.publicityDate = publicityDate;
    }

    /**
     * Gets detail
     *
     * @return value of detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
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