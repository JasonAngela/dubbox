package cn.bjd.platform.elastic.api.entity.dto;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
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
     * lng
     */
    private Double lng;

    /**
     * lat
     */
    private Double lat;

    /**
     * category
     */
    private String category = "";

    public EtpWhiteDTO() {
    }

    public EtpWhiteDTO(Map<String,Object> map) {
        this.id = (String)map.get("id");
        this.lng = StringUtils.isEmpty((String)map.get("lng"))?null:Double.parseDouble((String)map.get("lng"));
        this.lat = StringUtils.isEmpty((String)map.get("lng"))?null:Double.parseDouble((String)map.get("lat"));
        this.category = (String)map.get("category");
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
