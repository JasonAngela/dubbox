package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpBranch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpBranchMapper {
    int insert(@Param("pojo") EtpBranch pojo);

    int insertSelective(@Param("pojo") EtpBranch pojo);

    int insertList(@Param("pojos") List<EtpBranch> pojo);

    int update(@Param("pojo") EtpBranch pojo);

     List<EtpBranch> findByEtpId(@Param("etpId") String etpId);

     List<EtpBranch> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);
}
