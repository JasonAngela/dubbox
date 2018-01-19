package cn.bjd.platform.admin.web.controller;

import cn.bjd.platform.admin.web.common.controller.BaseController;
import cn.bjd.platform.system.api.entity.SysDepartment;
import cn.bjd.platform.system.api.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Sys department controller.
 *
 * @author huqilang
 */
@Validated
@RestController
@RequestMapping("/sys/dept")
public class SysDepartmentController  extends BaseController {

    /**
     * 系统部门服务
     */
    @Autowired
    private ISystemService systemService;

    /**
     * Save menu sys department.
     *
     * @param dept the dept
     * @return the sys dept
     */
    @PreAuthorize("hasAuthority('sys:dept:edit')")
    @PostMapping(value = "")
    public SysDepartment saveDepartment(@Valid @RequestBody SysDepartment dept){
        return systemService.saveDept(dept);
    }

    /**
     * Gets dept.
     *
     * @param deptId the dept id
     * @return the dept
     */
    @PreAuthorize("hasAuthority('sys:dept:view')")
    @GetMapping(value = "/{deptId}")
    public SysDepartment getDept(@PathVariable("deptId") String deptId){
        return systemService.getByDeptId(deptId);
    }


    /**
     * Delete dept response entity.
     *
     * @param deptId the menu id
     * @return the response entity
     */
    @PreAuthorize("hasAuthority('sys:dept:edit')")
    @DeleteMapping(value = "/{deptId}")
    public ResponseEntity deleteDept(@PathVariable("deptId") String deptId){
        systemService.deleteDeptById(deptId);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Gets dept list.
     *
     * @return the dept list
     */
    @PreAuthorize("hasAuthority('sys:dept:view')")
    @GetMapping(value = "/list")
    public List<SysDepartment> getDeptList(){
        return systemService.findAllDepts();
    }

    /**
     * Gets dept list enable.
     *
     * @return the dept list enable
     */
    @PreAuthorize("hasAuthority('sys:dept:view')")
    @GetMapping(value = "/enable")
    public List<SysDepartment> getDeptListEnable(){
        return systemService.findAllEnable();
    }
}