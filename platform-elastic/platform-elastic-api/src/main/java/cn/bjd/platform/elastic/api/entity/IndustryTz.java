package cn.bjd.platform.elastic.api.entity;

import java.io.Serializable;

/**
 * 产业链内部关联特征
 */
public class IndustryTz implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     *
     */
    private String tzCode;

    /**
     *
     */
    private String tz_name;

    /**
     *
     */
    private String cyltzHy;

    /**
     * 节点主题
     */
    private String tzJdzt;

    /**
     * 资金关联特征
     */
    private String tzZjgltz;

    /**
     * 风险关联特征
     */
    private String tzFxgltz;

    /**
     * 议价能力
     */
    private String tzYjnl;

    /**
     * Gets id
     *
     * @return value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets tzCode
     *
     * @return value of tzCode
     */
    public String getTzCode() {
        return tzCode;
    }

    /**
     * @param tzCode
     */
    public void setTzCode(String tzCode) {
        this.tzCode = tzCode;
    }

    /**
     * Gets tz_name
     *
     * @return value of tz_name
     */
    public String getTz_name() {
        return tz_name;
    }

    /**
     * @param tz_name
     */
    public void setTz_name(String tz_name) {
        this.tz_name = tz_name;
    }

    /**
     * Gets cyltzHy
     *
     * @return value of cyltzHy
     */
    public String getCyltzHy() {
        return cyltzHy;
    }

    /**
     * @param cyltzHy
     */
    public void setCyltzHy(String cyltzHy) {
        this.cyltzHy = cyltzHy;
    }

    /**
     * Gets tzJdzt
     *
     * @return value of tzJdzt
     */
    public String getTzJdzt() {
        return tzJdzt;
    }

    /**
     * @param tzJdzt
     */
    public void setTzJdzt(String tzJdzt) {
        this.tzJdzt = tzJdzt;
    }

    /**
     * Gets tzZjgltz
     *
     * @return value of tzZjgltz
     */
    public String getTzZjgltz() {
        return tzZjgltz;
    }

    /**
     * @param tzZjgltz
     */
    public void setTzZjgltz(String tzZjgltz) {
        this.tzZjgltz = tzZjgltz;
    }

    /**
     * Gets tzFxgltz
     *
     * @return value of tzFxgltz
     */
    public String getTzFxgltz() {
        return tzFxgltz;
    }

    /**
     * @param tzFxgltz
     */
    public void setTzFxgltz(String tzFxgltz) {
        this.tzFxgltz = tzFxgltz;
    }

    /**
     * Gets tzYjnl
     *
     * @return value of tzYjnl
     */
    public String getTzYjnl() {
        return tzYjnl;
    }

    /**
     * @param tzYjnl
     */
    public void setTzYjnl(String tzYjnl) {
        this.tzYjnl = tzYjnl;
    }
}
