package cn.bjd.platform.elastic.api.entity;

/**
 * 企业评分
 */
public class EtpSingleScore {

    /**
     * id
     */
    private String id;

    /**
     * 评分
     */
    private Double etpSingleScore;

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
     * Gets etpSingleScore
     *
     * @return value of etpSingleScore
     */
    public Double getEtpSingleScore() {
        return etpSingleScore;
    }

    /**
     * @param etpSingleScore
     */
    public void setEtpSingleScore(Double etpSingleScore) {
        this.etpSingleScore = etpSingleScore;
    }
}
