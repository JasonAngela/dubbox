package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.system.api.entity.SysRegion;
import cn.bjd.platform.system.api.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/sys/region")
public class SysRegionController extends BaseController {
    /**
     * 系统用户服务
     */
    @Autowired
    private ISystemService systemService;

    @GetMapping(value = "/tree")
    public List<SysRegion> getTree(){

        //从缓存中先去取 取不到就去数据库查询


        return systemService.getRegionTree();
    }
}
