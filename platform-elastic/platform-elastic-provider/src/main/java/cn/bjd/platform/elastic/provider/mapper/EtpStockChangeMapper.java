package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpStockChange;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpStockChangeMapper {
    int insert(@Param("pojo") EtpStockChange pojo);

    int insertSelective(@Param("pojo") EtpStockChange pojo);

    int insertList(@Param("pojos") List<EtpStockChange> pojo);

    int update(@Param("pojo") EtpStockChange pojo);

     List<EtpStockChange> findByEtpId(@Param("etpId") String etpId);

     List<EtpStockChange> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
