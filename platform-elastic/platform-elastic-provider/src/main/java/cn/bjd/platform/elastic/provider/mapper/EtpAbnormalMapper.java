package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpAbnormal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpAbnormalMapper {
    int insert(@Param("pojo") EtpAbnormal pojo);

    int insertSelective(@Param("pojo") EtpAbnormal pojo);

    int insertList(@Param("pojos") List<EtpAbnormal> pojo);

    int update(@Param("pojo") EtpAbnormal pojo);

     List<EtpAbnormal> findByEtpId(@Param("etpId") String etpId);

     List<EtpAbnormal> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
