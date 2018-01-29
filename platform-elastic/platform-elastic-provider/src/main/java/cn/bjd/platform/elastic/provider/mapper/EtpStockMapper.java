package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpStockMapper {
    int insert(@Param("pojo") EtpStock pojo);

    int insertSelective(@Param("pojo") EtpStock pojo);

    int insertList(@Param("pojos") List<EtpStock> pojo);

    int update(@Param("pojo") EtpStock pojo);

    List<EtpStock> findByEtpId(@Param("etpId") String etpId);

    List<EtpStock> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
