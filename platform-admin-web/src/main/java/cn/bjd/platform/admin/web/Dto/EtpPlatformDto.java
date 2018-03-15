package cn.bjd.platform.admin.web.Dto;

import cn.bjd.platform.elastic.api.entity.dto.*;

import java.io.Serializable;

public class EtpPlatformDto implements Serializable {

    private ReadDTO read = new ReadDTO();

    private EtpBasicDTO basic = new EtpBasicDTO();

    private EtpAptitudeDTO aptitude= new EtpAptitudeDTO();

    private RiskDTO risk = new RiskDTO();

    private IndustryDTO industry = new IndustryDTO();

    private AtlasDTO atlas = new AtlasDTO();

    public ReadDTO getRead() {
        return read;
    }

    public void setRead(ReadDTO read) {
        this.read = read;
    }

    public EtpBasicDTO getBasic() {
        return basic;
    }

    public void setBasic(EtpBasicDTO basic) {
        this.basic = basic;
    }

    public EtpAptitudeDTO getAptitude() {
        return aptitude;
    }

    public void setAptitude(EtpAptitudeDTO aptitude) {
        this.aptitude = aptitude;
    }

    public RiskDTO getRisk() {
        return risk;
    }

    public void setRisk(RiskDTO risk) {
        this.risk = risk;
    }

    public IndustryDTO getIndustry() {
        return industry;
    }

    public void setIndustry(IndustryDTO industry) {
        this.industry = industry;
    }

    public AtlasDTO getAtlas() {
        return atlas;
    }

    public void setAtlas(AtlasDTO atlas) {
        this.atlas = atlas;
    }
}