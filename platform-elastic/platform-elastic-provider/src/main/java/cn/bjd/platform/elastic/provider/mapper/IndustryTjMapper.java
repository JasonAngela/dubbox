package cn.bjd.platform.elastic.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.bjd.platform.elastic.api.entity.IndustryTj;

@Mapper
public interface IndustryTjMapper {
    int insert(@Param("pojo") IndustryTj pojo);

    int insertSelective(@Param("pojo") IndustryTj pojo);

    int insertList(@Param("pojos") List<IndustryTj> pojo);

    int update(@Param("pojo") IndustryTj pojo);

    /**
     * 通过typeXxl查询
     * @param typeXxl
     * @return List
     */
    List<IndustryTj> findByTypeXxl(@Param("typeXxl") String typeXxl);

    IndustryTj findById(@Param("id") Integer id);

    IndustryTj findModel(@Param("tjType") Integer tjType, @Param("industryId") Integer industryId);




}
