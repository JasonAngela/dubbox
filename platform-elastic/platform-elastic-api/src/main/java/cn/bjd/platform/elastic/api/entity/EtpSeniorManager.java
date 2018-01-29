package cn.bjd.platform.elastic.api.entity;

/**
 * 企业高管:主要人员信息
 */
public class EtpSeniorManager implements EtpBase {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 名字
     */
    private String name;

    /**
     * 职位
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
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
