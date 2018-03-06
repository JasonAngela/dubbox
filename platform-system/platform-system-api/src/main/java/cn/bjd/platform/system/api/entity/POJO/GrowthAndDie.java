package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

import java.util.ArrayList;
import java.util.List;

public class GrowthAndDie extends DataEntity {
    private static final long serialVersionUID = 1L;

    private List<BasicModel> growthCurve = new ArrayList<>();

    private List<BasicModel> dieCurve = new ArrayList<>();

    public List<BasicModel> getGrowthCurve() {
        return growthCurve;
    }

    public void setGrowthCurve(List<BasicModel> growthCurve) {
        this.growthCurve = growthCurve;
    }

    public List<BasicModel> getDieCurve() {
        return dieCurve;
    }

    public void setDieCurve(List<BasicModel> dieCurve) {
        this.dieCurve = dieCurve;
    }
}