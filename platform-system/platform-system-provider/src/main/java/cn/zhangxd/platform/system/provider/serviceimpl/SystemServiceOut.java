package cn.zhangxd.platform.system.provider.serviceimpl;

import cn.zhangxd.platform.system.api.entity.SysUser;
import cn.zhangxd.platform.system.api.service.ISystemServiceOut;
import cn.zhangxd.platform.system.provider.mapper.SysRoleMapper;
import cn.zhangxd.platform.system.provider.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service
@Transactional(readOnly = true)
@Path("system")
public class SystemServiceOut implements ISystemServiceOut {

    /**
     * 系统用户Mapper
     */
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 系统角色Mapper
     */
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @GET
    @Path("{id:.}")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public SysUser getUserById(@PathParam("id") String userId) {
        SysUser user = sysUserMapper.get(userId);
        if (user != null) {
            user.setRoles(sysRoleMapper.findListByUserId(userId));
        }
        return sysUserMapper.get(userId);
    }
}
