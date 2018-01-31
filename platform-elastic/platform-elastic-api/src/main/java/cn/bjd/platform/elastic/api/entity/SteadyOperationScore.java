package cn.bjd.platform.elastic.api.entity;
/**
 * 税收、海关评级信息
 */
public class SteadyOperationScore {

    /**
     * id
     */
    private String id;

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 企业标识号
     */
    private String unIsCid;

    /**
     * 税收评级
     */
    private String taxRate;

    /**
     * 海关评级
     */
    private String customRate;

    /**
     * 企业评分
     */
    private Integer steadyOperationScore;

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
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets entName
     *
     * @return value of entName
     */
    public String getEntName() {
        return entName;
    }

    /**
     * @param entName
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * Gets unIsCid
     *
     * @return value of unIsCid
     */
    public String getUnIsCid() {
        return unIsCid;
    }

    /**
     * @param unIsCid
     */
    public void setUnIsCid(String unIsCid) {
        this.unIsCid = unIsCid;
    }

    /**
     * Gets taxRate
     *
     * @return value of taxRate
     */
    public String getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate
     */
    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Gets customRate
     *
     * @return value of customRate
     */
    public String getCustomRate() {
        return customRate;
    }

    /**
     * @param customRate
     */
    public void setCustomRate(String customRate) {
        this.customRate = customRate;
    }

    /**
     * Gets steadyOperationScore
     *
     * @return value of steadyOperationScore
     */
    public Integer getSteadyOperationScore() {
        return steadyOperationScore;
    }

    /**
     * @param steadyOperationScore
     */
    public void setSteadyOperationScore(Integer steadyOperationScore) {
        this.steadyOperationScore = steadyOperationScore;
    }
}
