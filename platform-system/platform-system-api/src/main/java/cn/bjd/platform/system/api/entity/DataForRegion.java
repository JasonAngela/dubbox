package cn.bjd.platform.system.api.entity;

import cn.bjd.platform.common.api.DataEntity;
import cn.bjd.platform.system.api.entity.POJO.*;

import java.util.ArrayList;
import java.util.List;

public class DataForRegion extends DataEntity {
    private static final long serialVersionUID = 1L;

    private RegionDto region = new RegionDto();

    private Risk risk = new Risk();

    private Register register = new Register();

    private GrowthAndDie growthAndDie = new GrowthAndDie();

    private Illegal illegal = new Illegal();

    private List<Industry> topIndustry = new ArrayList<>();

    private String count = "0";

    private String area = "";

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Illegal getIllegal() {
        return illegal;
    }

    public void setIllegal(Illegal illegal) {
        this.illegal = illegal;
    }

    public GrowthAndDie getGrowthAndDie() {
        return growthAndDie;
    }

    public void setGrowthAndDie(GrowthAndDie growthAndDie) {
        this.growthAndDie = growthAndDie;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

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