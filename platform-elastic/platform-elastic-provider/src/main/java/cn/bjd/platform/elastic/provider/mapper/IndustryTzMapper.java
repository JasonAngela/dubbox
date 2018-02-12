package cn.bjd.platform.elastic.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.bjd.platform.elastic.api.entity.IndustryTz;

@Mapper
public interface IndustryTzMapper {
    int insert(@Param("pojo") IndustryTz pojo);

    int insertSelective(@Param("pojo") IndustryTz pojo);

    int insertList(@Param("pojos") List<IndustryTz> pojo);

    int update(@Param("pojo") IndustryTz pojo);

    /**
     * 通过tzCode查询
     * @param tzCode
     * @return List
     */
    List<IndustryTz> findByTzCode(@Param("tzCode") String tzCode);


}
