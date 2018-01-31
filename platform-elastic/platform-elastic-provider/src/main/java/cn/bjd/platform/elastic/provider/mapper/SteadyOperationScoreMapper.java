package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.SteadyOperationScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SteadyOperationScoreMapper {
    int insert(@Param("pojo") SteadyOperationScore pojo);

    int insertSelective(@Param("pojo") SteadyOperationScore pojo);

    int insertList(@Param("pojos") List<SteadyOperationScore> pojo);

    int update(@Param("pojo") SteadyOperationScore pojo);

    SteadyOperationScore findById(@Param("id") String id);

}
