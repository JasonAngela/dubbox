package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

import java.util.ArrayList;
import java.util.List;

public class Illegal extends DataEntity {
    private static final long serialVersionUID = 1L;

    private List<BasicModel> breakFaith = new ArrayList<>();

    private List<BasicModel> court = new ArrayList<>();

    private List<BasicModel> courtPub = new ArrayList<>();

    private List<BasicModel> executed = new ArrayList<>();

    private List<BasicModel> customs = new ArrayList<>();

    private List<BasicModel> tax = new ArrayList<>();

    public List<BasicModel> getBreakFaith() {
        return breakFaith;
    }

    public void setBreakFaith(List<BasicModel> breakFaith) {
        this.breakFaith = breakFaith;
    }

    public List<BasicModel> getCourt() {
        return court;
    }

    public void setCourt(List<BasicModel> court) {
        this.court = court;
    }

    public List<BasicModel> getCourtPub() {
        return courtPub;
    }

    public void setCourtPub(List<BasicModel> courtPub) {
        this.courtPub = courtPub;
    }

    public List<BasicModel> getExecuted() {
        return executed;
    }

    public void setExecuted(List<BasicModel> executed) {
        this.executed = executed;
    }

    public List<BasicModel> getCustoms() {
        return customs;
    }

    public void setCustoms(List<BasicModel> customs) {
        this.customs = customs;
    }

    public List<BasicModel> getTax() {
        return tax;
    }

    public void setTax(List<BasicModel> tax) {
        this.tax = tax;
    }
}