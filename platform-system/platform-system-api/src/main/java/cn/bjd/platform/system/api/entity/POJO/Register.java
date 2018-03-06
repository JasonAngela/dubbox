package cn.bjd.platform.system.api.entity.POJO;

import cn.bjd.platform.common.api.DataEntity;

public class Register extends DataEntity {
    private static final long serialVersionUID = 1L;

    private RegisterCapital registerCapital = new RegisterCapital();


    private RegisterTime registerTime = new RegisterTime();

    public RegisterCapital getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(RegisterCapital registerCapital) {
        this.registerCapital = registerCapital;
    }

    public RegisterTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(RegisterTime registerTime) {
        this.registerTime = registerTime;
    }
}