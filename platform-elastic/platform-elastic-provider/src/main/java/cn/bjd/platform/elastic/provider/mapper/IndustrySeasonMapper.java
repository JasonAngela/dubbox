package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.IndustrySeason;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IndustrySeasonMapper {
    int insert(@Param("pojo") IndustrySeason pojo);

    int insertSelective(@Param("pojo") IndustrySeason pojo);

    int insertList(@Param("pojos") List<IndustrySeason> pojo);

    int update(@Param("pojo") IndustrySeason pojo);

    /**
     * 通过id查询
     * @param id
     * @return IndustrySeason
     */
    IndustrySeason findById(@Param("id") Integer id);



}
