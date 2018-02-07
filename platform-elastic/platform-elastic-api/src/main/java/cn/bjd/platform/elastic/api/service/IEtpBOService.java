package cn.bjd.platform.elastic.api.service;

import cn.bjd.platform.elastic.api.entity.dto.EtpDTO;
import cn.bjd.platform.elastic.api.entity.dto.ReadDTO;

public interface IEtpBOService {
    EtpDTO findById(String id);

    ReadDTO findReadByEtpId(String id);
}
