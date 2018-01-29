package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpChattel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpChattelMapper {
    int insert(@Param("pojo") EtpChattel pojo);

    int insertSelective(@Param("pojo") EtpChattel pojo);

    int insertList(@Param("pojos") List<EtpChattel> pojo);

    int update(@Param("pojo") EtpChattel pojo);

     List<EtpChattel> findByEtpId(@Param("etpId") String etpId);

     List<EtpChattel> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
