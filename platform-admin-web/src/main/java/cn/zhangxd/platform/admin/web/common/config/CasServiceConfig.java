package cn.zhangxd.platform.admin.web.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "security.cas.service")
public class CasServiceConfig {
    private String host;
    private String login;
    private String logout;
    private Boolean sendRenew = false;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

    public Boolean getSendRenew() {
        return sendRenew;
    }

    public void setSendRenew(Boolean sendRenew) {
        this.sendRenew = sendRenew;
    }
}
