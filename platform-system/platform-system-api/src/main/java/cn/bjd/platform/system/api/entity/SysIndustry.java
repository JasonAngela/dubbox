package cn.bjd.platform.system.api.entity;

import cn.bjd.platform.common.api.DataEntity;

public class SysIndustry extends DataEntity {
    private static final long serialVersionUID = 1L;

    private String pId;

    private String iLevel;

    private String iName;

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getILevel() {
        return iLevel;
    }

    public void setILevel(String iLevel) {
        this.iLevel = iLevel;
    }

    public String getIName() {
        return iName;
    }

    public void setIName(String iName) {
        this.iName = iName;
    }
}