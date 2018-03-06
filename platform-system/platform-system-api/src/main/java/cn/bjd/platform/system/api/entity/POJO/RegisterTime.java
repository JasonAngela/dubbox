package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class RegisterTime extends DataEntity {

    private static final long serialVersionUID = 1L;

    private String more10Year = "0%";
    private String between9And10Year = "0%";
    private String between7And8Year = "0%";
    private String between5And6Year = "0%";
    private String between3And4Year = "0%";
    private String between1And2Year = "0%";
    private String lessThanOneYear = "0%";

    public String getMore10Year() {
        return more10Year;
    }

    public void setMore10Year(String more10Year) {
        this.more10Year = more10Year;
    }

    public String getBetween9And10Year() {
        return between9And10Year;
    }

    public void setBetween9And10Year(String between9And10Year) {
        this.between9And10Year = between9And10Year;
    }

    public String getBetween7And8Year() {
        return between7And8Year;
    }

    public void setBetween7And8Year(String between7And8Year) {
        this.between7And8Year = between7And8Year;
    }

    public String getBetween5And6Year() {
        return between5And6Year;
    }

    public void setBetween5And6Year(String between5And6Year) {
        this.between5And6Year = between5And6Year;
    }

    public String getBetween3And4Year() {
        return between3And4Year;
    }

    public void setBetween3And4Year(String between3And4Year) {
        this.between3And4Year = between3And4Year;
    }

    public String getBetween1And2Year() {
        return between1And2Year;
    }

    public void setBetween1And2Year(String between1And2Year) {
        this.between1And2Year = between1And2Year;
    }

    public String getLessThanOneYear() {
        return lessThanOneYear;
    }

    public void setLessThanOneYear(String lessThanOneYear) {
        this.lessThanOneYear = lessThanOneYear;
    }
}