package cn.bjd.platform.elastic.api.entity.dto;

/**
 * Created by admin on 2018/1/25 0025.
 */



import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 * 工商es搜索企业表
 */
public class EtpEsDTO implements Serializable {
    /**
     * 企业id
     */
    private String id;

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 行业门类
     */
    private String category;


    /**
     * 成立日期
     */
    private Date regDate;

    /**
     * 注册资本（万 人民币）
     */
    private Double regCapital;

    /**
     * 经度
     */
    private Double lng;

    /**
     * 纬度
     */
    private Double lat;

    public EtpEsDTO() {
    }

    public EtpEsDTO(Map<String,Object> map) throws ParseException {
        this.setId(map.get("id") == null?null:(String) map.get("id"));
        this.setEntName(map.get("entName") == null?null:(String) map.get("entName"));
        this.setRegCapital(map.get("regCapital") == null?null:(Double) map.get("regCapital"));
        this.setRegDate(map.get("regDate") == null?null:DateUtils.parseDate((String)map.get("regDate"),"yyyy-MM-dd"));
        this.setLng(map.get("lng") == null?null:Double.parseDouble((String) map.get("lng")));
        this.setLat(map.get("lat") == null?null:Double.parseDouble((String) map.get("lat")));
        this.setCategory(map.get("category") == null?null:(String) map.get("category"));
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
}
