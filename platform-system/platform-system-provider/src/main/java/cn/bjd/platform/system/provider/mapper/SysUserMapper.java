package cn.bjd.platform.system.provider.mapper;


import cn.bjd.platform.common.service.dao.CrudDao;
import cn.bjd.platform.system.api.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户DAO接口
 *
 * @author huqilang
 */
@Mapper
public interface SysUserMapper extends CrudDao<SysUser> {

    /**
     * 根据登录名称查询用户
     *
     * @param loginName 登录名
     * @return SysUser by login name
     */
    SysUser getByLoginName(String loginName);

    /**
     * 更新用户密码
     *
     * @param user the user
     * @return the int
     */
    int updatePasswordById(SysUser user);

    /**
     * 删除用户角色关联数据
     *
     * @param user the user
     * @return the int
     */
    int deleteUserRole(SysUser user);

    /**
     * 删除用户相关部门
     *
     * @param user the user
     * @return the int
     */
    int deleteUserDept(SysUser user);

    /**
     * 删除用户区域关联数据
     * @param user
     * @return
     */
    int deleteUserRegion(SysUser user);

    /**
     * 插入用户角色关联数据
     *
     * @param user the user
     * @return the int
     */
    int insertUserRole(SysUser user);

    /**
     * 插入用户部门关联数据
     *
     * @param user the user
     * @return the int
     */
    int insertUserDept(SysUser user);


    /**
     * 插入用户区域关联数据
     * @param user
     * @return
     */
    int insertUserRegion(SysUser user);

    /**
     * 保存用户信息
     *
     * @param user the user
     */
    void updateInfo(SysUser user);


    List<SysUser> findUserDeptList(SysUser user);
}
