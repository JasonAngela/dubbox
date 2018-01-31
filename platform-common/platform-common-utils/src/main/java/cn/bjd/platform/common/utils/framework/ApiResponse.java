package cn.bjd.platform.common.utils.framework;

import java.io.Serializable;

/**
 * 所有Http Response数据结构，只要是给客户端提供服务的，都要使用该对象返回
 * 缺少返回requstId 暂时没用上 对应实体类RequsetIDContext
 * @author huqilang
 */
public class ApiResponse implements Serializable {
    private static final long serialVersionUID = -1485867865440737606L;

    private static final String success = "200";
    private static final String ERR_405 = "405";//参数无效
    private static final String ERR_404 = "404";
    private String code;                       // 返回业务状态码
    private long timestamp;                    // 响应请求的时间戳
    private String reason;                       // 返回消息
    private Object result;                       // 用户需要发送的参数

    /**
     * 屏蔽无参构造参数
     */
    private ApiResponse()
    {
        this.timestamp = System.currentTimeMillis();
    }

    public static ApiResponse getInstances()
    {
        return new ApiResponse();
    }

    public ApiResponse success()
    {
        setCode(success);
        return this;
    }

    public ApiResponse success(String code)
    {
        setCode(code);
        return this;
    }

    public ApiResponse error(String code)
    {
        setCode(code);
        return this;
    }

    public String getCode()
    {
        return code;
    }

    public ApiResponse setCode(String code)
    {
        this.code = code;
        return this;
    }


    public long getTimestamp()
    {
        return timestamp;
    }


    public Object getResult() {
        return result;
    }

    public ApiResponse setResult(Object result) {
        this.result = result;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public ApiResponse setReason(String reason) {
        this.reason = reason;
        return this;
    }
}