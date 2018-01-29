package cn.bjd.platform.system.api.entity;

import cn.bjd.platform.common.api.DataEntity;
import cn.bjd.platform.system.api.entity.POJO.Industry;
import cn.bjd.platform.system.api.entity.POJO.RegionDto;
import cn.bjd.platform.system.api.entity.POJO.Risk;

import java.util.List;

public class DataForRegion extends DataEntity {
    private static final long serialVersionUID = 1L;

    private RegionDto region;

    private Risk risk;

    private List<Industry> topIndustry;

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    public List<Industry> getTopIndustry() {
        return topIndustry;
    }

    public void setTopIndustry(List<Industry> topIndustry) {
        this.topIndustry = topIndustry;
    }
}