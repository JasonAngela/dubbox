package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpPunish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpPunishMapper {
    int insert(@Param("pojo") EtpPunish pojo);

    int insertSelective(@Param("pojo") EtpPunish pojo);

    int insertList(@Param("pojos") List<EtpPunish> pojo);

    int update(@Param("pojo") EtpPunish pojo);

     List<EtpPunish> findByEtpId(@Param("etpId") String etpId);

     List<EtpPunish> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
