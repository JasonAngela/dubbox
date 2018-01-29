package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpBrandMapper {
    int insert(@Param("pojo") EtpBrand pojo);

    int insertSelective(@Param("pojo") EtpBrand pojo);

    int insertList(@Param("pojos") List<EtpBrand> pojo);

    int update(@Param("pojo") EtpBrand pojo);
}
