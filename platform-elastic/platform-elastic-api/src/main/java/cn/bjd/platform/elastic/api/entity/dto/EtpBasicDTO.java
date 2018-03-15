package cn.bjd.platform.elastic.api.entity.dto;

import cn.bjd.platform.elastic.api.entity.EtpAlter;
import cn.bjd.platform.elastic.api.entity.EtpSeniorManager;
import cn.bjd.platform.elastic.api.entity.EtpShareholder;
import cn.bjd.platform.elastic.api.entity.Outward;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EtpBasicDTO implements Serializable {

    private String creditCode = "";
    private String regState = "";
    private String industry = "";


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date regDate;

    private String type = "";
    private Date businessStart;
    private Date businessFinish;

    private String businessStartFinish;

    private String legalRep;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date checkDate;

    private String regCapital = "";
    private String regOffice = "";
    private String businessScope = "";
    private String address = "";

    private List<EtpShareholder> etpShareholder = new ArrayList<>();

    private List<EtpSeniorManager> etpSeniorManager = new ArrayList<>();

    private List<Outward> outward = new ArrayList<>();

    private List<EtpAlter> etpAlter = new ArrayList<>();


    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getRegState() {
        return regState;
    }

    public void setRegState(String regState) {
        this.regState = regState;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getBusinessStart() {
        return businessStart;
    }

    public void setBusinessStart(Date businessStart) {
        this.businessStart = businessStart;
    }

    public Date getBusinessFinish() {
        return businessFinish;
    }

    public void setBusinessFinish(Date businessFinish) {
        this.businessFinish = businessFinish;
    }

    public String getBusinessStartFinish() {
        return businessStartFinish;
    }

    public void setBusinessStartFinish(String businessStartFinish) {
        this.businessStartFinish = businessStartFinish;
    }

    public String getLegalRep() {
        return legalRep;
    }

    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    public String getRegOffice() {
        return regOffice;
    }

    public void setRegOffice(String regOffice) {
        this.regOffice = regOffice;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<EtpShareholder> getEtpShareholder() {
        return etpShareholder;
    }

    public void setEtpShareholder(List<EtpShareholder> etpShareholder) {
        this.etpShareholder = etpShareholder;
    }

    public List<EtpSeniorManager> getEtpSeniorManager() {
        return etpSeniorManager;
    }

    public void setEtpSeniorManager(List<EtpSeniorManager> etpSeniorManager) {
        this.etpSeniorManager = etpSeniorManager;
    }

    public List<Outward> getOutward() {
        return outward;
    }

    public void setOutward(List<Outward> outward) {
        this.outward = outward;
    }

    public List<EtpAlter> getEtpAlter() {
        return etpAlter;
    }

    public void setEtpAlter(List<EtpAlter> etpAlter) {
        this.etpAlter = etpAlter;
    }
}