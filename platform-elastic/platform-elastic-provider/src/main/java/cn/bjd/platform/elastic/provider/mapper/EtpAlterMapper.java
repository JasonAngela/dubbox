package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpAlter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpAlterMapper {
    int insert(@Param("pojo") EtpAlter pojo);

    int insertSelective(@Param("pojo") EtpAlter pojo);

    int insertList(@Param("pojos") List<EtpAlter> pojo);

    int update(@Param("pojo") EtpAlter pojo);

     List<EtpAlter> findByEtpId(@Param("etpId") String etpId);

     List<EtpAlter> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
