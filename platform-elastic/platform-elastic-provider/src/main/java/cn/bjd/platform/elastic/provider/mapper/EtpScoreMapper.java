package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.common.service.dao.CrudDao;
import cn.bjd.platform.elastic.api.entity.EtpScore;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EtpScoreMapper extends CrudDao<EtpScore> {
    EtpScore findByEntName(String entName);
}
