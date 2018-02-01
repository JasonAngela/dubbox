package cn.bjd.platform.system.api.entity;

import cn.bjd.platform.common.api.DataEntity;

public class SysUserRegion extends DataEntity {
    private String userId;
    private String code;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
