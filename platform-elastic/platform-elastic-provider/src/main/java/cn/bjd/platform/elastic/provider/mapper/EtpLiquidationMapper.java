package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpLiquidation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpLiquidationMapper {
    int insert(@Param("pojo") EtpLiquidation pojo);

    int insertSelective(@Param("pojo") EtpLiquidation pojo);

    int insertList(@Param("pojos") List<EtpLiquidation> pojo);

    int update(@Param("pojo") EtpLiquidation pojo);
}
