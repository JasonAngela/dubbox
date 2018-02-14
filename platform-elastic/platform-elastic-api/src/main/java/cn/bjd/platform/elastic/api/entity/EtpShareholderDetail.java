package cn.bjd.platform.elastic.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/31.
 */
public class EtpShareholderDetail implements EtpBase,Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 出资项ID
     */
    private String shareHolderId;

    /**
     * 出资人
     */
    private String shareHolderName;

    /**
     *出资方式
     */

    private String paymentMethod;

    /**
     * 出资额(万元)
     */
    private Double paymentAmount;

    /**
     * 出资日期
     */
    private Date paymentDate;

    /**
     * 1: 认缴；2：实缴
     */
    private Integer type;


    /**
     * 公示日期
     */
    private Date openDate;

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
     * Gets shareHolderId
     *
     * @return value of shareHolderId
     */
    public String getShareHolderId() {
        return shareHolderId;
    }

    /**
     * @param shareHolderId
     */
    public void setShareHolderId(String shareHolderId) {
        this.shareHolderId = shareHolderId;
    }

    /**
     * Gets shareHolderName
     *
     * @return value of shareHolderName
     */
    public String getShareHolderName() {
        return shareHolderName;
    }

    /**
     * @param shareHolderName
     */
    public void setShareHolderName(String shareHolderName) {
        this.shareHolderName = shareHolderName;
    }

    /**
     * Gets paymentMethod
     *
     * @return value of paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets paymentAmount
     *
     * @return value of paymentAmount
     */
    public Double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @param paymentAmount
     */
    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * Gets paymentDate
     *
     * @return value of paymentDate
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
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
