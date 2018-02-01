package cn.bjd.platform.system.provider.mapper;

import cn.bjd.platform.common.service.dao.CrudDao;
import cn.bjd.platform.system.api.entity.SysUserRegion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRegionMapper extends CrudDao<SysUserRegion> {
    SysUserRegion findByUserId(SysUserRegion userRegion);
}
