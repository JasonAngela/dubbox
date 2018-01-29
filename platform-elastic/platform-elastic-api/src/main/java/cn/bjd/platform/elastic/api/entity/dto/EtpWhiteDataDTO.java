package cn.bjd.platform.elastic.api.entity.dto;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/1/26 0026.
 */
public class EtpWhiteDataDTO {

    /**
     * 总数
     */
    private Long total;

    /**
     * 白名单
     */
    private List<EtpWhiteDTO> whileList = new ArrayList<>();

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
     * Gets whileList
     *
     * @return value of whileList
     */
    public List<EtpWhiteDTO> getWhileList() {
        return whileList;
    }

    /**
     * @param whileList
     */
    public void setWhileList(List<EtpWhiteDTO> whileList) {
        this.whileList = whileList;
    }
}
