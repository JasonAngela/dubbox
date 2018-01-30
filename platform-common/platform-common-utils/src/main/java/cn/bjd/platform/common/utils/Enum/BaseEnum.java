package cn.bjd.platform.common.utils.Enum;

/**
 * 枚举基础接口
 */
public interface BaseEnum {
    /**
     * 获取枚举值对应的描述信息
     * @return
     */
    public String getDesc();

    /**
     * 获取枚举值
     * @return
     */
    public String getValue();

    /**
     * 枚举对外的类型名称，外部可通过类型名称获取到该枚举，一般可以通过this.getClass().getSimpleName()获取名称，如果有名字冲突可指定特殊名称
     * @return
     */
    public String enumTypeName();
}
