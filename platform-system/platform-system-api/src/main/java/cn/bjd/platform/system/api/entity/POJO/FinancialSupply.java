package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class FinancialSupply extends DataEntity {

    private static final long serialVersionUID = 1L;

    private Integer score;

    private Double avgLoanDeviation;

    private Double peopleActivity;

    private Double gdpLoanRate;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Double getAvgLoanDeviation() {
        return avgLoanDeviation;
    }

    public void setAvgLoanDeviation(Double avgLoanDeviation) {
        this.avgLoanDeviation = avgLoanDeviation;
    }

    public Double getPeopleActivity() {
        return peopleActivity;
    }

    public void setPeopleActivity(Double peopleActivity) {
        this.peopleActivity = peopleActivity;
    }

    public Double getGdpLoanRate() {
        return gdpLoanRate;
    }

    public void setGdpLoanRate(Double gdpLoanRate) {
        this.gdpLoanRate = gdpLoanRate;
    }
}
