package cn.bjd.platform.system.api.exception;


import cn.bjd.platform.system.api.exception.base.BusinessException;

/**
 * 手机号码不合法
 *
 * @author huqilang
 */
public class IllegalMobileException extends BusinessException {

    public IllegalMobileException(String message) {
        super(message);
    }

}
