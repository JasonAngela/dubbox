package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpIllegal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpIllegalMapper {
    int insert(@Param("pojo") EtpIllegal pojo);

    int insertSelective(@Param("pojo") EtpIllegal pojo);

    int insertList(@Param("pojos") List<EtpIllegal> pojo);

    int update(@Param("pojo") EtpIllegal pojo);

     List<EtpIllegal> findByEtpId(@Param("etpId") String etpId);

     List<EtpIllegal> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
