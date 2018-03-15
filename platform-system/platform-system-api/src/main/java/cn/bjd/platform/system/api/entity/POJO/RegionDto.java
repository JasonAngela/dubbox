package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class RegionDto extends DataEntity {
    private static final long serialVersionUID = 1L;

    private Development development = new Development();
    private Stable stable = new Stable();
    private FinancialSupply financialSupply = new FinancialSupply();
    private RiskCulture riskCulture = new RiskCulture();
    private Limit limit = new Limit();
    private Float score = 0F;

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

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

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
