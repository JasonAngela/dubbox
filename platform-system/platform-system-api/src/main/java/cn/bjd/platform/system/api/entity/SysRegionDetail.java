package cn.bjd.platform.system.api.entity;

import cn.bjd.platform.common.api.DataEntity;

public class SysRegionDetail extends DataEntity {

    private static final long serialVersionUID = 1L;

    /**
     * GDP总量
     */
    private Double gdpTotal;

    /**
     * 人均GDP
     */
    private Double gdpAvg;

    /**
     * 税收总量
     */
    private Double taxTotal;

    /**
     * 人均贷款偏离度
     */
    private Double avgLoanDeviation;

    /**
     * 财政支出
     */
    private Double expenditure;

    /**
     * GDP增长率
     */
    private Double gdpGrowthRate;

    /**
     * 财政收入增长率
     */
    private Double expenditureGrowthRate;

    /**
     * 本地新注册法人增长水平
     */
    private Double companyGrowthCount;

    /**
     * 企业户均贷款额度平均偏离度
     */
    private Double avgCompanyLoanDeviation;

    /**
     * 民间金融活跃度
     */
    private Double people_activity;

    /**
     * 贷款GDP贡献率
     */
    private Double gdpLoanRate;

    /**
     * 企业户均涉金融债数量
     */
    private Double avgCompanyLoan;

    /**
     * 货存比
     */
    private Double loanRatio;


    /**
     * 金融犯罪指数
     */
    private Double crimeIndex;

    public Double getGdpTotal() {
        return gdpTotal;
    }

    public void setGdpTotal(Double gdpTotal) {
        this.gdpTotal = gdpTotal;
    }

    public Double getGdpAvg() {
        return gdpAvg;
    }

    public void setGdpAvg(Double gdpAvg) {
        this.gdpAvg = gdpAvg;
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

    public Double getGdpGrowthRate() {
        return gdpGrowthRate;
    }

    public void setGdpGrowthRate(Double gdpGrowthRate) {
        this.gdpGrowthRate = gdpGrowthRate;
    }

    public Double getExpenditureGrowthRate() {
        return expenditureGrowthRate;
    }

    public void setExpenditureGrowthRate(Double expenditureGrowthRate) {
        this.expenditureGrowthRate = expenditureGrowthRate;
    }

    public Double getCompanyGrowthCount() {
        return companyGrowthCount;
    }

    public void setCompanyGrowthCount(Double companyGrowthCount) {
        this.companyGrowthCount = companyGrowthCount;
    }

    public Double getAvgCompanyLoanDeviation() {
        return avgCompanyLoanDeviation;
    }

    public void setAvgCompanyLoanDeviation(Double avgCompanyLoanDeviation) {
        this.avgCompanyLoanDeviation = avgCompanyLoanDeviation;
    }

    public Double getPeople_activity() {
        return people_activity;
    }

    public void setPeople_activity(Double people_activity) {
        this.people_activity = people_activity;
    }

    public Double getGdpLoanRate() {
        return gdpLoanRate;
    }

    public void setGdpLoanRate(Double gdpLoanRate) {
        this.gdpLoanRate = gdpLoanRate;
    }

    public Double getAvgCompanyLoan() {
        return avgCompanyLoan;
    }

    public void setAvgCompanyLoan(Double avgCompanyLoan) {
        this.avgCompanyLoan = avgCompanyLoan;
    }

    public Double getLoanRatio() {
        return loanRatio;
    }

    public void setLoanRatio(Double loanRatio) {
        this.loanRatio = loanRatio;
    }

    public Double getCrimeIndex() {
        return crimeIndex;
    }

    public void setCrimeIndex(Double crimeIndex) {
        this.crimeIndex = crimeIndex;
    }
}