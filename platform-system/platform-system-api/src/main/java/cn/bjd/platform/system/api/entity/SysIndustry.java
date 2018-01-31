package cn.bjd.platform.system.api.entity;

import cn.bjd.platform.common.api.DataEntity;

import java.util.ArrayList;
import java.util.List;

public class SysIndustry extends DataEntity {
    private static final long serialVersionUID = 1L;

    private String pId;

    private String parentId;

    private Integer iLevel;

    private String iName;

    private String name;

    private Integer count = 0;

    private Integer level;

    private String category;

    private String area;

    private List<SysIndustry> children = new ArrayList<>();

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

    public String getParentId() {
        return getPId();
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<SysIndustry> getChildren() {
        return children;
    }

    public void setChildren(List<SysIndustry> children) {
        this.children = children;
    }

    public String getName() {
        return getIName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLevel() {
        return getILevel();
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public Integer getILevel() {
        return iLevel;
    }

    public void setILevel(Integer iLevel) {
        this.iLevel = iLevel;
    }

    public String getIName() {
        return iName;
    }

    public void setIName(String iName) {
        this.iName = iName;
    }

    public void addChild(SysIndustry node){
        this.children.add(node);
    }
}