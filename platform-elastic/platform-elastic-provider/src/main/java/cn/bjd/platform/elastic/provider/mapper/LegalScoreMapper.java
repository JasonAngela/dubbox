package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.common.service.dao.CrudDao;
import cn.bjd.platform.elastic.api.entity.LegalScore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LegalScoreMapper extends CrudDao<LegalScore> {
    LegalScore findByEntName(String entName);
}
