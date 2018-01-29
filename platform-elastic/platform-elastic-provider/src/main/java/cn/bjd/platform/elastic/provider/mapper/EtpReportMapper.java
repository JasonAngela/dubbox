package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.EtpReport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface EtpReportMapper {
    int insert(@Param("pojo") EtpReport pojo);

    int insertSelective(@Param("pojo") EtpReport pojo);

    int insertList(@Param("pojos") List<EtpReport> pojo);

    int update(@Param("pojo") EtpReport pojo);
}
