package cn.bjd.platform.elastic.api.entity.dto;

import cn.bjd.platform.elastic.api.entity.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RiskDTO implements Serializable {

    List<CrdCourt> crdCourt = new ArrayList<>();

    List<CrdCourtpub> crdCourtPub = new ArrayList<>();

    List<CrdExecuted> crdExecuted = new ArrayList<>();

    List<CrdBreakfaith> crdBreakfaith = new ArrayList<>();

    List<EtpAbnormal> etpAbnormal = new ArrayList<>();

    List<EtpPunish> etpPunish = new ArrayList<>();

    List<EtpStock> etpStock = new ArrayList<>();

    List<EtpChattel> etpChattel = new ArrayList<>();

    List<LegalScore> legalScore = new ArrayList<>();

    List<CrdCourt> relateCrdCourt = new ArrayList<>();

    public List<CrdCourt> getCrdCourt() {
        return crdCourt;
    }

    public void setCrdCourt(List<CrdCourt> crdCourt) {
        this.crdCourt = crdCourt;
    }

    public List<CrdCourtpub> getCrdCourtPub() {
        return crdCourtPub;
    }

    public void setCrdCourtPub(List<CrdCourtpub> crdCourtPub) {
        this.crdCourtPub = crdCourtPub;
    }

    public List<CrdExecuted> getCrdExecuted() {
        return crdExecuted;
    }

    public void setCrdExecuted(List<CrdExecuted> crdExecuted) {
        this.crdExecuted = crdExecuted;
    }

    public List<CrdBreakfaith> getCrdBreakfaith() {
        return crdBreakfaith;
    }

    public void setCrdBreakfaith(List<CrdBreakfaith> crdBreakfaith) {
        this.crdBreakfaith = crdBreakfaith;
    }

    public List<EtpAbnormal> getEtpAbnormal() {
        return etpAbnormal;
    }

    public void setEtpAbnormal(List<EtpAbnormal> etpAbnormal) {
        this.etpAbnormal = etpAbnormal;
    }

    public List<EtpPunish> getEtpPunish() {
        return etpPunish;
    }

    public void setEtpPunish(List<EtpPunish> etpPunish) {
        this.etpPunish = etpPunish;
    }

    public List<EtpStock> getEtpStock() {
        return etpStock;
    }

    public void setEtpStock(List<EtpStock> etpStock) {
        this.etpStock = etpStock;
    }

    public List<EtpChattel> getEtpChattel() {
        return etpChattel;
    }

    public void setEtpChattel(List<EtpChattel> etpChattel) {
        this.etpChattel = etpChattel;
    }

    public List<LegalScore> getLegalScore() {
        return legalScore;
    }

    public void setLegalScore(List<LegalScore> legalScore) {
        this.legalScore = legalScore;
    }

    public List<CrdCourt> getRelateCrdCourt() {
        return relateCrdCourt;
    }

    public void setRelateCrdCourt(List<CrdCourt> relateCrdCourt) {
        this.relateCrdCourt = relateCrdCourt;
    }
}