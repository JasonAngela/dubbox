package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 行业
 */
public class Industry extends DataEntity {
    private static final long serialVersionUID = 1L;

    private String category;

    private String count;

    private List<Industry> topIndustry = new ArrayList<>();

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<Industry> getTopIndustry() {
        return topIndustry;
    }

    public void setTopIndustry(List<Industry> topIndustry) {
        this.topIndustry = topIndustry;
    }
}
