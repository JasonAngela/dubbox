package cn.bjd.platform.system.api.Enum;

import cn.bjd.platform.common.utils.Enum.BaseEnum;

public enum IndustryEnum implements BaseEnum {

    Manufacture("制造业","a"),
    Wholesale("批发和零售业","b"),
    Leasing("租赁和商务服务业","c"),
    Agriculture("农、林、牧、渔业","d"),
    Scientific("科学研究和技术服务业","e"),
    Estate("房地产业","f"),
    Construction("建筑业","g"),
    Information("信息传输、软件和信息技术服务业","h"),
    Transportation("交通运输、仓储和邮政业","i"),
    Finance("金融业","j"),
    Entertainment("文化、体育和娱乐业","k"),
    Residents("居民服务、修理和其他服务业","l"),
    Mining("采矿业","m"),
    Power("电力、热力、燃气及水生产和供应业","n"),
    Accommodation("住宿和餐饮业","o"),
    Education("教育","p"),
    Water("水利、环境和公共设施管理业","q"),
    SocialOrganization("公共管理、社会保障和社会组织","r"),
    Health("卫生和社会工作","s"),
    International("国际组织","t")
    ;

    private String desc;
    private String value;

    private IndustryEnum(String desc, String value)
    {
        this.desc = desc;
        this.value = value;
    }

    @Override
    public String getDesc()
    {
        return this.desc;
    }

    @Override
    public String getValue()
    {
        return this.value;
    }

    @Override
    public String enumTypeName()
    {
        return this.getClass().getSimpleName();
    }
}