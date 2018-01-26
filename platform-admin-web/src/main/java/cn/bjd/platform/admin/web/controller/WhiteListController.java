package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.admin.web.security.utils.TokenUtil;
import cn.bjd.platform.common.utils.framework.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 白名单Controller
 *
 */
@Validated
@RestController
@RequestMapping("/v1")
public class WhiteListController extends BaseController {


    /**
     * Token工具
     */
    @Autowired
    private TokenUtil jwtTokenUtil;


    @GetMapping(value = "/region/{regionCode}/statistics")
    public ApiResponse regionStatistics(@PathVariable("regionCode") String regionCode){
        ApiResponse response = ApiResponse.getInstances();

        return response.success().setResult("");
    }

}
