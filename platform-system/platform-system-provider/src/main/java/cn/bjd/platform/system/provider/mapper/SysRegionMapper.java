package cn.bjd.platform.system.provider.mapper;

import cn.bjd.platform.common.service.dao.CrudDao;
import cn.bjd.platform.system.api.entity.SysRegion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRegionMapper extends CrudDao<SysRegion> {

    List<SysRegion> findAllList();

    List<SysRegion> findByParent(String parent);

    SysRegion get(String code);
}
