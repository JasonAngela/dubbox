package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.IndustryTjType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IndustryTjTypeMapper {
    int insert(@Param("pojo") IndustryTjType pojo);

    int insertSelective(@Param("pojo") IndustryTjType pojo);

    int insertList(@Param("pojos") List<IndustryTjType> pojo);

    int update(@Param("pojo") IndustryTjType pojo);

    IndustryTjType findIdByName(@Param("name") String name);


}
