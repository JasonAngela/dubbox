package cn.bjd.platform.elastic.api.service;

import cn.bjd.platform.elastic.api.entity.dto.EtpDTO;

public interface IEtpBOService {
    EtpDTO findById(String id);
}
