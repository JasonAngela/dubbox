package cn.bjd.platform.elastic.api.entity.dto;

import cn.bjd.platform.elastic.api.entity.IndustrySeason;
import cn.bjd.platform.elastic.api.entity.IndustryTj;
import cn.bjd.platform.elastic.api.entity.IndustryTz;

import java.io.Serializable;
import java.util.List;

/**
 * 行业信息
 */
public class IndustryDTO implements Serializable {

    /**
     * 企业id
     */
    private String id;

    /**
     * 应收账款账期
     */
    private Double yszk;

    /**
     * 存货周转时长
     */
    private Double chzz;

    /**
     * 行业平均税负
     */
    private Double addedTax;

    /**
     * 人工成本/营业收入
     */
    private Double rgcb;

    /**
     * 行业季节性波动
     */
    private IndustrySeason industrySeason;

    /**
     * 产业链图片
     */
    private String hyImg;

    /**
     * 产业链内部关联特征
     */
    private List<IndustryTz> industryTzList;

    /**
     * 产业各项经济指标
     */
    private List<IndustryTj> industryTjList;

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets yszk
     *
     * @return value of yszk
     */
    public Double getYszk() {
        return yszk;
    }

    /**
     * @param yszk
     */
    public void setYszk(Double yszk) {
        this.yszk = yszk;
    }

    /**
     * Gets chzz
     *
     * @return value of chzz
     */
    public Double getChzz() {
        return chzz;
    }

    /**
     * @param chzz
     */
    public void setChzz(Double chzz) {
        this.chzz = chzz;
    }

    /**
     * Gets addedTax
     *
     * @return value of addedTax
     */
    public Double getAddedTax() {
        return addedTax;
    }

    /**
     * @param addedTax
     */
    public void setAddedTax(Double addedTax) {
        this.addedTax = addedTax;
    }

    /**
     * Gets rgcb
     *
     * @return value of rgcb
     */
    public Double getRgcb() {
        return rgcb;
    }

    /**
     * @param rgcb
     */
    public void setRgcb(Double rgcb) {
        this.rgcb = rgcb;
    }

    /**
     * Gets industrySeason
     *
     * @return value of industrySeason
     */
    public IndustrySeason getIndustrySeason() {
        return industrySeason;
    }

    /**
     * @param industrySeason
     */
    public void setIndustrySeason(IndustrySeason industrySeason) {
        this.industrySeason = industrySeason;
    }

    /**
     * Gets hyImg
     *
     * @return value of hyImg
     */
    public String getHyImg() {
        return hyImg;
    }

    /**
     * @param hyImg
     */
    public void setHyImg(String hyImg) {
        this.hyImg = hyImg;
    }

    /**
     * Gets industryTzList
     *
     * @return value of industryTzList
     */
    public List<IndustryTz> getIndustryTzList() {
        return industryTzList;
    }

    /**
     * @param industryTzList
     */
    public void setIndustryTzList(List<IndustryTz> industryTzList) {
        this.industryTzList = industryTzList;
    }

    /**
     * Gets industryTjList
     *
     * @return value of industryTjList
     */
    public List<IndustryTj> getIndustryTjList() {
        return industryTjList;
    }

    /**
     * @param industryTjList
     */
    public void setIndustryTjList(List<IndustryTj> industryTjList) {
        this.industryTjList = industryTjList;
    }
}
