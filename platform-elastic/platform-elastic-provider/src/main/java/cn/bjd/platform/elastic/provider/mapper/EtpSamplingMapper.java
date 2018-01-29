package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpSampling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface EtpSamplingMapper {
    int insert(@Param("pojo") EtpSampling pojo);

    int insertSelective(@Param("pojo") EtpSampling pojo);

    int insertList(@Param("pojos") List<EtpSampling> pojo);

    int update(@Param("pojo") EtpSampling pojo);
}
