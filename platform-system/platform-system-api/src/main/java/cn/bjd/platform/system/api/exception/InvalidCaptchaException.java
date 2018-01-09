package cn.bjd.platform.system.api.exception;


import cn.bjd.platform.system.api.exception.base.BusinessException;

/**
 * 无效验证码
 *
 * @author huqilang
 */
public class InvalidCaptchaException extends BusinessException {

    public InvalidCaptchaException(String message) {
        super(message);
    }

}
