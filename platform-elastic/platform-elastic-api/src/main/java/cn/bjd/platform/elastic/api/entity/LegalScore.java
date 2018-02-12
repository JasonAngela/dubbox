package cn.bjd.platform.elastic.api.entity;

import cn.bjd.platform.common.api.DataEntity;

public class LegalScore extends DataEntity {

    private static final long serialVersionUID = 1L;

    private String entName;
    private String unIsCid;
    private Integer breakFaithCount;
    private Integer pubCount;
    private Integer courtCount;
    private Integer executedCount;
    private Integer legalCount;
    private Integer legalScore;

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getUnIsCid() {
        return unIsCid;
    }

    public void setUnIsCid(String unIsCid) {
        this.unIsCid = unIsCid;
    }

    public Integer getBreakFaithCount() {
        return breakFaithCount;
    }

    public void setBreakFaithCount(Integer breakFaithCount) {
        this.breakFaithCount = breakFaithCount;
    }

    public Integer getPubCount() {
        return pubCount;
    }

    public void setPubCount(Integer pubCount) {
        this.pubCount = pubCount;
    }

    public Integer getCourtCount() {
        return courtCount;
    }

    public void setCourtCount(Integer courtCount) {
        this.courtCount = courtCount;
    }

    public Integer getExecutedCount() {
        return executedCount;
    }

    public void setExecutedCount(Integer executedCount) {
        this.executedCount = executedCount;
    }

    public Integer getLegalCount() {
        return legalCount;
    }

    public void setLegalCount(Integer legalCount) {
        this.legalCount = legalCount;
    }

    public Integer getLegalScore() {
        return legalScore;
    }

    public void setLegalScore(Integer legalScore) {
        this.legalScore = legalScore;
    }
}