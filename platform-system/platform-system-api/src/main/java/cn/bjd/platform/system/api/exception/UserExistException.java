package cn.bjd.platform.system.api.exception;


import cn.bjd.platform.system.api.exception.base.BusinessException;

/**
 * 用户已存在
 *
 * @author huqilang
 */
public class UserExistException extends BusinessException {

    public UserExistException(String message) {
        super(message);
    }

}
