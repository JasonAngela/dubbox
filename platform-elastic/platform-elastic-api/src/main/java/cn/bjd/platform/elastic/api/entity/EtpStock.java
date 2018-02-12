package cn.bjd.platform.elastic.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 股权出质登记信息
 */
public class EtpStock implements EtpBase,Serializable {

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
    private String regNum;

    /**
     * 出质人
     */
    private String pledgor;

    /**
     * 出质人证照/证件号码
     */
    private String pledgorCardNum;

    /**
     * 出质人证件类型
     */
    private String pledgorCardType;

    /**
     * 出质人证件类型名称
     */
    private String pledgorCardTypeName;

    /**
     * 出质股权数额
     */
    private Double stockAmount;

    /**
     * 质权人
     */
    private String pledgee;

    /**
     * 质权人证照/证件号码
     */
    private String pledgeeCardNum;

    /**
     * 质权人证件类型
     */
    private String pledgeeCardType;

    /**
     * 质权人证件类型名称
     */
    private String pledgeeCardTypeName;


    /**
     * 注资方式
     */
    private String regCapCur;

    /**
     * 注资方式名称
     */
    private String regCapCurName;

    /**
     * 登记日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date regDate;

    /**
     * 状态（1 有效  2 无效）
     */
    private String state;

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
     * Gets regNum
     *
     * @return value of regNum
     */
    public String getRegNum() {
        return regNum;
    }

    /**
     * @param regNum
     */
    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    /**
     * Gets pledgor
     *
     * @return value of pledgor
     */
    public String getPledgor() {
        return pledgor;
    }

    /**
     * @param pledgor
     */
    public void setPledgor(String pledgor) {
        this.pledgor = pledgor;
    }

    /**
     * Gets pledgorCardNum
     *
     * @return value of pledgorCardNum
     */
    public String getPledgorCardNum() {
        return pledgorCardNum;
    }

    /**
     * @param pledgorCardNum
     */
    public void setPledgorCardNum(String pledgorCardNum) {
        this.pledgorCardNum = pledgorCardNum;
    }

    /**
     * Gets pledgorCardType
     *
     * @return value of pledgorCardType
     */
    public String getPledgorCardType() {
        return pledgorCardType;
    }

    /**
     * @param pledgorCardType
     */
    public void setPledgorCardType(String pledgorCardType) {
        this.pledgorCardType = pledgorCardType;
    }

    /**
     * Gets pledgorCardTypeName
     *
     * @return value of pledgorCardTypeName
     */
    public String getPledgorCardTypeName() {
        return pledgorCardTypeName;
    }

    /**
     * @param pledgorCardTypeName
     */
    public void setPledgorCardTypeName(String pledgorCardTypeName) {
        this.pledgorCardTypeName = pledgorCardTypeName;
    }

    /**
     * Gets stockAmount
     *
     * @return value of stockAmount
     */
    public Double getStockAmount() {
        return stockAmount;
    }

    /**
     * @param stockAmount
     */
    public void setStockAmount(Double stockAmount) {
        this.stockAmount = stockAmount;
    }

    /**
     * Gets pledgee
     *
     * @return value of pledgee
     */
    public String getPledgee() {
        return pledgee;
    }

    /**
     * @param pledgee
     */
    public void setPledgee(String pledgee) {
        this.pledgee = pledgee;
    }

    /**
     * Gets pledgeeCardNum
     *
     * @return value of pledgeeCardNum
     */
    public String getPledgeeCardNum() {
        return pledgeeCardNum;
    }

    /**
     * @param pledgeeCardNum
     */
    public void setPledgeeCardNum(String pledgeeCardNum) {
        this.pledgeeCardNum = pledgeeCardNum;
    }

    /**
     * Gets pledgeeCardType
     *
     * @return value of pledgeeCardType
     */
    public String getPledgeeCardType() {
        return pledgeeCardType;
    }

    /**
     * @param pledgeeCardType
     */
    public void setPledgeeCardType(String pledgeeCardType) {
        this.pledgeeCardType = pledgeeCardType;
    }

    /**
     * Gets pledgeeCardTypeName
     *
     * @return value of pledgeeCardTypeName
     */
    public String getPledgeeCardTypeName() {
        return pledgeeCardTypeName;
    }

    /**
     * @param pledgeeCardTypeName
     */
    public void setPledgeeCardTypeName(String pledgeeCardTypeName) {
        this.pledgeeCardTypeName = pledgeeCardTypeName;
    }

    /**
     * Gets regCapCur
     *
     * @return value of regCapCur
     */
    public String getRegCapCur() {
        return regCapCur;
    }

    /**
     * @param regCapCur
     */
    public void setRegCapCur(String regCapCur) {
        this.regCapCur = regCapCur;
    }

    /**
     * Gets regCapCurName
     *
     * @return value of regCapCurName
     */
    public String getRegCapCurName() {
        return regCapCurName;
    }

    /**
     * @param regCapCurName
     */
    public void setRegCapCurName(String regCapCurName) {
        this.regCapCurName = regCapCurName;
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
