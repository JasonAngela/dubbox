package cn.bjd.platform.elastic.api.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RelateDTO implements Serializable {

    private List<LinkDTO> link = new ArrayList<>();

    private List<NodesDTO> nodes = new ArrayList<>();

    public List<LinkDTO> getLink() {
        return link;
    }

    public void setLink(List<LinkDTO> link) {
        this.link = link;
    }

    public List<NodesDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodesDTO> nodes) {
        this.nodes = nodes;
    }
}