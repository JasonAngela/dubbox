package cn.bjd.platform.elastic.api.entity.dto;

import java.io.Serializable;

public class AtlasDTO implements Serializable {

    private FamilyDTO family = new FamilyDTO();

    private RelateDTO relate = new RelateDTO();

    public FamilyDTO getFamily() {
        return family;
    }

    public void setFamily(FamilyDTO family) {
        this.family = family;
    }

    public RelateDTO getRelate() {
        return relate;
    }

    public void setRelate(RelateDTO relate) {
        this.relate = relate;
    }
}