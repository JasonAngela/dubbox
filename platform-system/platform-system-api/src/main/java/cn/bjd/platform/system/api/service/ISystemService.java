package cn.bjd.platform.system.api.service;


import cn.bjd.platform.system.api.entity.*;
import com.github.pagehelper.PageInfo;
import cn.bjd.platform.common.api.Paging;

import java.util.List;
import java.util.Map;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 *
 * @author huqilang
 */
public interface ISystemService {


    /**
     *
     * @param count
     * @return
     */
    List<SysCount> getCount(SysCount count);

    /**
     * 根据类型统计
     * @param list
     * @return
     */
    Integer countForCompany(List<String> list);


    List<SysCount> countGroupByProvinceAndCity(SysCount count);


    /**
     * 企业数量分区域变化
     * @param count
     * @return
     */
    List<SysCount> countGroupByPlace(SysCount count);

    Map<String,List<SysCount>> mapGroupByPlace(SysCount count);

    /**
     * 行业分类统计  TOP10 Customs海关企业评级统计 Tax税务企业评级统计
     * @param count
     * @return
     */
    List<SysCount> countIndustryCustomsTaxTop(SysCount count);


    /**
     * 行业历史数量变化
     * @param count
     * @return
     */
    List<SysCount> industryHistoryByYear(SysCount count);


    /**
     * 涉诉信息统计  违法信息统计
     * @param count
     * @return
     */
    List<SysCount> countDSelect(SysCount count);


    /**
     * 涉诉信息 违法信息历史变化 企业增长消亡曲线
     * @param count
     * @return
     */
    List<SysCount> countCompanyCommon(SysCount count);

    /**
     * 海关税务企业评级历史变化统计
     * @param count
     * @return
     */
    List<SysCount> countCustomsTaxGradeHistory(SysCount count);

    /**
     * 根据登录名获取用户(包含角色等信息)
     *
     * @param loginName 登录名
     * @return SysUser user by login name
     */
    SysUser getUserByLoginName(String loginName);


    SysUser getByLoginName(String loginName);

    /**
     * 查询用户列表
     *
     * @param page 分页信息
     * @param user 用户
     * @return 分页数据 page info
     */
    PageInfo<SysUser> findUserPage(Paging page, SysUser user);

    /**
     * 查询用户
     *
     * @param userId 用户ID
     * @return 用户 user by id
     */
    SysUser getUserById(String userId);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return the sys user
     */
    SysUser saveUser(SysUser user);

    /**
     * 更新用户信息
     *
     * @param user 用户
     */
    void updateUserInfo(SysUser user);

    /**
     * 删除用户
     *
     * @param userId 用户ID
     */
    void deleteUserById(String userId);

    /**
     * 修改密码
     *
     * @param userId      用户ID
     * @param newPassword 密码
     */
    void updateUserPasswordById(String userId, String newPassword);


    /**
     * 查询用户导航菜单
     *
     * @param userId 用户ID
     * @return 菜单列表 menu nav
     */
    List<SysMenu> getMenuNav(String userId);

    /**
     * 查询用户菜单列表
     *
     * @param userId 用户ID
     * @return 菜单列表 menu list
     */
    List<SysMenu> getMenuList(String userId);

    /**
     * 查询用户菜单
     *
     * @param userId 用户ID
     * @return 菜单列表 menu tree
     */
    List<SysMenu> getMenuTree(String userId);

    /**
     * 查询省市区树结构
     * @return
     */
    List<SysRegion> getRegionTree();

    /**
     * 删除菜单
     *
     * @param menuId 菜单ID
     */
    void deleteMenuById(String menuId);

    /**
     * 查询菜单
     *
     * @param menuId 菜单ID
     * @return 菜单 menu by id
     */
    SysMenu getMenuById(String menuId);

    /**
     * 保存菜单
     *
     * @param menu 菜单
     * @return the sys menu
     */
    SysMenu saveMenu(SysMenu menu);

    /**
     * 查询所有的部门信息
     * 暂时部门信息在后台管理中不做权限设置
     * @return
     */
    List<SysDepartment> findAllDepts();


    List<SysDepartment> findAllEnable();
    /**
     * 保存部门信息
     * @param dept
     * @return
     */
    SysDepartment saveDept(SysDepartment dept);

    /**
     * 查询部门
     * @param deptId
     * @return
     */
    SysDepartment getByDeptId(String deptId);

    /**
     * 通过用户查询用户所在部门信息
     * @param userId
     * @return
     */
    List<SysDepartment> getDeptsByUserId(String userId);

    /**
     * 删除部门信息
     * @param deptId
     */
    void deleteDeptById(String deptId);



    /**
     * 查询角色列表
     *
     * @param page 分页信息
     * @param role 角色
     * @return 角色 page info
     */
    PageInfo<SysRole> findRolePage(Paging page, SysRole role);

    /**
     * 获得所有角色列表
     *
     * @return 角色 list
     */
    List<SysRole> findAllRoleList();

    /**
     * 查询用户
     *
     * @param roleId 角色ID
     * @return 角色 role by id
     */
    SysRole getRoleById(String roleId);

    /**
     * 保存角色
     *
     * @param role 角色
     * @return the sys role
     */
    SysRole saveRole(SysRole role);

    /**
     * 删除角色
     *
     * @param roleId 角色ID
     */
    void deleteRoleById(String roleId);


    List<SysRole> findEnabled();


    DataForRegion getDataForRegionByCode(String code);


    List<SysRegion> getRegionAndChild(String regionCode);

    List<SysIndustry> getIndustryTree(String regionCode);

    List<SysIndustry> findIndustry();

    SysRegion getRegionByCode(String code);

    Boolean findUserRegion(String userId,String code);
}