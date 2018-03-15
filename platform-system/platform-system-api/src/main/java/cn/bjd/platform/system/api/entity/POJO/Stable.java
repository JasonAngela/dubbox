package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class Stable extends DataEntity {

    private static final long serialVersionUID = 1L;

    private Integer score = 0;

    private Double gdpGrowthRate = 0D;

    private Double expenditureGrowthRate = 0D;

    private Double companyGrowthCount = 0D;

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
