package cn.bjd.platform.common.web.security;

import cn.bjd.platform.system.api.entity.SysIndustry;
import cn.bjd.platform.system.api.entity.SysMenu;
import cn.bjd.platform.system.api.entity.SysRegion;
import com.google.gson.Gson;
import cn.bjd.platform.common.redis.RedisRepository;
import cn.bjd.platform.common.utils.StringHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Token 工具类
 *
 * @author huqilang
 */
public abstract class AbstractTokenUtil {

    /**
     * Logger
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractTokenUtil.class);

    /**
     * Token 类型
     */
    public static final String TOKEN_TYPE_BEARER = "Bearer";
    /**
     * 权限缓存前缀
     */
    private static final String REDIS_PREFIX_AUTH = "auth:";
    /**
     * 用户信息缓存前缀
     */
    private static final String REDIS_PREFIX_USER = "user-details:";

    /**
     * 省市区缓存前缀
     */
    private static final String REDIS_PREFIX_REGION = "region:";

    /**
     * 菜单缓存前缀
     */
    private static final String REDIS_PREFIX_MENU_TREE = "menu-tree:";

    private static final String REDIS_PREFIX_MENU_LIST = "menu-list:";

    private static final String REDIS_PREFIX_INDUSTRY_LIST = "industry-list:";

    private static final String REDIS_PREFIX_INDUSTRY_ID_IPATH_MAP = "industry-id-ipath-map:";

    /**
     * redis repository
     */
    @Autowired
    private RedisRepository redisRepository;
    /**
     * secret
     */
    private String secret;
    /**
     * 过期时间
     */
    private Long expiration;

    /**
     * 获取用户名
     *
     * @param token Token
     * @return String
     */
    public String getUsernameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims != null ? claims.getSubject() : null;
    }

    /**
     * 获取过期时间
     *
     * @param token Token
     * @return Date
     */
    public Date getExpiredFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims != null ? claims.getExpiration() : null;
    }

    /**
     * 获得 Claims
     *
     * @param token Token
     * @return Claims
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        } catch (Exception e) {
            LOGGER.warn("getClaimsFromToken exception", e);
            claims = null;
        }
        return claims;
    }

    /**
     * 计算过期时间
     *
     * @return Date
     */
    private Date generateExpired() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 判断 Token 是否过期
     *
     * @param token Token
     * @return Boolean
     */
    private Boolean isTokenExpired(String token) {
        Date expirationDate = getExpiredFromToken(token);
        return expirationDate.before(new Date());
    }

    /**
     * 生成 Token
     *
     * @param userDetails 用户信息
     * @return String
     */
    public String generateToken(UserDetails userDetails) {
        String token = Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setExpiration(generateExpired())
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();

        String key = REDIS_PREFIX_AUTH + userDetails.getUsername();
        redisRepository.setExpire(key, token, expiration);
        putUserDetails(userDetails);
        return token;
    }

    /**
     * 验证 Token
     *
     * @param token Token
     * @return Boolean
     */
    public Boolean validateToken(String token) {
        final String username = getUsernameFromToken(token);
        String key = REDIS_PREFIX_AUTH + username;
        String redisToken = redisRepository.get(key);
        return StringHelper.isNotEmpty(token) && !isTokenExpired(token) && token.equals(redisToken);
    }

    /**
     * 移除 Token
     *
     * @param token Token
     */
    public void removeToken(String token) {
        final String username = getUsernameFromToken(token);
        String key = REDIS_PREFIX_AUTH + username;
        redisRepository.del(key);
        delUserDetails(username);
    }

    /**
     * 获得用户信息 Json 字符串
     *
     * @param token Token
     * @return String
     */
    protected String getUserDetailsString(String token) {
        final String username = getUsernameFromToken(token);
        String key = REDIS_PREFIX_USER + username;
        return redisRepository.get(key);
    }

    /**
     * 获得用户信息
     *
     * @param token Token
     * @return UserDetails
     */
    public abstract UserDetails getUserDetails(String token);


    /**
     * 存储用户信息
     *
     * @param userDetails 用户信息
     */
    private void putUserDetails(UserDetails userDetails) {
        String key = REDIS_PREFIX_USER + userDetails.getUsername();
        redisRepository.setExpire(key, new Gson().toJson(userDetails), expiration);
    }

    /**
     * 存储省市区域信息
     * @param list
     */
    public void putRegionTree(Collection<SysRegion> list){
        String key = REDIS_PREFIX_REGION + "tree";
        redisRepository.setExpire(key,new Gson().toJson(list),expiration);
    }

    /**
     * 查询出省市区信息
     * @return
     */
    public List<SysRegion> getRegionDetails(){
        String key = REDIS_PREFIX_REGION + "tree";
        String value = redisRepository.get(key);
        if(!StringUtils.isEmpty(value)){
            return new Gson().fromJson(value,List.class);
        }
        return null;
    }


    public void putIndustryIdIpathMap(Collection<SysIndustry> list){
        //转化为Map
        Map<String,String> map = new HashMap<>();
        for(SysIndustry industry : list){
            map.put(industry.getId(),industry.getIPath());
        }
        String key = REDIS_PREFIX_INDUSTRY_ID_IPATH_MAP + "map";
        redisRepository.setExpire(key,new Gson().toJson(map),expiration);
    }


    public Map<String,String> getIndustryIdIpathMap(){
        String key = REDIS_PREFIX_INDUSTRY_ID_IPATH_MAP + "map";
        String value = redisRepository.get(key);
        if(!StringUtils.isEmpty(value)){
            return new Gson().fromJson(value,Map.class);
        }
        return null;
    }


    public void putIndustryList(Collection<SysIndustry> list){
        //转化为Map
        Map<String,String> map = new HashMap<>();
        for(SysIndustry industry : list){
            map.put(industry.getIPath(),industry.getName());
        }
        String key = REDIS_PREFIX_INDUSTRY_LIST + "list";
        redisRepository.setExpire(key,new Gson().toJson(map),expiration);
    }


    public Map<String,String> getIndustryDetails(){
        String key = REDIS_PREFIX_INDUSTRY_LIST + "list";
        String value = redisRepository.get(key);
        if(!StringUtils.isEmpty(value)){
            return new Gson().fromJson(value,Map.class);
        }
        return null;
    }

    /**
     * 缓存菜单数据
     * @param list
     */
    public void putMenuTree(Collection<SysMenu> list,String userId,String flag){
        String key = REDIS_PREFIX_MENU_TREE + userId;
        if("list".equals(flag)){
            key = REDIS_PREFIX_MENU_LIST + userId;
        }
        redisRepository.setExpire(key,new Gson().toJson(list),expiration);
    }


    public List<SysMenu> getMenuDetails(String userId,String flag){
        String key = REDIS_PREFIX_MENU_TREE + userId;
        if("list".equals(flag)){
            key = REDIS_PREFIX_MENU_LIST + userId;
        }
        String value = redisRepository.get(key);
        if(!StringUtils.isEmpty(value)){
            return new Gson().fromJson(value,List.class);
        }
        return null;
    }

    public void delMenu(String userId,String flag){
        String key = REDIS_PREFIX_MENU_TREE + userId;
        if("list".equals(flag)){
            key = REDIS_PREFIX_MENU_LIST + userId;
        }
        redisRepository.del(key);
    }



    /**
     * 删除用户信息
     *
     * @param username 用户名
     */
    private void delUserDetails(String username) {
        String key = REDIS_PREFIX_USER + username;
        redisRepository.del(key);
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }
}