package cn.bjd.platform.elastic.api.entity;


import java.io.Serializable;

/**
 * 分支机构
 */
public class EtpBranch implements EtpBase,Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 企业id
     */
    private String etpId;

    /**
     * 分支公司
     */
    private String branchCompany;

    /**
     * 分支注册机关
     */
    private String branchRegOffice;

    /**
     * 统一社会信用代码
     */
    private String uniSCId;

    /**
     * 注册号
     */
    private String regNO;

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
     * Gets branchCompany
     *
     * @return value of branchCompany
     */
    public String getBranchCompany() {
        return branchCompany;
    }

    /**
     * @param branchCompany
     */
    public void setBranchCompany(String branchCompany) {
        this.branchCompany = branchCompany;
    }

    /**
     * Gets uniSCId
     *
     * @return value of uniSCId
     */
    public String getUniSCId() {
        return uniSCId;
    }

    /**
     * @param uniSCId
     */
    public void setUniSCId(String uniSCId) {
        this.uniSCId = uniSCId;
    }

    /**
     * Gets branchRegOffice
     *
     * @return value of branchRegOffice
     */
    public String getBranchRegOffice() {
        return branchRegOffice;
    }

    /**
     * @param branchRegOffice
     */
    public void setBranchRegOffice(String branchRegOffice) {
        this.branchRegOffice = branchRegOffice;
    }

    /**
     * Gets regNO
     *
     * @return value of regNO
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * @param regNO
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }
}
