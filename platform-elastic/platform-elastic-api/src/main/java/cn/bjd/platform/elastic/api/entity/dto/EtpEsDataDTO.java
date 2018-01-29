package cn.bjd.platform.elastic.api.entity.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/1/26 0026.
 */
public class EtpEsDataDTO {
    /**
     * 总数
     */
    private Long total;

    /**
     * 企业列表
     */
    private List<EtpEsDTO> companyList;

    public EtpEsDataDTO() {
        companyList = new ArrayList<>();
    }

    /**
     * Gets total
     *
     * @return value of total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * @param total
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * Gets companyList
     *
     * @return value of companyList
     */
    public List<EtpEsDTO> getCompanyList() {
        return companyList;
    }

    /**
     * @param companyList
     */
    public void setCompanyList(List<EtpEsDTO> companyList) {
        this.companyList = companyList;
    }
}
