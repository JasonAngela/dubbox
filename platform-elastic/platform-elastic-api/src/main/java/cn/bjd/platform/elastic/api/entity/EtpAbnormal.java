package cn.bjd.platform.elastic.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 列入经营异常名录信息
 */
public class EtpAbnormal implements EtpBase, Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 列入经营异常名录原因
     */
    private String enrolReason;

    /**
     * 列入日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date enrolDate;

    /**
     * 作出决定机关（列入）
     */
    private String enrolOffice;

    /**
     * 移除原因
     */
    private String removeReason;

    /**
     * 移除日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date removeDate;

    /**
     * 作出决定机关(移出)
     */
    private String removeOffice;

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
    @Override
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
     * Gets enrolReason
     *
     * @return value of enrolReason
     */
    public String getEnrolReason() {
        return enrolReason;
    }

    /**
     * @param enrolReason
     */
    public void setEnrolReason(String enrolReason) {
        this.enrolReason = enrolReason;
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

    /**
     * Gets enrolOffice
     *
     * @return value of enrolOffice
     */
    public String getEnrolOffice() {
        return enrolOffice;
    }

    /**
     * @param enrolOffice
     */
    public void setEnrolOffice(String enrolOffice) {
        this.enrolOffice = enrolOffice;
    }

    /**
     * Gets removeReason
     *
     * @return value of removeReason
     */
    public String getRemoveReason() {
        return removeReason;
    }

    /**
     * @param removeReason
     */
    public void setRemoveReason(String removeReason) {
        this.removeReason = removeReason;
    }

    /**
     * Gets removeDate
     *
     * @return value of removeDate
     */
    public Date getRemoveDate() {
        return removeDate;
    }

    /**
     * @param removeDate
     */
    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }

    /**
     * Gets removeOffice
     *
     * @return value of removeOffice
     */
    public String getRemoveOffice() {
        return removeOffice;
    }

    /**
     * @param removeOffice
     */
    public void setRemoveOffice(String removeOffice) {
        this.removeOffice = removeOffice;
    }
}

