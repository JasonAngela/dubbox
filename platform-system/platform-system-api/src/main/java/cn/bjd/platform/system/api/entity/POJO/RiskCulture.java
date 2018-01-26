package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class RiskCulture extends DataEntity {
    private static final long serialVersionUID = 1L;

    private Integer score;

    private Double avgCompanyLoan;

    private Double loanRatio;

    private Double crimeIndex;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
