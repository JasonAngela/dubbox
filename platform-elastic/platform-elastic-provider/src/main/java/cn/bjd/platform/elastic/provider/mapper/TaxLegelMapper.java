package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.TaxLegel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaxLegelMapper {
    int insert(@Param("pojo") TaxLegel pojo);

    int insertSelective(@Param("pojo") TaxLegel pojo);

    int insertList(@Param("pojos") List<TaxLegel> pojo);

    int update(@Param("pojo") TaxLegel pojo);

    /**
     * 根据企业名获取税收违法数据
     *
     * @param companyName
     * @return List
     */
    List<TaxLegel> findByCompanyName(@Param("companyName") String companyName);

    /**
     * 根据企业名获取税收违法数据数量
     *
     * @param companyName
     * @return int
     */
    int findCountByCompanyName(@Param("companyName") String companyName);

}
