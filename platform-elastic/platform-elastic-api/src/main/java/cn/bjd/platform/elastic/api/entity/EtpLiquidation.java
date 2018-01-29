package cn.bjd.platform.elastic.api.entity;


/**
 * 清算信息
 */
public class EtpLiquidation implements EtpBase {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 清算组人名
     */
    private String personnel;

    /**
     * 清算组中属于什么身份（1.负责人  0.成员）
     */
    private String position;

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
     * Gets personnel
     *
     * @return value of personnel
     */
    public String getPersonnel() {
        return personnel;
    }

    /**
     * @param personnel
     */
    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    /**
     * Gets position
     *
     * @return value of position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }


}
