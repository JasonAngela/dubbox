package cn.bjd.platform.elastic.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 行政许可证信息
 */
public class EtpLicence implements EtpBase,Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 许可文件编号
     */
    private String permissionNumber;

    /**
     * 许可文件名称
     */
    private String permissionName;

    /**
     * 许可机关
     */
    private String permissionOffice;

    /**
     * 许可内容
     */
    private String permissionContent;

    /**
     * 开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;

    /**
     * 结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date finishDate;

    /**
     * 公式日期
     */
    private Date publicDate;

    /**
     * 类型
     */
    private String type;

    /**
     * 外部id
     */
    private String outId;

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
     * Gets permissionNumber
     *
     * @return value of permissionNumber
     */
    public String getPermissionNumber() {
        return permissionNumber;
    }

    /**
     * @param permissionNumber
     */
    public void setPermissionNumber(String permissionNumber) {
        this.permissionNumber = permissionNumber;
    }

    /**
     * Gets permissionName
     *
     * @return value of permissionName
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * @param permissionName
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * Gets permissionOffice
     *
     * @return value of permissionOffice
     */
    public String getPermissionOffice() {
        return permissionOffice;
    }

    /**
     * @param permissionOffice
     */
    public void setPermissionOffice(String permissionOffice) {
        this.permissionOffice = permissionOffice;
    }

    /**
     * Gets permissionContent
     *
     * @return value of permissionContent
     */
    public String getPermissionContent() {
        return permissionContent;
    }

    /**
     * @param permissionContent
     */
    public void setPermissionContent(String permissionContent) {
        this.permissionContent = permissionContent;
    }

    /**
     * Gets startDate
     *
     * @return value of startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets finishDate
     *
     * @return value of finishDate
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * @param finishDate
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * Gets publicDate
     *
     * @return value of publicDate
     */
    public Date getPublicDate() {
        return publicDate;
    }

    /**
     * @param publicDate
     */
    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
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
}
