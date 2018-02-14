package cn.bjd.platform.elastic.api.entity;

import java.io.Serializable;

/**
 * 税收违法信息
 */
public class TaxLegel implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 主要违法事实相关法律依据及税务处理处罚情况
     */
    private String illegalFacts;

    /**
     * 案件性质
     */
    private String casesNature;

    /**
     *企业名称（纳税人名称）
     */
    private String companyName;

    /**
     * 负有直接责任的财务负责人姓名、性别、证件名称及号码
     */
    private String direct;

    /**
     * 负有直接责任的中介机构信息及其从业人员信息
     */
    private String gencyInfo;

    /**
     * 证件名称及号码
     */
    private String idCard;

    /**
     * 纳税人识别号
     */
    private String idTax;

    /**
     * 法定代表人或者负责人姓名、性别、证件名称及号码
     */
    private String legalPerson;

    /**
     * 姓名
     */
    private String name;

    /**
     * 组织机构代码
     */
    private String orgCode;

    /**
     * 注册地址
     */
    private String regAddress;

    /**
     * 性别
     */
    private String sex;

    /**
     * 公司/个人
     */
    private String state;

    /**
     * 网址
     */
    private String url;

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
     * Gets illegalFacts
     *
     * @return value of illegalFacts
     */
    public String getIllegalFacts() {
        return illegalFacts;
    }

    /**
     * @param illegalFacts
     */
    public void setIllegalFacts(String illegalFacts) {
        this.illegalFacts = illegalFacts;
    }

    /**
     * Gets casesNature
     *
     * @return value of casesNature
     */
    public String getCasesNature() {
        return casesNature;
    }

    /**
     * @param casesNature
     */
    public void setCasesNature(String casesNature) {
        this.casesNature = casesNature;
    }

    /**
     * Gets companyName
     *
     * @return value of companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets direct
     *
     * @return value of direct
     */
    public String getDirect() {
        return direct;
    }

    /**
     * @param direct
     */
    public void setDirect(String direct) {
        this.direct = direct;
    }

    /**
     * Gets gencyInfo
     *
     * @return value of gencyInfo
     */
    public String getGencyInfo() {
        return gencyInfo;
    }

    /**
     * @param gencyInfo
     */
    public void setGencyInfo(String gencyInfo) {
        this.gencyInfo = gencyInfo;
    }

    /**
     * Gets idCard
     *
     * @return value of idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * Gets idTax
     *
     * @return value of idTax
     */
    public String getIdTax() {
        return idTax;
    }

    /**
     * @param idTax
     */
    public void setIdTax(String idTax) {
        this.idTax = idTax;
    }

    /**
     * Gets legalPerson
     *
     * @return value of legalPerson
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * @param legalPerson
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
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
     * Gets orgCode
     *
     * @return value of orgCode
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * @param orgCode
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * Gets regAddress
     *
     * @return value of regAddress
     */
    public String getRegAddress() {
        return regAddress;
    }

    /**
     * @param regAddress
     */
    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    /**
     * Gets sex
     *
     * @return value of sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets state
     *
     * @return value of state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets url
     *
     * @return value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
