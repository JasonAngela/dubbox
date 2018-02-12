package cn.bjd.platform.elastic.api.entity.dto;

import java.io.Serializable;

public class LinkDTO implements Serializable {

    private String source = "";

    private String target = "";

    private Integer type = 0;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
