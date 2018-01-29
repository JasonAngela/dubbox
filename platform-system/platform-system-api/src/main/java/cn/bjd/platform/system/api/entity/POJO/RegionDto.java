package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class RegionDto extends DataEntity {
    private static final long serialVersionUID = 1L;

    private Development development;
    private Stable stable;
    private FinancialSupply financialSupply;
    private RiskCulture riskCulture;
    private Integer score;

    public Development getDevelopment() {
        return development;
    }

    public void setDevelopment(Development development) {
        this.development = development;
    }

    public Stable getStable() {
        return stable;
    }

    public void setStable(Stable stable) {
        this.stable = stable;
    }

    public FinancialSupply getFinancialSupply() {
        return financialSupply;
    }

    public void setFinancialSupply(FinancialSupply financialSupply) {
        this.financialSupply = financialSupply;
    }

    public RiskCulture getRiskCulture() {
        return riskCulture;
    }

    public void setRiskCulture(RiskCulture riskCulture) {
        this.riskCulture = riskCulture;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
