package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpSeniorManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpSeniorManagerMapper {
    int insert(@Param("pojo") EtpSeniorManager pojo);

    int insertSelective(@Param("pojo") EtpSeniorManager pojo);

    int insertList(@Param("pojos") List<EtpSeniorManager> pojo);

    int update(@Param("pojo") EtpSeniorManager pojo);

    List<EtpSeniorManager> findByEtpId(@Param("etpId") String etpId);

     List<EtpSeniorManager> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
