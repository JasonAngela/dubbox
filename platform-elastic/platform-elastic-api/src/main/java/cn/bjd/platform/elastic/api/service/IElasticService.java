package cn.bjd.platform.elastic.api.service;

import cn.bjd.platform.elastic.api.entity.dto.EtpEsDataDTO;
import cn.bjd.platform.elastic.api.entity.dto.EtpWhiteDataDTO;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by admin on 2018/1/26 0026.
 */
public interface IElasticService {
    EtpEsDataDTO findByKeyword(String keyword, Integer page, Integer pageNum) throws ParseException, IOException;

    EtpWhiteDataDTO findWhiteList(String regionCode, Integer startScore, Integer endScore, List<String> industrys, Integer startReg, Integer endReg, Integer startCap, Integer endCap, String count) throws ParseException, IOException;

    Long findWhiteCount(String regionCode, Integer startScore, Integer endScore, List<String> industrys, Integer startReg, Integer endReg, Integer startCap, Integer endCap) throws ParseException, IOException;
}
