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
    Integer countForCompany(List<String> list);

    /**
     * 分区域统计
     * @param count
     * @return
     */
    List<SysCount> countGroupByProvinceAndCityN(SysCount count);

    List<SysCount> countGroupByProvinceAndCityP(SysCount count);

    List<SysCount> countGroupByProvinceAndCityC(SysCount count);
    /**
     * 企业历史数量分区域变化(不选择省 那么根据省分类)
     * @param count
     * @return
     */
    List<SysCount> countAreaOnlySelectNothing(SysCount count);

    /**
     * 企业历史数量分区域变化province
     * @param count
     * @return
     */
    List<SysCount> countAreaOnlySelectProvince(SysCount count);

    /**
     * 企业历史数量分区域变化city
     * @param count
     * @return
     */
    List<SysCount> countAreaOnlySelectCity(SysCount count);

    /**
     * 企业历史数量分区域变化area
     * @param count
     * @return
     */
    List<SysCount> countAreaOnlySelectArea(SysCount count);


    /**
     * 行业分类统计  TOP10 Customs海关企业评级统计 Tax税务企业评级统计 SQL
     * @param count
     * @return
     */
    List<SysCount> countIndustryCustomsTaxTop(SysCount count);


    /**
     * 行业历史数量变化
     * @param count
     * @return
     */
    List<SysCount> industryHistoryByYear(SysCount count);

    /**
     * 涉诉信息统计  违法信息统计
     * @param count
     * @return
     */
    List<SysCount> countDSelect(SysCount count);


    /**
     * 涉诉信息 违法信息历史变化 企业增长消亡曲线
     * @param count
     * @return
     */
    List<SysCount> countCompanyCommon(SysCount count);

    /**
     * 海关税务企业评级历史变化统计
     * @param count
     * @return
     */
    List<SysCount> countCustomsTaxGradeHistory(SysCount count);

}