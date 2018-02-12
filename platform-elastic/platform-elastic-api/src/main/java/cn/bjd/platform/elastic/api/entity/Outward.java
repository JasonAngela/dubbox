package cn.bjd.platform.elastic.api.entity;

import cn.bjd.platform.common.api.DataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Outward extends DataEntity {

    private static final long serialVersionUID = 1L;

    private String etpName;
    private String legalRep;
    private Double paymentAmount;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date regDate;
    private String regStateCN;

    /**
     * 出资比例
     */
    private String rate;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getEtpName() {
        return etpName;
    }

    public void setEtpName(String etpName) {
        this.etpName = etpName;
    }

    public String getLegalRep() {
        return legalRep;
    }

    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getRegStateCN() {
        return regStateCN;
    }

    public void setRegStateCN(String regStateCN) {
        this.regStateCN = regStateCN;
    }
}