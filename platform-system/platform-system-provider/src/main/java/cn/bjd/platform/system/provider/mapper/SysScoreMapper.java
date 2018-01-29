package cn.bjd.platform.system.provider.mapper;

import cn.bjd.platform.common.service.dao.CrudDao;
import cn.bjd.platform.system.api.entity.SysScore;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysScoreMapper extends CrudDao<SysScore> {

       SysScore selectScoreByCode(String code);
}
