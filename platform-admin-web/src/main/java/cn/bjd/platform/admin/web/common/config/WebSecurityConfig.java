package cn.bjd.platform.admin.web.common.config;

import cn.bjd.platform.common.web.config.AbstractWebSecurityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;


/**
 * spring-security配置
 *
 * @author huqilang
 */
@Configuration
public class WebSecurityConfig extends AbstractWebSecurityConfig {

   /* @Autowired
    private CasServerConfig casServerConfig;

    @Autowired
    private CasServiceConfig casServiceConfig;

    *//**
     * 用户信息服务
     *//*
    @Autowired
    private UserDetailsService userDetailsService;*/


    @Override
    protected void configure(HttpSecurity security) throws Exception {
       /* security
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/token").permitAll()
                .antMatchers("/cas/login").permitAll()
                .antMatchers("/cas/loginout").permitAll()
                .antMatchers("/auth/delete/token").permitAll()
                .antMatchers("/page/*").permitAll()
        ;

        security.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint())
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        security
                .addFilter(casAuthenticationFilter())
                .addFilterBefore(casLogoutFilter(), LogoutFilter.class)
                .addFilterBefore(singleSignOutFilter(), CasAuthenticationFilter.class);*/



        security
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/token").permitAll();
        super.configure(security);

    }


   /* @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(customUserDetailsService())
             .passwordEncoder(this.passwordEncoder());
        auth.authenticationProvider(casAuthenticationProvider());
    }

   *//**认证的入口*//*
    @Bean
    public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
        CasAuthenticationEntryPoint casAuthenticationEntryPoint = new CasAuthenticationEntryPoint();
        casAuthenticationEntryPoint.setLoginUrl(casServerConfig.getLogin());
        casAuthenticationEntryPoint.setServiceProperties(serviceProperties());
        return casAuthenticationEntryPoint;
    }

    *//**指定service相关信息*//*
    @Bean
    public ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService(casServiceConfig.getHost() + casServiceConfig.getLogin());
        serviceProperties.setAuthenticateAllArtifacts(true);
        return serviceProperties;
    }

   *//* @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean() {
        return new AuthenticationTokenFilter();
    }*//*

    *//**CAS认证过滤器*//*
    @Bean
    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
        casAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        casAuthenticationFilter.setFilterProcessesUrl(casServiceConfig.getLogin());
        return casAuthenticationFilter;
    }

    public UserDetailsService customUserDetailsService(){
        return new UserDetailsServiceImpl();
    }


   *//* @Bean
    public AuthenticationUserDetailsService<CasAssertionAuthenticationToken> customUserDetailsService(){
        return new UserDetailsServiceImpl();
    }*//*

    @Bean
    public CasAuthenticationProvider casAuthenticationProvider() {
        CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
        //casAuthenticationProvider.setAuthenticationUserDetailsService(customUserDetailsService());
        casAuthenticationProvider.setUserDetailsService(customUserDetailsService()); //这里只是接口类型，实现的接口不一样，都可以的。
        casAuthenticationProvider.setServiceProperties(serviceProperties());
        casAuthenticationProvider.setTicketValidator(cas20ServiceTicketValidator());
        casAuthenticationProvider.setKey("casAuthenticationProviderKey");
        return casAuthenticationProvider;
    }

    @Bean
    public Cas20ServiceTicketValidator cas20ServiceTicketValidator() {
        return new Cas20ServiceTicketValidator(casServerConfig.getHost());
    }

    *//**单点登出过滤器*//*
    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
        singleSignOutFilter.setCasServerUrlPrefix(casServerConfig.getHost());
        singleSignOutFilter.setIgnoreInitConfiguration(true);
        return singleSignOutFilter;
    }

    *//**请求单点退出过滤器*//*
    @Bean
    public LogoutFilter casLogoutFilter() {
        LogoutFilter logoutFilter = new LogoutFilter(casServerConfig.getLogout(), new SecurityContextLogoutHandler());
        logoutFilter.setFilterProcessesUrl(casServiceConfig.getLogout());
        return logoutFilter;
    }
*/
}