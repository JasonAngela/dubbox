package cn.bjd.platform.common.utils.framework;

public class RequestIDContext {
    /**
     * 当前用户线程，用于存储当前用户执行的报文结果
     */
    private static final ThreadLocal<RequestIDContext> requestIDContext = new ThreadLocal<RequestIDContext>();
    private String requestID;

    /**
     * 屏蔽无参构造方法，防止用户手工new对象，从而丢失ThreadLocal中的对象
     */
    private RequestIDContext()
    {
        super();
    }

    /**
     * 获取当前线程中的RequestIDContext，防止一个ThreadLocal中出现多个RequestIDContext对象
     */
    public static RequestIDContext currentContext()
    {
        RequestIDContext currentContext = get();
        if (currentContext == null)
        {
            currentContext = new RequestIDContext();
            set(currentContext);
        }

        return currentContext;
    }

    private static void set(RequestIDContext sc)
    {
        requestIDContext.set(sc);
    }

    private static RequestIDContext get()
    {
        return requestIDContext.get();
    }

    public static void remove()
    {
        requestIDContext.remove();
    }

    public String getRequestID()
    {
        return requestID;
    }

    public void setRequestID(String requestID)
    {
        this.requestID = requestID;
    }
}
