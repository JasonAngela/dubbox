package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpSharesFrost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpSharesFrostMapper {
    int insert(@Param("pojo") EtpSharesFrost pojo);

    int insertSelective(@Param("pojo") EtpSharesFrost pojo);

    int insertList(@Param("pojos") List<EtpSharesFrost> pojo);

    int update(@Param("pojo") EtpSharesFrost pojo);

     List<EtpSharesFrost> findByEtpId(@Param("etpId") String etpId);

     List<EtpSharesFrost> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
