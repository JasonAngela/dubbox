package cn.bjd.platform.elastic.api.entity;

import java.util.Date;

/**
 * 股东出资信息
 */
public class EtpShareholder implements EtpBase {

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
     * 股东类型
     */
    private String holderType;


    /**
     * 股东类型名称
     */
    private String holderTypeName;

    /**
     * 证件号
     */
    private String cardNo;


    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件类型名称
     */
    private String cardTypeName;

    /**
     * 股东地址
     */
    private String address;

    /**
     *认缴额(万元)
     */
    private Double confusingAmount;

    /**
     * 认缴时间
     */
    private Date confusingData;

    /**
     * 实缴额(万元)
     */
    private Double payment;

    /**
     * 实缴额时间
     */
    private Date paymentDate;

    /**
     * 国家名称
     */
    private String countryName;

    /**
     * 公示日期
     */
    private Date openDate;

    /**
     * 外部id
     */
    private String outId;

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
     * Gets holderType
     *
     * @return value of holderType
     */
    public String getHolderType() {
        return holderType;
    }

    /**
     * @param holderType
     */
    public void setHolderType(String holderType) {
        this.holderType = holderType;
    }

    /**
     * Gets holderTypeName
     *
     * @return value of holderTypeName
     */
    public String getHolderTypeName() {
        return holderTypeName;
    }

    /**
     * @param holderTypeName
     */
    public void setHolderTypeName(String holderTypeName) {
        this.holderTypeName = holderTypeName;
    }

    /**
     * Gets cardNo
     *
     * @return value of cardNo
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * @param cardNo
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * Gets cardType
     *
     * @return value of cardType
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * @param cardType
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * Gets cardTypeName
     *
     * @return value of cardTypeName
     */
    public String getCardTypeName() {
        return cardTypeName;
    }

    /**
     * @param cardTypeName
     */
    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
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
     * Gets confusingAmount
     *
     * @return value of confusingAmount
     */
    public Double getConfusingAmount() {
        return confusingAmount;
    }

    /**
     * @param confusingAmount
     */
    public void setConfusingAmount(Double confusingAmount) {
        this.confusingAmount = confusingAmount;
    }

    /**
     * Gets confusingData
     *
     * @return value of confusingData
     */
    public Date getConfusingData() {
        return confusingData;
    }

    /**
     * @param confusingData
     */
    public void setConfusingData(Date confusingData) {
        this.confusingData = confusingData;
    }

    /**
     * Gets payment
     *
     * @return value of payment
     */
    public Double getPayment() {
        return payment;
    }

    /**
     * @param payment
     */
    public void setPayment(Double payment) {
        this.payment = payment;
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
     * Gets countryName
     *
     * @return value of countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
}
