package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class Risk extends DataEntity {
    private static final long serialVersionUID = 1L;

    private Integer courtCount;

    private Integer illegalCount;

    public Integer getCourtCount() {
        return courtCount;
    }

    public void setCourtCount(Integer courtCount) {
        this.courtCount = courtCount;
    }

    public Integer getIllegalCount() {
        return illegalCount;
    }

    public void setIllegalCount(Integer illegalCount) {
        this.illegalCount = illegalCount;
    }
}
