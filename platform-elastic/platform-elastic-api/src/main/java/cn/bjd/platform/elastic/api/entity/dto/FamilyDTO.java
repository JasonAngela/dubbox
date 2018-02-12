package cn.bjd.platform.elastic.api.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyDTO implements Serializable {

    private Integer type = 0;

    private String name;

    private List<FamilyDTO> children = new ArrayList<>();

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FamilyDTO> getChildren() {
        return children;
    }

    public void setChildren(List<FamilyDTO> children) {
        this.children = children;
    }

    public void addChild(FamilyDTO dto){
        this.children.add(dto);
    }


}