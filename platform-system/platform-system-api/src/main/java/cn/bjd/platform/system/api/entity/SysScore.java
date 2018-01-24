package cn.bjd.platform.system.api.entity;

import cn.bjd.platform.common.api.DataEntity;

public class SysScore extends DataEntity {

    private static final long serialVersionUID = 1L;

    private String province;

    private String city;

    private String area;

    private String code;

    private String explain;

    private Integer score;

    private Integer devScore;

    private Integer stableScore;

    private Integer finScore;

    private Integer riskScore;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDevScore() {
        return devScore;
    }

    public void setDevScore(Integer devScore) {
        this.devScore = devScore;
    }

    public Integer getStableScore() {
        return stableScore;
    }

    public void setStableScore(Integer stableScore) {
        this.stableScore = stableScore;
    }

    public Integer getFinScore() {
        return finScore;
    }

    public void setFinScore(Integer finScore) {
        this.finScore = finScore;
    }

    public Integer getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Integer riskScore) {
        this.riskScore = riskScore;
    }
}