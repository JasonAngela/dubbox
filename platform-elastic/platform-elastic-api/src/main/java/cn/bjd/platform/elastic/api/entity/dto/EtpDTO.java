package cn.bjd.platform.elastic.api.entity.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回的企业信息
 */
public class EtpDTO implements Serializable {

    /**
     * 企业的Id
     */
    private String id;

    /**
     * 企业的名称
     */
    private String entName;

    /**
     * 企业所在地址
     */
    private String address;

    /**
     * 企业注册日期
     */
    private Date regDate;

    /**
     * 注册资本
     */
    private Double regCapital;

    /**
     * 经度
     */
    private Double lng;

    /**
     * 维度
     */
    private Double lat;

    /**
     * 企业门类展示名称
     */
    private String categoryName;

    /**
     * 企业大类展示名称
     */
    private String bigCategoryName;

    /**
     * 企业种类展示名称
     */
    private String middleCategoryName;

    /**
     * 企业小类展示名称
     */
    private String smallCategoryName;

    /**
     * 海关评级
     */
    private String customs;

    /**
     * 税务评级
     */
    private String tax;

    /**
     * 涉讼数量
     */
    private Integer courtCount;

    /**
     * 违法数量
     */
    private Integer illegalCount;

    /**
     * 企业评分
     */
    private Double etpSingleScore;

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
     * Gets entName
     *
     * @return value of entName
     */
    public String getEntName() {
        return entName;
    }

    /**
     * @param entName
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * Gets address
     *
     * @return value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets regDate
     *
     * @return value of regDate
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * @param regDate
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /**
     * Gets regCapital
     *
     * @return value of regCapital
     */
    public Double getRegCapital() {
        return regCapital;
    }

    /**
     * @param regCapital
     */
    public void setRegCapital(Double regCapital) {
        this.regCapital = regCapital;
    }

    /**
     * Gets lng
     *
     * @return value of lng
     */
    public Double getLng() {
        return lng;
    }

    /**
     * @param lng
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * Gets lat
     *
     * @return value of lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * Gets categoryName
     *
     * @return value of categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets bigCategoryName
     *
     * @return value of bigCategoryName
     */
    public String getBigCategoryName() {
        return bigCategoryName;
    }

    /**
     * @param bigCategoryName
     */
    public void setBigCategoryName(String bigCategoryName) {
        this.bigCategoryName = bigCategoryName;
    }

    /**
     * Gets middleCategoryName
     *
     * @return value of middleCategoryName
     */
    public String getMiddleCategoryName() {
        return middleCategoryName;
    }

    /**
     * @param middleCategoryName
     */
    public void setMiddleCategoryName(String middleCategoryName) {
        this.middleCategoryName = middleCategoryName;
    }

    /**
     * Gets smallCategoryName
     *
     * @return value of smallCategoryName
     */
    public String getSmallCategoryName() {
        return smallCategoryName;
    }

    /**
     * @param smallCategoryName
     */
    public void setSmallCategoryName(String smallCategoryName) {
        this.smallCategoryName = smallCategoryName;
    }

    /**
     * Gets customs
     *
     * @return value of customs
     */
    public String getCustoms() {
        return customs;
    }

    /**
     * @param customs
     */
    public void setCustoms(String customs) {
        this.customs = customs;
    }

    /**
     * Gets tax
     *
     * @return value of tax
     */
    public String getTax() {
        return tax;
    }

    /**
     * @param tax
     */
    public void setTax(String tax) {
        this.tax = tax;
    }

    /**
     * Gets courtCount
     *
     * @return value of courtCount
     */
    public Integer getCourtCount() {
        return courtCount;
    }

    /**
     * @param courtCount
     */
    public void setCourtCount(Integer courtCount) {
        this.courtCount = courtCount;
    }

    /**
     * Gets illegalCount
     *
     * @return value of illegalCount
     */
    public Integer getIllegalCount() {
        return illegalCount;
    }

    /**
     * @param illegalCount
     */
    public void setIllegalCount(Integer illegalCount) {
        this.illegalCount = illegalCount;
    }

    /**
     * Gets etpSingleScore
     *
     * @return value of etpSingleScore
     */
    public Double getEtpSingleScore() {
        return etpSingleScore;
    }

    /**
     * @param etpSingleScore
     */
    public void setEtpSingleScore(Double etpSingleScore) {
        this.etpSingleScore = etpSingleScore;
    }
}
