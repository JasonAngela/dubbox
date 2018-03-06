package cn.bjd.platform.system.provider.mapper;

import cn.bjd.platform.common.service.dao.CrudDao;
import cn.bjd.platform.system.api.entity.SysIndustry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysIndustryMapper  extends CrudDao<SysIndustry> {
    List<SysIndustry> getIndustryTree(SysIndustry industry);

    List<SysIndustry> findIndustry();

    Integer industryCount(SysIndustry industry);
}
