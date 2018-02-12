package cn.bjd.platform.elastic.api.entity;

import cn.bjd.platform.common.api.DataEntity;

import java.util.Date;

public class EtpScore extends DataEntity {
    private static final long serialVersionUID = 1L;

    private String entName;
    private String unIsCid;
    private Integer etpLegalScore;
    private Double areaLegalScore;
    private Double industryCreditScore;
    private Double areaFinScore;
    private Integer etpLiveScore;
    private Double areaDevScore;

    private Double canBeChoose;
    private Double totalLegal;
    private Double totalIndustry;
    private Double totalFin;
    private Double totalEtp;
    private Double totalArea;
    private Double totalEtpScore;
    private String allert;
    private Date upgrade_datetime;

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

    public Integer getEtpLegalScore() {
        return etpLegalScore;
    }

    public void setEtpLegalScore(Integer etpLegalScore) {
        this.etpLegalScore = etpLegalScore;
    }

    public Double getAreaLegalScore() {
        return areaLegalScore;
    }

    public void setAreaLegalScore(Double areaLegalScore) {
        this.areaLegalScore = areaLegalScore;
    }

    public Double getIndustryCreditScore() {
        return industryCreditScore;
    }

    public void setIndustryCreditScore(Double industryCreditScore) {
        this.industryCreditScore = industryCreditScore;
    }

    public Double getAreaFinScore() {
        return areaFinScore;
    }

    public void setAreaFinScore(Double areaFinScore) {
        this.areaFinScore = areaFinScore;
    }

    public Integer getEtpLiveScore() {
        return etpLiveScore;
    }

    public void setEtpLiveScore(Integer etpLiveScore) {
        this.etpLiveScore = etpLiveScore;
    }

    public Double getAreaDevScore() {
        return areaDevScore;
    }

    public void setAreaDevScore(Double areaDevScore) {
        this.areaDevScore = areaDevScore;
    }

    public Double getCanBeChoose() {
        return canBeChoose;
    }

    public void setCanBeChoose(Double canBeChoose) {
        this.canBeChoose = canBeChoose;
    }

    public Double getTotalLegal() {
        return totalLegal;
    }

    public void setTotalLegal(Double totalLegal) {
        this.totalLegal = totalLegal;
    }

    public Double getTotalIndustry() {
        return totalIndustry;
    }

    public void setTotalIndustry(Double totalIndustry) {
        this.totalIndustry = totalIndustry;
    }

    public Double getTotalFin() {
        return totalFin;
    }

    public void setTotalFin(Double totalFin) {
        this.totalFin = totalFin;
    }

    public Double getTotalEtp() {
        return totalEtp;
    }

    public void setTotalEtp(Double totalEtp) {
        this.totalEtp = totalEtp;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public Double getTotalEtpScore() {
        return totalEtpScore;
    }

    public void setTotalEtpScore(Double totalEtpScore) {
        this.totalEtpScore = totalEtpScore;
    }

    public String getAllert() {
        return allert;
    }

    public void setAllert(String allert) {
        this.allert = allert;
    }

    public Date getUpgrade_datetime() {
        return upgrade_datetime;
    }

    public void setUpgrade_datetime(Date upgrade_datetime) {
        this.upgrade_datetime = upgrade_datetime;
    }
}
