package cn.bjd.platform.system.provider.mapper;

import cn.bjd.platform.common.service.dao.CrudDao;
import cn.bjd.platform.system.api.entity.SysCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 首页统计DAO接口
 *
 * @author Jason
 */
@Mapper
public interface SysCountMapper  extends CrudDao<SysCount> {

    /**
     *
     * @param count
     * @return
     */
    List<SysCount> getCount(SysCount count);

    /**
     * 根据类型查询企业相关数量
     * @param list
     * @return
     */
    Long countForCompany(List<SysCount> list);

    /**
     * 分区域统计
     * @param count
     * @return
     */
    List<SysCount> countGroupByProvinceAndCity(SysCount count);

    /**
     * 企业数量增长消亡曲线
     * @param count
     * @return
     */
    List<SysCount> countUpDownGroupByYear(SysCount count);
}
