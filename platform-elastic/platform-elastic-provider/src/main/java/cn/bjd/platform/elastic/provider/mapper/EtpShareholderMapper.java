package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpShareholder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpShareholderMapper {
    int insert(@Param("pojo") EtpShareholder pojo);

    int insertSelective(@Param("pojo") EtpShareholder pojo);

    int insertList(@Param("pojos") List<EtpShareholder> pojo);

    int update(@Param("pojo") EtpShareholder pojo);

    List<EtpShareholder> findByEtpId(@Param("etpId") String etpId);

    List<EtpShareholder> findByEtpIdIn(@Param("etpIdList") List<String> etpIdList);

    List<String> selectShareholderByEtpId(@Param("etpId") String etpId);

    List<String> selectEtpIdByShareholder(@Param("shareholder") String shareholder);
}
