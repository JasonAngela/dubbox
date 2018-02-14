package cn.bjd.platform.elastic.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 股权变更信息
 */
public class EtpStockChange implements EtpBase,Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 股东
     */
    private String shareholder;

    /**
     * 变更前股权比例
     */
    private String preScale;

    /**
     *变更后股权比例
     */
    private String afterScale;

    /**
     * 变更日期
     */
    private Date changeDate;

    /**
     * 公示日期
     */
    private Date openDate;

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
     * Gets shareholder
     *
     * @return value of shareholder
     */
    public String getShareholder() {
        return shareholder;
    }

    /**
     * @param shareholder
     */
    public void setShareholder(String shareholder) {
        this.shareholder = shareholder;
    }

    /**
     * Gets preScale
     *
     * @return value of preScale
     */
    public String getPreScale() {
        return preScale;
    }

    /**
     * @param preScale
     */
    public void setPreScale(String preScale) {
        this.preScale = preScale;
    }

    /**
     * Gets afterScale
     *
     * @return value of afterScale
     */
    public String getAfterScale() {
        return afterScale;
    }

    /**
     * @param afterScale
     */
    public void setAfterScale(String afterScale) {
        this.afterScale = afterScale;
    }

    /**
     * Gets changeDate
     *
     * @return value of changeDate
     */
    public Date getChangeDate() {
        return changeDate;
    }

    /**
     * @param changeDate
     */
    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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
