package cn.bjd.platform.system.api.exception;


import cn.bjd.platform.system.api.exception.base.BusinessException;

/**
 * 用户未存在
 *
 * @author huqilang
 */
public class UserNotExistException extends BusinessException {

    public UserNotExistException(String message) {
        super(message);
    }

}
