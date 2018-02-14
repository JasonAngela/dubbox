package cn.bjd.platform.elastic.api.entity.dto;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 * Created by admin on 2018/1/26 0026.
 */
public class EtpWhiteDTO implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 公司名称
     */
    private String entName;

    /**
     * category
     */
    private String category;

    /**
     * 大类
     */
    private String bigCategory;

    /**
     * 中类
     */
    private String middleCategroy;

    /**
     * 小类
     */
    private String smallCategory;
    /**
     * lng
     */
    private Double lng;

    /**
     * lat
     */
    private Double lat;

    /**
     * 地址
     */
    private String address;

    /**
     * 法人
     */
    private String legalRep;

    /**
     * 注册时间
     */
    private Date regDate;

    /**
     * 注册资本
     */
    private Double regCapital;


    public EtpWhiteDTO() {
    }
    public EtpWhiteDTO(Map<String,Object> map) throws ParseException {
        this.id = (String) map.get("id");
        this.entName = map.get("entName") == null ? null : (String) map.get("entName");
        this.category = map.get("category") == null ? "" : (String) map.get("category");
        this.bigCategory = map.get("bigCategory") == null ? null : (String) map.get("bigCategory");
        this.middleCategroy = map.get("middleCategory") == null ? null : (String) map.get("middleCategory");
        this.smallCategory = map.get("smallCategory") == null ? null : (String) map.get("smallCategory");
        this.lng = StringUtils.isEmpty((String) map.get("lng")) ? null : Double.parseDouble((String) map.get("lng"));
        this.lat = StringUtils.isEmpty((String) map.get("lng")) ? null : Double.parseDouble((String) map.get("lat"));
        this.address = map.get("address") == null ? null : (String) map.get("address");
        this.legalRep = map.get("legalRep") == null ? null : (String) map.get("legalRep");
        this.regDate = map.get("regDate") == null ? null : DateUtils.parseDate(((String) map.get("regDate")).replace("Z", " UTC"), "yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        this.regCapital = change(map.get("regCapital"));
    }

    public Double change(Object regCapital){
        if(regCapital == null){
            return null;
        }
        if(regCapital instanceof Double){
            return (Double) regCapital;
        }else if(regCapital instanceof Integer){
            return Double.parseDouble(regCapital+"");
        }
        return null;
    }
    /*public EtpWhiteDTO(Map<String,Object> map) throws ParseException {
        this.id = (String)map.get("id");
        this.entName = map.get("entName") == null?null:(String) map.get("entName");
        this.category = map.get("category") == null?"":(String) map.get("category");
        this.bigCategory = map.get("bigCategory") == null?null:(String) map.get("bigCategory");
        this.middleCategroy = map.get("middleCategory") == null?null:(String) map.get("middleCategory");
        this.smallCategory = map.get("smallCategory") == null?null:(String) map.get("smallCategory");
        this.lng = StringUtils.isEmpty((String)map.get("lng"))?null:Double.parseDouble((String)map.get("lng"));
        this.lat = StringUtils.isEmpty((String)map.get("lng"))?null:Double.parseDouble((String)map.get("lat"));
        this.address = map.get("address") == null?null:(String) map.get("address");
        this.legalRep = map.get("legalRep") == null?null:(String) map.get("legalRep");
        this.regDate = map.get("regDate") == null?null: DateUtils.parseDate((String) map.get("regDate"),"yyyy-MM-dd");
        this.regCapital = map.get("regCapital") == null?null:(Double)map.get("regCapital");
    }*/

    /**
     * Gets entName
     *
     * @return value of entName
     */
    public String getEntName() {
        return entName;
    }

    /**
     * @param entName
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * Gets bigCategory
     *
     * @return value of bigCategory
     */
    public String getBigCategory() {
        return bigCategory;
    }

    /**
     * @param bigCategory
     */
    public void setBigCategory(String bigCategory) {
        this.bigCategory = bigCategory;
    }

    /**
     * Gets middleCategroy
     *
     * @return value of middleCategroy
     */
    public String getMiddleCategroy() {
        return middleCategroy;
    }

    /**
     * @param middleCategroy
     */
    public void setMiddleCategroy(String middleCategroy) {
        this.middleCategroy = middleCategroy;
    }

    /**
     * Gets smallCategory
     *
     * @return value of smallCategory
     */
    public String getSmallCategory() {
        return smallCategory;
    }

    /**
     * @param smallCategory
     */
    public void setSmallCategory(String smallCategory) {
        this.smallCategory = smallCategory;
    }

    /**
     * Gets address
     *
     * @return value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets legalRep
     *
     * @return value of legalRep
     */
    public String getLegalRep() {
        return legalRep;
    }

    /**
     * @param legalRep
     */
    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    /**
     * Gets regDate
     *
     * @return value of regDate
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * @param regDate
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /**
     * Gets regCapital
     *
     * @return value of regCapital
     */
    public Double getRegCapital() {
        return regCapital;
    }

    /**
     * @param regCapital
     */
    public void setRegCapital(Double regCapital) {
        this.regCapital = regCapital;
    }

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
     * Gets lng
     *
     * @return value of lng
     */
    public Double getLng() {
        return lng;
    }

    /**
     * @param lng
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * Gets lat
     *
     * @return value of lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * Gets category
     *
     * @return value of category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
