package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class BasicModel extends DataEntity {
    private static final long serialVersionUID = 1L;

    private Integer year;

    private String value;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}