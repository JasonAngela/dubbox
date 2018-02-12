package cn.bjd.platform.elastic.api.service;

import cn.bjd.platform.elastic.api.entity.dto.*;

public interface IEtpBOService {
    EtpDTO findById(String id);

    /**
     * 通过企业id获取资质能力
     * @param id
     * @return EtpAptitudeDTO
     */
    EtpAptitudeDTO findEtpAptitudeById(String id);

    ReadDTO findReadByEtpId(String id);

    EtpBasicDTO findBasicById(String id);

    RiskDTO findRiskById(String id);

    AtlasDTO findAtlasById(String id);
}