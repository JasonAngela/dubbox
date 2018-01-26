package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class Stable extends DataEntity {

    private static final long serialVersionUID = 1L;

    private Integer score;

    private Double gdpGrowthRate;

    private Double expenditureGrowthRate;

    private Double companyGrowthCount;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
}
