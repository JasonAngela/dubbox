package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.admin.web.security.utils.TokenUtil;
import cn.bjd.platform.common.web.security.AuthenticationTokenFilter;
import cn.bjd.platform.system.api.entity.SysUser;
import cn.bjd.platform.system.api.service.ISystemService;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Authentication controller.
 *
 * @author huqilang
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController extends BaseController {
    /**
     * 权限管理
     */
    @Autowired
    private AuthenticationManager authenticationManager;
    /**
     * 用户信息服务
     */
    @Autowired
    private UserDetailsService userDetailsService;
    /**
     * Token工具
     */
    @Autowired
    private TokenUtil jwtTokenUtil;

    @Autowired
    private ISystemService systemService;
    /**
     * Create authentication token bearer auth token.
     *
     * @param sysUser the sys user
     * @return the bearer auth token
     */
    @PostMapping(value = "/token")
    public Map<String, Object> createAuthenticationToken(@RequestBody SysUser sysUser) {

        //检测用户的合法性
        if(sysUser == null){
            throw new cn.bjd.platform.system.api.exception.base.SystemException("所填信息为空");
        }

        if(StringUtils.isEmpty(sysUser.getLoginName())||StringUtils.isEmpty(sysUser.getPassword())){
            throw new cn.bjd.platform.system.api.exception.base.SystemException("用户名或者密码不能为空");
        }

        SysUser loginUser = systemService.getByLoginName(sysUser.getLoginName());
        if(loginUser == null){
            throw new cn.bjd.platform.system.api.exception.base.SystemException("用户不存在");
        }


        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(sysUser.getLoginName(), sysUser.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("access_token", token);
        tokenMap.put("expires_in", jwtTokenUtil.getExpiration());
        tokenMap.put("token_type", TokenUtil.TOKEN_TYPE_BEARER);
        return tokenMap;
    }

    /**
     * Refresh and get authentication token bearer auth token.
     *
     * @param request the request
     * @return the bearer auth token
     */
    @GetMapping(value = "/refresh")
    public Map<String, Object> refreshAndGetAuthenticationToken(HttpServletRequest request) {

        String tokenHeader = request.getHeader(AuthenticationTokenFilter.TOKEN_HEADER);
        String token = tokenHeader.split(" ")[1];

        String username = jwtTokenUtil.getUsernameFromToken(token);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String refreshedToken = jwtTokenUtil.generateToken(userDetails);

        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("access_token", refreshedToken);
        tokenMap.put("expires_in", jwtTokenUtil.getExpiration());
        tokenMap.put("token_type", TokenUtil.TOKEN_TYPE_BEARER);
        return tokenMap;
    }

    /**
     * Delete authentication token response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @DeleteMapping(value = "/delete/token")
    public ResponseEntity deleteAuthenticationToken(HttpServletRequest request) {

        String tokenHeader = request.getHeader(AuthenticationTokenFilter.TOKEN_HEADER);
        String token = tokenHeader.split(" ")[1];

        jwtTokenUtil.removeToken(token);

        return new ResponseEntity(HttpStatus.OK);
    }

}
