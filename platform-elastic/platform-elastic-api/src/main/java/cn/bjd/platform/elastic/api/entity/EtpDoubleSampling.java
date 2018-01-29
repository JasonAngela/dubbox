package cn.bjd.platform.elastic.api.entity;

import java.util.Date;

/**
 * 双随机抽查结果信息
 */
public class EtpDoubleSampling implements EtpBase {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 抽查计划编号
     */
    private String checkNo;

    /**
     * 抽查计划名称
     */
    private String planName;

    /**
     * 抽查任务编号
     */
    private String taskNo;

    /**
     * 抽查任务名称
     */
    private String taskName;

    /**
     * 抽查类型
     */
    private String type;

    /**
     * 检查机关
     */
    private String checkOffice;

    /**
     * 检查完成日期
     */
    private Date finishDate;

    /**
     * 检查结果
     */
    private String result;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 对应json字段的 INSENTERID
     */
    private String insenterid;

    /**
     * 统一社会信用代码
     */
    private String uniscid;

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
     * Gets checkNo
     *
     * @return value of checkNo
     */
    public String getCheckNo() {
        return checkNo;
    }

    /**
     * @param checkNo
     */
    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    /**
     * Gets planName
     *
     * @return value of planName
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * @param planName
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * Gets taskNo
     *
     * @return value of taskNo
     */
    public String getTaskNo() {
        return taskNo;
    }

    /**
     * @param taskNo
     */
    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * Gets taskName
     *
     * @return value of taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
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
     * Gets checkOffice
     *
     * @return value of checkOffice
     */
    public String getCheckOffice() {
        return checkOffice;
    }

    /**
     * @param checkOffice
     */
    public void setCheckOffice(String checkOffice) {
        this.checkOffice = checkOffice;
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
     * Gets remarks
     *
     * @return value of remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Gets insenterid
     *
     * @return value of insenterid
     */
    public String getInsenterid() {
        return insenterid;
    }

    /**
     * @param insenterid
     */
    public void setInsenterid(String insenterid) {
        this.insenterid = insenterid;
    }

    /**
     * Gets uniscid
     *
     * @return value of uniscid
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * @param uniscid
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }
}
