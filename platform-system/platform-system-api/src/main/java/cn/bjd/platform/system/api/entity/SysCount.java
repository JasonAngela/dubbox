package cn.bjd.platform.system.api.entity;

import cn.bjd.platform.common.api.DataEntity;

public class SysCount extends DataEntity {
    private static final long serialVersionUID = 1L;

    private String province;

    private String city;

    private String area;

    private String category;

    private Integer sum;

    private Integer level;

    private Integer year;

    private String type;

    private String top;

    private Integer totalSum;

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}