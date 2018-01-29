package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpCancellation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpCancellationMapper {
    int insert(@Param("pojo") EtpCancellation pojo);

    int insertSelective(@Param("pojo") EtpCancellation pojo);

    int insertList(@Param("pojos") List<EtpCancellation> pojo);

    int update(@Param("pojo") EtpCancellation pojo);
}
