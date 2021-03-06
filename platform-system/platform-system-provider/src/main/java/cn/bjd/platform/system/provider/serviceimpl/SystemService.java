package cn.bjd.platform.system.provider.serviceimpl;

import cn.bjd.platform.system.api.entity.*;
import cn.bjd.platform.system.api.entity.POJO.*;
import cn.bjd.platform.system.api.exception.base.SystemException;
import cn.bjd.platform.system.provider.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.bjd.platform.common.api.Paging;
import cn.bjd.platform.common.utils.StringHelper;
import cn.bjd.platform.system.api.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 *
 * @author huqilang
 */
@Service
@Transactional(readOnly = true)
public class SystemService implements ISystemService {

    /**
     * 系统用户Mapper
     */
    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 系统角色Mapper
     */
    @Autowired
    private SysRoleMapper sysRoleMapper;
    /**
     * 系统菜单Mapper
     */
    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 部门信息Mapper
     */
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    /**
     * 统计
     */
    @Autowired
    private SysCountMapper sysCountMapper;

    @Autowired
    private SysRegionMapper sysRegionMapper;

    @Autowired
    private SysRegionDetailMapper sysRegionDetailMapper;

    @Autowired
    private SysScoreMapper sysScoreMapper;


    @Autowired
    private SysIndustryMapper sysIndustryMapper;

    @Autowired
    private SysUserRegionMapper sysUserRegionMapper;


    @Override
    public List<SysCount> getCount(SysCount count) {
        return sysCountMapper.getCount(count);
    }

    @Override
    public Integer countForCompany(List<String> list) {
        return sysCountMapper.countForCompany(list);
    }

    @Override
    public List<SysCount> countGroupByProvinceAndCity(SysCount count) {
        List<SysCount> list = null;
        if (StringUtils.isEmpty(count.getProvince()) && StringUtils.isEmpty(count.getCity())) {
            count.setLevel(1);
            list = sysCountMapper.countGroupByProvinceAndCityN(count);
        }
        if (!StringUtils.isEmpty(count.getProvince()) && StringUtils.isEmpty(count.getCity())) {
            count.setLevel(2);
            list = sysCountMapper.countGroupByProvinceAndCityP(count);
        }

        if (!StringUtils.isEmpty(count.getProvince()) && !StringUtils.isEmpty(count.getCity())) {
            count.setLevel(3);
            list = sysCountMapper.countGroupByProvinceAndCityC(count);
        }

        return list;
    }

    @Override
    public List<SysCount> countGroupByPlace(SysCount count) {

        //分省市区
        List<SysCount> list = null;
        if (StringUtils.isEmpty(count.getProvince()) && StringUtils.isEmpty(count.getCity()) && StringUtils.isEmpty(count.getArea())) {
            // 不选择 以省份显示
            count.setLevel(1);
            list = sysCountMapper.countAreaOnlySelectNothing(count);
        }

        if (!StringUtils.isEmpty(count.getProvince()) && StringUtils.isEmpty(count.getCity()) && StringUtils.isEmpty(count.getArea())) {
            count.setLevel(2);
            list = sysCountMapper.countAreaOnlySelectProvince(count);
        }

        if (!StringUtils.isEmpty(count.getProvince()) && !StringUtils.isEmpty(count.getCity()) && StringUtils.isEmpty(count.getArea())) {
            count.setLevel(3);
            list = sysCountMapper.countAreaOnlySelectCity(count);
        }

        if (!StringUtils.isEmpty(count.getProvince()) && !StringUtils.isEmpty(count.getCity()) && !StringUtils.isEmpty(count.getArea())) {
            list = sysCountMapper.countAreaOnlySelectArea(count);
        }

        return list;
    }

    @Override
    public Map<String, List<SysCount>> mapGroupByPlace(SysCount count) {
        Map<String, List<SysCount>> map = new HashMap<>();
        List<SysCount> list = countGroupByPlace(count);

        //找到相同name,年份,数量
        for (SysCount c : list) {
            List<SysCount> value = new ArrayList<>();
            if (map.containsKey(c.getName())) {
                List<SysCount> valueCount = map.get(c.getName());
                valueCount.add(c);
                map.put(c.getName(), valueCount);
            } else {
                value.add(c);
                map.put(c.getName(), value);
            }
        }
        return map;
    }

    @Override
    public List<SysCount> countIndustryCustomsTaxTop(SysCount count) {
        return sysCountMapper.countIndustryCustomsTaxTop(count);
    }


    @Override
    public List<SysCount> industryHistoryByYear(SysCount count) {
        return sysCountMapper.industryHistoryByYear(count);
    }


    @Override
    public List<SysCount> countDSelect(SysCount count) {
        return sysCountMapper.countDSelect(count);
    }


    @Override
    public List<SysCount> countCompanyCommon(SysCount count) {
        return sysCountMapper.countCompanyCommon(count);
    }


    @Override
    public List<SysCount> countCustomsTaxGradeHistory(SysCount count) {
        return sysCountMapper.countCustomsTaxGradeHistory(count);
    }

    //User

    @Override
    public SysUser getUserByLoginName(String loginName) {
        SysUser user = sysUserMapper.getByLoginName(loginName);
        if (user == null) {
            return null;
        }

        String userId = user.getId();
        user.setRoles(sysRoleMapper.findListByUserId(userId));

        List<SysMenu> menuList;
        //超级管理员
        if (SysUser.ADMIN_USER_ID.equals(userId)) {
            menuList = sysMenuMapper.findAllList();
        } else {
            menuList = sysMenuMapper.findListByUserId(userId);
        }

        user.setMenus(menuList);
        return user;
    }

    @Override
    public SysUser getByLoginName(String loginName) {
        return sysUserMapper.getByLoginName(loginName);
    }

    @Override
    public PageInfo<SysUser> findUserPage(Paging page, SysUser user) {
        // 执行分页查询
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SysUser> list = sysUserMapper.findList(user);
        for (SysUser sysUser : list) {
            sysUser.setDepts(sysDepartmentMapper.findListByUserId(sysUser.getId()));
        }
        return new PageInfo<>(list);
    }


    @Override
    public SysUser getUserById(String userId) {
        SysUser user = sysUserMapper.get(userId);
        if (user != null) {
            user.setRoles(sysRoleMapper.findListByUserId(userId));
            user.setDepts(sysDepartmentMapper.findListByUserId(userId));
            user.setRegions(sysRegionMapper.findListByUserId(userId));
        }
        return user;
    }

    @Override
    @Transactional(readOnly = false)
    public SysUser saveUser(SysUser user) {
        if (StringHelper.isBlank(user.getId())) {
            user.preInsert();
            sysUserMapper.insert(user);
        } else {
            // 更新用户数据
            user.preUpdate();
            sysUserMapper.update(user);
            sysUserMapper.deleteUserRole(user);
            sysUserMapper.deleteUserDept(user);
            sysUserMapper.deleteUserRegion(user);
        }

        // 更新用户与角色关联
        if (!CollectionUtils.isEmpty(user.getRoles())) {
            sysUserMapper.insertUserRole(user);
        }

        //更新用户与部门关联
        if (!CollectionUtils.isEmpty(user.getDepts())) {
            sysUserMapper.insertUserDept(user);
        }

        if (!CollectionUtils.isEmpty(user.getRegions())) {
            sysUserMapper.insertUserRegion(user);
        }

        return user;
    }

    @Override
    @Transactional(readOnly = false)
    public void updateUserInfo(SysUser user) {
        // 更新用户数据
        user.preUpdate();
        sysUserMapper.updateInfo(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUserById(String userId) {
        sysUserMapper.deleteById(userId);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateUserPasswordById(String userId, String newPassword) {

        SysUser user = new SysUser(userId);
        user.setPassword(newPassword);
        sysUserMapper.updatePasswordById(user);
    }

    //Menu

    @Override
    public List<SysMenu> getMenuNav(String userId) {
        return makeTree(getMenuListByUserId(userId), true);
    }

    @Override
    public List<SysMenu> getMenuTree(String userId) {
        return makeTree(getMenuListByUserId(userId), true);
    }

    @Override
    public List<SysRegion> getRegionTree() {
        List<SysRegion> originals = sysRegionMapper.findAllList();
        Map<String, SysRegion> dtoMap = new HashMap<>();
        for (SysRegion node : originals) {
            // 原始数据对象为Node，放入dtoMap中。
            String code = node.getCode();
            dtoMap.put(code, node);
        }
        List<SysRegion> result = new ArrayList<>();
        for (Map.Entry<String, SysRegion> entry : dtoMap.entrySet()) {
            SysRegion node = entry.getValue();
            String parent = node.getParent();
            if (dtoMap.get(parent) == null) {
                // 如果是顶层节点，直接添加到结果集合中
                result.add(node);
            } else {
                // 如果不是顶层节点，有父节点，然后添加到父节点的子节点中
                SysRegion parentRegion = dtoMap.get(parent);
                parentRegion.addChild(node);
            }
        }

        return result;
    }


    /**
     * 加载行业树
     *
     * @return
     */
    @Override
    public List<SysIndustry> getIndustryTree(String regionCode, String type) {
        SysRegion region = sysRegionMapper.get(regionCode);
        List<SysIndustry> result = new ArrayList<>();

        if (null != region) {
            SysIndustry industry = new SysIndustry();
            industry.setArea(region.getName());
            industry.setType(type);
            List<SysIndustry> originals = sysIndustryMapper.getIndustryTree(industry);
            Map<String, SysIndustry> dtoMap = new HashMap<>();
            for (SysIndustry node : originals) {
                // 原始数据对象为Node，放入dtoMap中。
                String id = node.getId();
                dtoMap.put(id, node);
            }

            for (Map.Entry<String, SysIndustry> entry : dtoMap.entrySet()) {
                SysIndustry node = entry.getValue();
                String parent = node.getPId();
                if (dtoMap.get(parent) == null) {
                    result.add(node);
                } else {
                    // 如果不是顶层节点，有父节点，然后添加到父节点的子节点中
                    SysIndustry parentRegion = dtoMap.get(parent);
                    parentRegion.addChild(node);
                }
            }
        }
        return result;
    }


    @Override
    public List<SysMenu> getMenuList(String userId) {
        /*List<SysMenu> resultList = new ArrayList<>();
        //按父子顺序排列菜单列表
        sortList(resultList, getMenuListByUserId(userId), "");*/
        //能查看页面 则都能看到

        return makeTree(getMenuListByUserId(userId), false);
    }

    /**
     * 菜单排序
     *
     * @param list       目标菜单列表
     * @param sourceList 原始菜单列表
     * @param parentId   父级编号
     */
    private void sortList(List<SysMenu> list, List<SysMenu> sourceList, String parentId) {
        sourceList.stream()
                .filter(menu -> menu.getParentId() != null && menu.getParentId().equals(parentId))
                .forEach(menu -> {
                    list.add(menu);
                    // 判断是否还有子节点, 有则继续获取子节点
                    sourceList.stream()
                            .filter(child -> child.getParentId() != null && child.getParentId().equals(menu.getId()))
                            .peek(child -> sortList(list, sourceList, menu.getId()))
                            .findFirst();
                });
    }

    /**
     * 获得用户菜单列表，超级管理员可以查看所有菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    private List<SysMenu> getMenuListByUserId(String userId) {
        List<SysMenu> menuList;
        //超级管理员
        if (SysUser.ADMIN_USER_ID.equals(userId)) {
            menuList = sysMenuMapper.findAllList();
        } else {
            menuList = sysMenuMapper.findListByUserId(userId);
        }
        return menuList;
    }

    /**
     * 构建树形结构
     *
     * @param originals 原始数据
     * @param useShow   是否使用开关控制菜单显示隐藏
     * @return 菜单列表
     */
    private List<SysMenu> makeTree(List<SysMenu> originals, boolean useShow) {

        // 构建一个Map,把所有原始数据的ID作为Key,原始数据对象作为VALUE
        Map<String, SysMenu> dtoMap = new HashMap<>();
        for (SysMenu node : originals) {
            // 原始数据对象为Node，放入dtoMap中。
            String id = node.getId();
            if (node.getShow() || !useShow) {
                dtoMap.put(id, node);
            }
        }

        List<SysMenu> result = new ArrayList<>();
        for (Map.Entry<String, SysMenu> entry : dtoMap.entrySet()) {
            SysMenu node = entry.getValue();
            String parentId = node.getParentId();
            if (dtoMap.get(parentId) == null) {
                // 如果是顶层节点，直接添加到结果集合中
                result.add(node);
            } else {
                // 如果不是顶层节点，有父节点，然后添加到父节点的子节点中
                SysMenu parent = dtoMap.get(parentId);
                parent.addChild(node);
                parent.setLeaf(false);
            }
        }

        return result;
    }

    /**
     * @param menuId 菜单ID
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteMenuById(String menuId) {
        SysMenu menu = getMenuById(menuId);
        if (menu == null) {
            throw new SystemException("权限不存在,删除失败!");
        }

        //has son leaf can not delete
        List<SysMenu> list = sysMenuMapper.findByParentId(menuId);
        if (!CollectionUtils.isEmpty(list)) {
            throw new SystemException("存在未删除的子权限，删除失败!");
        }

        sysMenuMapper.deleteById(menuId);
    }

    @Override
    public SysMenu getMenuById(String menuId) {
        return sysMenuMapper.get(menuId);
    }

    @Override
    @Transactional(readOnly = false)
    public SysMenu saveMenu(SysMenu menu) {

        // 获取父节点实体
        SysMenu parentMenu = this.getMenuById(menu.getParentId());

        String parentIds = parentMenu == null ? "" : parentMenu.getParentIds();

        // 获取修改前的parentIds，用于更新子节点的parentIds
        String oldParentIds = menu.getParentIds();

        // 设置新的父节点串
        menu.setParentIds(parentIds + menu.getParentId() + ",");

        // 更新子节点 parentIds
        SysMenu m = new SysMenu();
        m.setParentIds("%," + menu.getId() + ",%");
        List<SysMenu> list = sysMenuMapper.findByParentIdsLike(m);

        // 保存或更新实体
        if (StringHelper.isBlank(menu.getId())) {
            if (parentMenu != null && parentMenu.getShow() == Boolean.FALSE) {
                //父节点存在 并且是禁用的 不能添加权限
                throw new SystemException("禁用权限不能添加子权限");
            }
            menu.preInsert();
            sysMenuMapper.insert(menu);
        } else {
            //修改状态
            //父级禁用 子级不能修改为启用
            if (parentMenu != null && parentMenu.getShow() == Boolean.FALSE && menu.getShow() == Boolean.TRUE) {
                //父节点存在 并且是禁用的 不能添加权限
                throw new SystemException("禁用权限子权限不能修改为启用");
            }

            //禁用操作
            if (menu.getShow() == Boolean.FALSE && !CollectionUtils.isEmpty(list)) {
                for (SysMenu sMenu : list) {
                    if (sMenu.getShow() == Boolean.TRUE) {
                        //子权限存在启用时，父不能禁用。
                        throw new SystemException("存在启用的子权限，不能修改为禁用");
                    }
                }
            }

            menu.preUpdate();
            sysMenuMapper.update(menu);
        }


        for (SysMenu e : list) {
            e.setParentIds(e.getParentIds().replace(oldParentIds, menu.getParentIds()));
            sysMenuMapper.updateParentIds(e);
        }

        return menu;
    }

    //Department

    /**
     * 查询所有部门
     *
     * @return
     */
    @Override
    public List<SysDepartment> findAllDepts() {
        List<SysDepartment> originals = sysDepartmentMapper.findAllList();
        return revoseDept(originals);
    }

    private List<SysDepartment> revoseDept(List<SysDepartment> originals) {
        Map<String, SysDepartment> dtoMap = new HashMap<>();
        for (SysDepartment node : originals) {
            // 原始数据对象为Node，放入dtoMap中。
            String id = node.getId();
            dtoMap.put(id, node);
        }
        List<SysDepartment> result = new ArrayList<>();
        for (Map.Entry<String, SysDepartment> entry : dtoMap.entrySet()) {
            SysDepartment node = entry.getValue();
            String parentId = node.getParentId();
            if (dtoMap.get(parentId) == null) {
                // 如果是顶层节点，直接添加到结果集合中
                result.add(node);
            } else {
                // 如果不是顶层节点，有父节点，然后添加到父节点的子节点中
                SysDepartment parent = dtoMap.get(parentId);
                parent.addChild(node);
            }
        }
        return result;
    }

    @Override
    public List<SysDepartment> findAllEnable() {
        List<SysDepartment> originals = sysDepartmentMapper.findAllEnable();
        return revoseDept(originals);
    }


    /**
     * 添加或者修改子部门
     *
     * @param dept
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public SysDepartment saveDept(SysDepartment dept) {
        SysDepartment parentDept = this.getByDeptId(dept.getParentId());
        String parentIds = parentDept == null ? "" : parentDept.getParentIds();
        String oldParentIds = dept.getParentIds();
        // 设置新的父节点串
        dept.setParentIds(parentIds + dept.getParentId() + ",");
        if (StringUtils.isEmpty(dept.getId())) {
            //禁用部门不能添加子部门！
            if (parentDept != null && parentDept.getEnabled() == Boolean.FALSE) {
                throw new SystemException("禁用部门不能添加子部门");
            }
            dept.preInsert();
            sysDepartmentMapper.insert(dept);
        } else {
            //
            dept.preUpdate();
            sysDepartmentMapper.update(dept);
        }

        SysDepartment d = new SysDepartment();
        d.setParentIds("%," + dept.getId() + ",%");
        List<SysDepartment> list = sysDepartmentMapper.findByParentIdsLike(d);
        for (SysDepartment s : list) {
            s.setParentIds(s.getParentIds().replace(oldParentIds, dept.getParentIds()));
            sysDepartmentMapper.updateParentIds(s);
        }

        return dept;
    }


    @Override
    public SysDepartment getByDeptId(String deptId) {
        return sysDepartmentMapper.get(deptId);
    }


    @Override
    public List<SysDepartment> getDeptsByUserId(String userId) {
        return sysDepartmentMapper.findListByUserId(userId);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteDeptById(String deptId) {
        SysDepartment dept = getByDeptId(deptId);
        if (dept == null) {
            throw new SystemException("部门不存在，删除失败!");
        }
        List<SysDepartment> list = sysDepartmentMapper.findByParentId(deptId);
        if (!CollectionUtils.isEmpty(list)) {
            throw new SystemException("存在未删除的子部门，删除失败!");
        }
        sysDepartmentMapper.deleteById(deptId);
    }


    //Role

    @Override
    public PageInfo<SysRole> findRolePage(Paging page, SysRole role) {
        // 执行分页查询
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SysRole> list = sysRoleMapper.findList(role);
        return new PageInfo<>(list);
    }

    @Override
    public List<SysRole> findAllRoleList() {
        return sysRoleMapper.findAllList();
    }

    @Override
    public SysRole getRoleById(String roleId) {

        SysRole role = sysRoleMapper.get(roleId);
        if (role != null) {
            role.setMenus(sysMenuMapper.findListByRoleId(roleId));
        }

        return role;
    }


    @Override
    @Transactional(readOnly = false)
    public SysRole saveRole(SysRole role) {
        if (StringHelper.isBlank(role.getId())) {
            role.preInsert();
            sysRoleMapper.insert(role);
        } else {
            // 更新角色数据
            role.preUpdate();
            sysRoleMapper.update(role);
            sysRoleMapper.deleteRoleMenu(role);
        }

        // 更新角色与菜单关联
        if (role.getMenus() != null && !role.getMenus().isEmpty()) {
            sysRoleMapper.insertRoleMenu(role);
        }

        return role;
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteRoleById(String roleId) {
        sysRoleMapper.deleteById(roleId);
    }

    @Override
    public List<SysRole> findEnabled() {
        return sysRoleMapper.findEnabled();
    }

    @Override
    public DataForRegion getDataForRegionByCode(String code) {
        DataForRegion dataForRegion = new DataForRegion();
        SysRegionDetail regionDetail = sysRegionDetailMapper.selectRegionDetailByCode(code);
        SysScore sysScore = sysScoreMapper.selectScoreByCode(code);
        SysRegion region = sysRegionMapper.get(code);
        if (null == region) {
            //区域找不到 其余的白搭
            return null;
        }
        String name = region.getName();
        SysCount pCount = new SysCount();
        //分别放省市区即可
        if (code.substring(code.length() - 4).equals("0000")) {
            //选择的是省
            pCount.setProvince(name);
            pCount.setLevel(1);
        } else if (code.substring(code.length() - 2).equals("00")) {
            pCount.setCity(name);
            pCount.setLevel(2);
        } else {
            pCount.setArea(name);
            pCount.setLevel(3);
        }

        if (regionDetail != null) {
            RegionDto dto = new RegionDto();

            Development development = new Development();
            development.setgDPtotal(regionDetail.getGdpTotal());
            development.setgDPAvg(regionDetail.getGdpAvg());
            development.setTaxTotal(regionDetail.getTaxTotal());
            development.setAvgLoanDeviation(regionDetail.getAvgLoanDeviation());
            development.setExpenditure(regionDetail.getExpenditure());

            Stable stable = new Stable();
            stable.setGdpGrowthRate(regionDetail.getGdpGrowthRate());
            stable.setExpenditureGrowthRate(regionDetail.getExpenditureGrowthRate());
            stable.setCompanyGrowthCount(regionDetail.getCompanyGrowthCount());

            FinancialSupply financialSupply = new FinancialSupply();
            financialSupply.setAvgLoanDeviation(regionDetail.getAvgLoanDeviation());
            financialSupply.setPeopleActivity(regionDetail.getPeopleActivity());
            financialSupply.setGdpLoanRate(regionDetail.getGdpLoanRate());


            RiskCulture riskCulture = new RiskCulture();
            riskCulture.setAvgCompanyLoan(regionDetail.getAvgCompanyLoan());
            riskCulture.setLoanRatio(regionDetail.getLoanRatio());
            riskCulture.setCrimeIndex(regionDetail.getCrimeIndex());

            if (sysScore != null) {
                development.setScore(sysScore.getDevScore());
                stable.setScore(sysScore.getStableScore());
                financialSupply.setScore(sysScore.getFinScore());
                riskCulture.setScore(sysScore.getRiskScore());
                Double d = sysScore.getScore() * 1.2;
                BigDecimal df = new BigDecimal(String.valueOf(d));
                dto.setScore(df.floatValue());
            }

            dto.setDevelopment(development);
            dto.setStable(stable);
            dto.setFinancialSupply(financialSupply);
            dto.setRiskCulture(riskCulture);
            dataForRegion.setRegion(dto);
        }
        //cityName by Code

        Risk risk = new Risk();
        List<SysCount> countList = sysCountMapper.countDQueryV2(pCount);
        if (!CollectionUtils.isEmpty(countList)) {
            Integer totalValue = 0;
            for (SysCount count : countList) {
                totalValue += Integer.parseInt(StringUtils.isEmpty(count.getValue()) ? "0" : count.getValue());
            }
            risk.setCourtCount(totalValue);
        }

        List<SysCount> countDList = sysCountMapper.countDTypeQueryV2(pCount);
        if (!CollectionUtils.isEmpty(countList)) {
            Integer totalTypeValue = 0;
            for (SysCount count : countDList) {
                totalTypeValue += Integer.parseInt(StringUtils.isEmpty(count.getValue()) ? "0" : count.getValue());
            }
            risk.setIllegalCount(totalTypeValue);
        }

        List<SysCount> top5List = sysCountMapper.countIndustryTop5(pCount);
        if (!CollectionUtils.isEmpty(top5List)) {
            List<Industry> topIndustry = new ArrayList<>();
            for (SysCount count : top5List) {
                Industry industry = new Industry();
                industry.setCategory(count.getType());
                industry.setCount(count.getValue());
                topIndustry.add(industry);
            }
            dataForRegion.setTopIndustry(topIndustry);
        }
        dataForRegion.setRisk(risk);

        //区域企业总数
        SysCount totalCompany = sysCountMapper.countSumCompany(pCount);
        if (totalCompany != null) {
            dataForRegion.setCount(totalCompany.getValue());
        }


        return dataForRegion;
    }

    @Override
    public List<SysRegion> getRegionAndChild(String regionCode) {
        SysRegion region = sysRegionMapper.get(regionCode);
        List<SysRegion> list = new ArrayList<>();
        if (region != null) {
            //查询子区域
            String code = region.getCode();
            Integer level = region.getLevel() + 1;//下一层
            SysRegion selRegion = new SysRegion();
            selRegion.setParent(code);
            selRegion.setLevel(level);
            list = sysRegionMapper.findRegionByParent(selRegion);
        }

        return list;
    }

    @Override
    public List<SysIndustry> findIndustry() {
        return sysIndustryMapper.findIndustry();
    }

    @Override
    public SysIndustry getIndustry(String id) {
        return sysIndustryMapper.get(id);
    }

    @Override
    public SysRegion getRegionByCode(String code) {
        return sysRegionMapper.get(code);
    }

    @Override
    public Boolean findUserRegion(String userId, String code) {
        SysUserRegion userRegion = new SysUserRegion();
        userRegion.setUserId(userId);
        userRegion.setCode(code);
        SysUserRegion userRegionDto = sysUserRegionMapper.findByUserId(userRegion);
        if (userRegionDto != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<SysUser> findUserDeptList(SysUser user) {
        return sysUserMapper.findUserDeptList(user);
    }

    @Override
    public Integer industryCount(SysIndustry industry) {
        return sysIndustryMapper.industryCount(industry);
    }
}