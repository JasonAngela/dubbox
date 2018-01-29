package cn.bjd.platform.elastic.provider.mapper;

import cn.bjd.platform.elastic.api.entity.Etp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EtpMapper {
    int insert(@Param("pojo") Etp pojo);

    int insertSelective(@Param("pojo") Etp pojo);

    int insertList(@Param("pojos") List<Etp> pojo);

    int update(@Param("pojo") Etp pojo);

    List<String> selectIdByEntName(@Param("entName") String entName);

    Etp findByEntName(@Param("entName") String entName);

     List<Etp> findByEntNameIn(@Param("entNameList") List<String> entNameList);

    /**
     * 通过企业id获取企业
     * @param id
     * @return Etp
     */
     Etp findById(@Param("id") String id);


}
