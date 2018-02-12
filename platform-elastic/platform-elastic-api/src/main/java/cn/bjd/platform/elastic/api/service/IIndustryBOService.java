package cn.bjd.platform.elastic.api.service;

import cn.bjd.platform.elastic.api.entity.dto.IndustryDTO;

public interface IIndustryBOService {

    /**
     * 通过企业id获取行业信息
     *
     * @param id
     * @return IndustryDTO
     */
    IndustryDTO findIndustryById(String id);
}
