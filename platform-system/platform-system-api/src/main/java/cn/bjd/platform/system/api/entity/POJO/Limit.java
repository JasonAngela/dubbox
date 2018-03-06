package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class Limit extends DataEntity {
    private static final long serialVersionUID = 1L;

    private Integer count;

    private Integer allCount;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }
}