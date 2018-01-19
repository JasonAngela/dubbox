package cn.bjd.platform.system.provider.mapper;

import cn.bjd.platform.common.service.dao.CrudDao;
import cn.bjd.platform.system.api.entity.SysDepartment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门DAO接口
 *
 * @author Jason
 */
@Mapper
public interface SysDepartmentMapper extends CrudDao<SysDepartment> {

    /**
     * 根据用户查询
     * @param userId the user id
     * @return the list
     */
    List<SysDepartment> findListByUserId(String userId);

    /**
     * 更新父ID
     *
     * @param dept the Department
     * @return the int
     */
    int updateParentIds(SysDepartment dept);

    /**
     *
     * @param dept
     * @return
     */
    List<SysDepartment> findByParentIdsLike(SysDepartment dept);

    List<SysDepartment> findByParentId(String parentId);

    List<SysDepartment> findAllEnable();
}
