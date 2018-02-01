package cn.bjd.platform.elastic.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.bjd.platform.elastic.api.entity.EtpSingleScore;

@Mapper
public interface EtpSingleScoreMapper {
    int insert(@Param("pojo") EtpSingleScore pojo);

    int insertSelective(@Param("pojo") EtpSingleScore pojo);

    int insertList(@Param("pojos") List<EtpSingleScore> pojo);

    int update(@Param("pojo") EtpSingleScore pojo);

    /**
     * 根据id查分数
     * @param id
     * @return EtpSingleScore
     */
    EtpSingleScore findById(@Param("id") String id);
}
