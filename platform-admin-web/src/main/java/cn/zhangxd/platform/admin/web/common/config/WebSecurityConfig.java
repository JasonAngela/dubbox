package cn.zhangxd.platform.admin.web.common.config;

import cn.zhangxd.platform.common.web.config.AbstractWebSecurityConfig;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 * spring-security配置
 *
 * @author zhangxd
 */
@Configuration
@EnableConfigurationProperties({CasServerConfig.class,CasServiceConfig.class})
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends AbstractWebSecurityConfig {

    @Autowired
    private CasServerConfig casServerConfig;

    @Autowired
    private CasServiceConfig casServiceConfig;

    @Autowired
    private CasAuthenticationEntryPoint casAuthenticationEntryPoint;

    @Autowired
    private CasAuthenticationProvider casAuthenticationProvider;

    @Autowired
    private CasAuthenticationFilter casAuthenticationFilter;

    @Autowired
    private LogoutFilter logoutFilter;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/auth/token").permitAll();//不拦截auth/token
        security.logout().permitAll();//不拦截注销
        security.exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint);


        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
        singleSignOutFilter.setCasServerUrlPrefix(this.casServerConfig.getHost());

        security.addFilter(casAuthenticationFilter)
                .addFilterBefore(logoutFilter, LogoutFilter.class)
                .addFilterBefore(singleSignOutFilter, CasAuthenticationFilter.class);//增加拦截器

        super.configure(security);
    }


    @Bean
    public ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService(this.casServiceConfig.getHost() + this.casServiceConfig.getLogin());
        serviceProperties.setSendRenew(this.casServiceConfig.getSendRenew());
        return serviceProperties;
    }


    @Bean
    public CasAuthenticationFilter casAuthenticationFilter(AuthenticationManager authenticationManager, ServiceProperties serviceProperties) {
        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
        casAuthenticationFilter.setAuthenticationManager(authenticationManager);
        casAuthenticationFilter.setServiceProperties(serviceProperties);
        casAuthenticationFilter.setFilterProcessesUrl(this.casServiceConfig.getLogin());
        casAuthenticationFilter.setContinueChainBeforeSuccessfulAuthentication(false);
        casAuthenticationFilter.setAuthenticationSuccessHandler(
                new SimpleUrlAuthenticationSuccessHandler("/")
        );
        return casAuthenticationFilter;
    }

    @Bean
    public CasAuthenticationEntryPoint casAuthenticationEntryPoint(ServiceProperties serviceProperties) {
        CasAuthenticationEntryPoint entryPoint = new CasAuthenticationEntryPoint();
        entryPoint.setLoginUrl(this.casServerConfig.getLogin());
        entryPoint.setServiceProperties(serviceProperties);
        return entryPoint;
    }

    @Bean
    public Cas20ServiceTicketValidator cas20ServiceTicketValidator() {
        return new Cas20ServiceTicketValidator(this.casServerConfig.getHost());
    }

    @Bean
    public CasAuthenticationProvider casAuthenticationProvider(
            AuthenticationUserDetailsService<CasAssertionAuthenticationToken> userDetailsService,
            ServiceProperties serviceProperties, Cas20ServiceTicketValidator ticketValidator) {
        CasAuthenticationProvider provider = new CasAuthenticationProvider();
        provider.setKey("casProvider");
        provider.setServiceProperties(serviceProperties);
        provider.setTicketValidator(ticketValidator);
        provider.setAuthenticationUserDetailsService(userDetailsService);

        return provider;
    }

    @Bean
    public LogoutFilter logoutFilter() {
        String logoutRedirectPath = this.casServerConfig.getLogout() + "?service=" +
                this.casServiceConfig.getHost();
        LogoutFilter logoutFilter = new LogoutFilter(logoutRedirectPath, new SecurityContextLogoutHandler());
        logoutFilter.setFilterProcessesUrl(this.casServiceConfig.getLogout());
        return logoutFilter;
    }







}
