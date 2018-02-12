package cn.bjd.platform.elastic.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业商标信息 pd内容 list内容
 */
public class EtpBrand implements EtpBase,Serializable {

    /**
     * 商标Id
     */
    private String id;

    /**
     * 企业Id
     */
    private String etpId;

    /**
     * 商标名称
     */
    private String brandName;

    /**
     * 商标注册号
     */
    private String regCode;

    /**
     * 注册公告时间
     */
    private Date regNoticeDate;

    /**
     * 类别id
     */
    private String typeId;

    /**
     * 商标图片地址
     */
    private String brandImg;

    /**
     * 待确定
     */
    private String picName;



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
     * Gets brandName
     *
     * @return value of brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Gets regCode
     *
     * @return value of regCode
     */
    public String getRegCode() {
        return regCode;
    }

    /**
     * @param regCode
     */
    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    /**
     * Gets regNoticeDate
     *
     * @return value of regNoticeDate
     */
    public Date getRegNoticeDate() {
        return regNoticeDate;
    }

    /**
     * @param regNoticeDate
     */
    public void setRegNoticeDate(Date regNoticeDate) {
        this.regNoticeDate = regNoticeDate;
    }

    /**
     * Gets typeId
     *
     * @return value of typeId
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * @param typeId
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * Gets brandImg
     *
     * @return value of brandImg
     */
    public String getBrandImg() {
        return brandImg;
    }

    /**
     * @param brandImg
     */
    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg;
    }

    /**
     * Gets picName
     *
     * @return value of picName
     */
    public String getPicName() {
        return picName;
    }

    /**
     * @param picName
     */
    public void setPicName(String picName) {
        this.picName = picName;
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
