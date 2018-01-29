package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpLicence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpLicenceMapper {
    int insert(@Param("pojo") EtpLicence pojo);

    int insertSelective(@Param("pojo") EtpLicence pojo);

    int insertList(@Param("pojos") List<EtpLicence> pojo);

    int update(@Param("pojo") EtpLicence pojo);

    List<EtpLicence> findByEtpId(@Param("etpId") String etpId);

    List<EtpLicence> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
