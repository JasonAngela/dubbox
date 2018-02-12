package cn.bjd.platform.elastic.api.entity.dto;

import cn.bjd.platform.elastic.api.entity.EtpBrand;
import cn.bjd.platform.elastic.api.entity.EtpLicence;

import java.io.Serializable;
import java.util.List;

/**
 * 资质能力
 */
public class EtpAptitudeDTO implements Serializable {

    /**
     * 企业id
     */
    private String id;

    /**
     * 商标
     */
    private List<EtpBrand> etpBrandList;

    /**
     * 行政许可证信息
     */
    private List<EtpLicence> etpLicenceList;

    /**
     * 税务评级
     */
    private String taxRate;

    /**
     * 海关评级
     */
    private String customRate;

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
     * Gets etpBrandList
     *
     * @return value of etpBrandList
     */
    public List<EtpBrand> getEtpBrandList() {
        return etpBrandList;
    }

    /**
     * @param etpBrandList
     */
    public void setEtpBrandList(List<EtpBrand> etpBrandList) {
        this.etpBrandList = etpBrandList;
    }

    /**
     * Gets etpLicenceList
     *
     * @return value of etpLicenceList
     */
    public List<EtpLicence> getEtpLicenceList() {
        return etpLicenceList;
    }

    /**
     * @param etpLicenceList
     */
    public void setEtpLicenceList(List<EtpLicence> etpLicenceList) {
        this.etpLicenceList = etpLicenceList;
    }

    /**
     * Gets taxRate
     *
     * @return value of taxRate
     */
    public String getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate
     */
    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Gets customRate
     *
     * @return value of customRate
     */
    public String getCustomRate() {
        return customRate;
    }

    /**
     * @param customRate
     */
    public void setCustomRate(String customRate) {
        this.customRate = customRate;
    }
}
