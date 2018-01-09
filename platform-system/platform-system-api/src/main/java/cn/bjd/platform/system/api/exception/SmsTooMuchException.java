package cn.bjd.platform.system.api.exception;


import cn.bjd.platform.system.api.exception.base.BusinessException;

/**
 * 短信发送太频繁
 *
 * @author huqilang
 */
public class SmsTooMuchException extends BusinessException {

    public SmsTooMuchException(String message) {
        super(message);
    }

}
