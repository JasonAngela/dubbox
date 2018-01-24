package cn.bjd.platform.system.api.entity;


import cn.bjd.platform.common.api.DataEntity;

import java.util.ArrayList;
import java.util.List;

public class SysRegion extends DataEntity {

    private static final long serialVersionUID = 1L;
    /**
     *区域编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;


    private String parent;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 电话区号
     */
    private String areaCode;

    /**
     * 邮编
     */
    private String postCode;
    /**
     * 拼音
     */
    private String pinyin;

    private String lng;

    private String lat;

    private List<SysRegion> children = new ArrayList<>();

    public List<SysRegion> getChildren() {
        return children;
    }

    public void setChildren(List<SysRegion> children) {
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void addChild(SysRegion node){
        this.children.add(node);
    }
}