package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

/**
 * 发展水平相关指标
 */
public class Development extends DataEntity {
    private static final long serialVersionUID = 1L;

    private Integer score = 0;

    private Double gDPtotal = 0D;

    private Double gDPAvg = 0D;

    private Double taxTotal = 0D;

    private Double avgLoanDeviation = 0D;

    private Double expenditure = 0D;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Double getgDPtotal() {
        return gDPtotal;
    }

    public void setgDPtotal(Double gDPtotal) {
        this.gDPtotal = gDPtotal;
    }

    public Double getgDPAvg() {
        return gDPAvg;
    }

    public void setgDPAvg(Double gDPAvg) {
        this.gDPAvg = gDPAvg;
    }

    public Double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(Double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public Double getAvgLoanDeviation() {
        return avgLoanDeviation;
    }

    public void setAvgLoanDeviation(Double avgLoanDeviation) {
        this.avgLoanDeviation = avgLoanDeviation;
    }

    public Double getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(Double expenditure) {
        this.expenditure = expenditure;
    }
}
