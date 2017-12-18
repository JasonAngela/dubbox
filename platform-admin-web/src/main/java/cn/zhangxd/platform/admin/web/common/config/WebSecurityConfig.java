package cn.zhangxd.platform.admin.web.common.config;

import cn.zhangxd.platform.admin.web.security.UserDetailsServiceImpl;
import cn.zhangxd.platform.common.web.config.AbstractWebSecurityConfig;

import cn.zhangxd.platform.common.web.security.AuthenticationTokenFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;


/**
 * spring-security配置
 *
 * @author zhangxd
 */
@Configuration
public class WebSecurityConfig extends AbstractWebSecurityConfig {

    @Autowired
    private CasServerConfig casServerConfig;

    @Autowired
    private CasServiceConfig casServiceConfig;

    /**
     * 用户信息服务
     */
    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/token").permitAll()
                .antMatchers("/cas/login").permitAll()
                .antMatchers("/cas/loginout").permitAll()
                .antMatchers("/auth/delete/token").permitAll();

        security.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint());


        security.
                addFilter(casAuthenticationFilter())
                .addFilterBefore(casLogoutFilter(), LogoutFilter.class)
                .addFilterBefore(singleSignOutFilter(), CasAuthenticationFilter.class);

        super.configure(security);
    }



   /*@Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean() {
        return new AuthenticationTokenFilter();
    }*/

   /* @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(this.passwordEncoder())
        ;
    }*/

   /**认证的入口*/
    @Bean
    public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
        CasAuthenticationEntryPoint casAuthenticationEntryPoint = new CasAuthenticationEntryPoint();
        casAuthenticationEntryPoint.setLoginUrl(casServerConfig.getLogin());
        casAuthenticationEntryPoint.setServiceProperties(serviceProperties());
        return casAuthenticationEntryPoint;
    }

    /**指定service相关信息*/
    @Bean
    public ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService(casServiceConfig.getHost() + casServiceConfig.getLogin());
        serviceProperties.setAuthenticateAllArtifacts(true);
        return serviceProperties;
    }

    /**CAS认证过滤器*/
    @Bean
    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
        casAuthenticationFilter.setAuthenticationManager(authenticationManager());
        casAuthenticationFilter.setFilterProcessesUrl(casServiceConfig.getLogin());
        return casAuthenticationFilter;
    }


    /*@Bean
    public CasAuthenticationProvider casAuthenticationProvider() {
        CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
        //casAuthenticationProvider.setAuthenticationUserDetailsService(this.userDetailsService());
        casAuthenticationProvider.setUserDetailsService(this.userDetailsService); //这里只是接口类型，实现的接口不一样，都可以的。
        casAuthenticationProvider.setServiceProperties(serviceProperties());
        casAuthenticationProvider.setTicketValidator(cas20ServiceTicketValidator());
        casAuthenticationProvider.setKey("casAuthenticationProviderKey");
        return casAuthenticationProvider;
    }*/

    @Bean
    public Cas20ServiceTicketValidator cas20ServiceTicketValidator() {
        return new Cas20ServiceTicketValidator(casServerConfig.getHost());
    }

    /**单点登出过滤器*/
    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
        singleSignOutFilter.setCasServerUrlPrefix(casServerConfig.getHost());
        singleSignOutFilter.setIgnoreInitConfiguration(true);
        return singleSignOutFilter;
    }

    /**请求单点退出过滤器*/
    @Bean
    public LogoutFilter casLogoutFilter() {
        LogoutFilter logoutFilter = new LogoutFilter(casServerConfig.getLogout(), new SecurityContextLogoutHandler());
        logoutFilter.setFilterProcessesUrl(casServiceConfig.getLogout());
        return logoutFilter;
    }

}
