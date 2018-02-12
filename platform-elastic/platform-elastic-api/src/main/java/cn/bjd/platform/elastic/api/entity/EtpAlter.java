package cn.bjd.platform.elastic.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业变更信息
 */
public class EtpAlter implements EtpBase,Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 变更事项
     */
    private String changeEvent;

    /**
     * 变更项ID
     */
    private String changeItemId;

    /**
     * 变更前
     */

    private String preChange;

    /**
     * 变更后
     */
    private String aftChange;

    /**
     * 变更时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date changeDate;

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
     * Gets changeEvent
     *
     * @return value of changeEvent
     */
    public String getChangeEvent() {
        return changeEvent;
    }

    /**
     * @param changeEvent
     */
    public void setChangeEvent(String changeEvent) {
        this.changeEvent = changeEvent;
    }

    /**
     * Gets changeItemId
     *
     * @return value of changeItemId
     */
    public String getChangeItemId() {
        return changeItemId;
    }

    /**
     * @param changeItemId
     */
    public void setChangeItemId(String changeItemId) {
        this.changeItemId = changeItemId;
    }

    /**
     * Gets preChange
     *
     * @return value of preChange
     */
    public String getPreChange() {
        return preChange;
    }

    /**
     * @param preChange
     */
    public void setPreChange(String preChange) {
        this.preChange = preChange;
    }

    /**
     * Gets aftChange
     *
     * @return value of aftChange
     */
    public String getAftChange() {
        return aftChange;
    }

    /**
     * @param aftChange
     */
    public void setAftChange(String aftChange) {
        this.aftChange = aftChange;
    }

    /**
     * Gets changeDate
     *
     * @return value of changeDate
     */
    public Date getChangeDate() {
        return changeDate;
    }

    /**
     * @param changeDate
     */
    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
}
