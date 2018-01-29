package cn.bjd.platform.elastic.api.entity;

import java.util.Date;

/**
 * 列入严重违法失信企业名单（黑名单）信息
 */
public class EtpIllegal implements EtpBase {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 裁决组织
     */
    private String decideOrg;

    /**
     * 裁决主要事实
     */
    private String mainFact;

    /**
     * 登入日期
     */
    private Date enrolDate;

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
     * Gets etpId
     *
     * @return value of etpId
     */
    public String getEtpId() {
        return etpId;
    }

    /**
     * @param etpId
     */
    public void setEtpId(String etpId) {
        this.etpId = etpId;
    }

    /**
     * Gets decideOrg
     *
     * @return value of decideOrg
     */
    public String getDecideOrg() {
        return decideOrg;
    }

    /**
     * @param decideOrg
     */
    public void setDecideOrg(String decideOrg) {
        this.decideOrg = decideOrg;
    }

    /**
     * Gets mainFact
     *
     * @return value of mainFact
     */
    public String getMainFact() {
        return mainFact;
    }

    /**
     * @param mainFact
     */
    public void setMainFact(String mainFact) {
        this.mainFact = mainFact;
    }

    /**
     * Gets enrolDate
     *
     * @return value of enrolDate
     */
    public Date getEnrolDate() {
        return enrolDate;
    }

    /**
     * @param enrolDate
     */
    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }
}
