package cn.bjd.platform.elastic.api.entity;

import java.util.Date;

/**
 * 抽查检查结果信息
 */
public class EtpSampling implements EtpBase {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 检查机关
     */
    private String inspectOffice;

    /**
     * 类型
     */
    private String type;

    /**
     * 抽查类型。1：即时性抽查
     */
    private String insType;


    /**
     * 日期
     */
    private Date date;

    /**
     * 结果
     */
    private String result;

    /**
     * 外部id
     */
    private String outId;

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
     * Gets inspectOffice
     *
     * @return value of inspectOffice
     */
    public String getInspectOffice() {
        return inspectOffice;
    }

    /**
     * @param inspectOffice
     */
    public void setInspectOffice(String inspectOffice) {
        this.inspectOffice = inspectOffice;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets insType
     *
     * @return value of insType
     */
    public String getInsType() {
        return insType;
    }

    /**
     * @param insType
     */
    public void setInsType(String insType) {
        this.insType = insType;
    }

    /**
     * Gets date
     *
     * @return value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets result
     *
     * @return value of result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Gets outId
     *
     * @return value of outId
     */
    public String getOutId() {
        return outId;
    }

    /**
     * @param outId
     */
    public void setOutId(String outId) {
        this.outId = outId;
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
