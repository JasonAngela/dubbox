package cn.bjd.platform.elastic.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业年报信息
 */
public class EtpReport implements EtpBase,Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 报送年度
     */
    private String sendYear;

    /**
     * 公示日期
     */
    private Date openDate;

    /**
     * 年报详情
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
     * Gets sendYear
     *
     * @return value of sendYear
     */
    public String getSendYear() {
        return sendYear;
    }

    /**
     * @param sendYear
     */
    public void setSendYear(String sendYear) {
        this.sendYear = sendYear;
    }

    /**
     * Gets openDate
     *
     * @return value of openDate
     */
    public Date getOpenDate() {
        return openDate;
    }

    /**
     * @param openDate
     */
    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
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
