package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpShareholderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpShareholderDetailMapper {
    int insert(@Param("pojo") EtpShareholderDetail pojo);

    int insertSelective(@Param("pojo") EtpShareholderDetail pojo);

    int insertList(@Param("pojos") List<EtpShareholderDetail> pojo);

    int update(@Param("pojo") EtpShareholderDetail pojo);
}
