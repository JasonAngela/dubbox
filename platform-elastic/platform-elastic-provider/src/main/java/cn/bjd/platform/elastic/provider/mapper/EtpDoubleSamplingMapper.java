package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpDoubleSampling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpDoubleSamplingMapper {
    int insert(@Param("pojo") EtpDoubleSampling pojo);

    int insertSelective(@Param("pojo") EtpDoubleSampling pojo);

    int insertList(@Param("pojos") List<EtpDoubleSampling> pojo);

    int update(@Param("pojo") EtpDoubleSampling pojo);
}
