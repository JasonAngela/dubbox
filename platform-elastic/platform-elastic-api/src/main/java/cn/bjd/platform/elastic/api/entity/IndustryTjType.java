package cn.bjd.platform.elastic.api.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/8.
 */
public class IndustryTjType implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 类型名称
     */
    private String name;

    /**
     *
     */
    private char mask;

    /**
     *
     */
    private Integer seq;

    /**
     *
     */
    private Integer isActive;

    /**
     * Gets id
     *
     * @return value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets mask
     *
     * @return value of mask
     */
    public char getMask() {
        return mask;
    }

    /**
     * @param mask
     */
    public void setMask(char mask) {
        this.mask = mask;
    }

    /**
     * Gets seq
     *
     * @return value of seq
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * @param seq
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * Gets isActive
     *
     * @return value of isActive
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * @param isActive
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
