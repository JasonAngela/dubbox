package cn.bjd.platform.elastic.api.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ReadDTO implements Serializable {

    private String address;
    private String entName;
    private String legalRep;
    private String nameLike;
    private String regCapital;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date regDate;
    private String regState;

    private Double legalScore;
    private Double industryScore;
    private Double finScore;
    private Double etpScore;
    private Double areaScore;
    private Double etpTotalScore;

    private String accessStandar;
    private String accessBasicStandar;
    private String riskIdentify;
    private String riskControlMeasures;

    public String getRegState() {
        return regState;
    }

    public void setRegState(String regState) {
        this.regState = regState;
    }

    public String getLegalRep() {
        return legalRep;
    }

    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getNameLike() {
        return nameLike;
    }

    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Double getLegalScore() {
        return legalScore;
    }

    public void setLegalScore(Double legalScore) {
        this.legalScore = legalScore;
    }

    public Double getIndustryScore() {
        return industryScore;
    }

    public void setIndustryScore(Double industryScore) {
        this.industryScore = industryScore;
    }

    public Double getFinScore() {
        return finScore;
    }

    public void setFinScore(Double finScore) {
        this.finScore = finScore;
    }

    public Double getEtpScore() {
        return etpScore;
    }

    public void setEtpScore(Double etpScore) {
        this.etpScore = etpScore;
    }

    public Double getAreaScore() {
        return areaScore;
    }

    public void setAreaScore(Double areaScore) {
        this.areaScore = areaScore;
    }

    public Double getEtpTotalScore() {
        return etpTotalScore;
    }

    public void setEtpTotalScore(Double etpTotalScore) {
        this.etpTotalScore = etpTotalScore;
    }

    public String getAccessStandar() {
        return accessStandar;
    }

    public void setAccessStandar(String accessStandar) {
        this.accessStandar = accessStandar;
    }

    public String getAccessBasicStandar() {
        return accessBasicStandar;
    }

    public void setAccessBasicStandar(String accessBasicStandar) {
        this.accessBasicStandar = accessBasicStandar;
    }

    public String getRiskIdentify() {
        return riskIdentify;
    }

    public void setRiskIdentify(String riskIdentify) {
        this.riskIdentify = riskIdentify;
    }

    public String getRiskControlMeasures() {
        return riskControlMeasures;
    }

    public void setRiskControlMeasures(String riskControlMeasures) {
        this.riskControlMeasures = riskControlMeasures;
    }
}
