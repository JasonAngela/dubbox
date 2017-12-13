package cn.zhangxd.platform.system.api.service;

import cn.zhangxd.platform.system.api.entity.SysUser;

/**
 * Jason
 */
public interface ISystemServiceOut {
    /**
     * 查询用户
     *
     * @param userId 用户ID
     * @return 用户 user by id
     */
    SysUser getUserById(String userId);
}
