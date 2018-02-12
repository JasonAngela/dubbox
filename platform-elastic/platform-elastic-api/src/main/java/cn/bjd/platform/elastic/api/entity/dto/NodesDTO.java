package cn.bjd.platform.elastic.api.entity.dto;

import java.io.Serializable;

public class NodesDTO implements Serializable {

    private String name = "";

    private Integer category = 0;

    private Integer type = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}