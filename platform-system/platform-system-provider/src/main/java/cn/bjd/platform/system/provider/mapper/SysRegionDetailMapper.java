package cn.bjd.platform.system.provider.mapper;

import cn.bjd.platform.common.service.dao.CrudDao;
import cn.bjd.platform.system.api.entity.SysRegionDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRegionDetailMapper extends CrudDao<SysRegionDetail> {
    SysRegionDetail selectRegionDetailByCode(String code);
}