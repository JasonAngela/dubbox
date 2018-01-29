package cn.bjd.platform.elastic.api.entity;

import java.util.Date;

/**
 * 企业简易注销公告信息
 */
public class EtpCancellation implements EtpBase {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 公告开始时间
     */
    private Date noticeFrom;

    /**
     * 公告结束时间
     */
    private Date noticeTo;

    /**
     * 是否取消。0：未取消,其他都在取消中或者以取消
     */
    private String isCancel;

    /**
     * 外部企业id
     */
    private String outEtpId;

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
     * Gets noticeFrom
     *
     * @return value of noticeFrom
     */
    public Date getNoticeFrom() {
        return noticeFrom;
    }

    /**
     * @param noticeFrom
     */
    public void setNoticeFrom(Date noticeFrom) {
        this.noticeFrom = noticeFrom;
    }

    /**
     * Gets noticeTo
     *
     * @return value of noticeTo
     */
    public Date getNoticeTo() {
        return noticeTo;
    }

    /**
     * @param noticeTo
     */
    public void setNoticeTo(Date noticeTo) {
        this.noticeTo = noticeTo;
    }

    /**
     * Gets isCancel
     *
     * @return value of isCancel
     */
    public String getIsCancel() {
        return isCancel;
    }

    /**
     * @param isCancel
     */
    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }

    /**
     * Gets outEtpId
     *
     * @return value of outEtpId
     */
    public String getOutEtpId() {
        return outEtpId;
    }

    /**
     * @param outEtpId
     */
    public void setOutEtpId(String outEtpId) {
        this.outEtpId = outEtpId;
    }
}
