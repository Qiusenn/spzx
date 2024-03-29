package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.common.log.annotation.Log;
import com.atguigu.spzx.manager.service.SysRoleService;
import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/admin/system/sysRole")
public class SysRoleController {

    private SysRoleService sysRoleService;

    /**
     * 角色列表方法
     * @param current     当前页码
     * @param limit       每页显示记录数
     * @param sysRoleDto  条件角色名称对象
     * @return
     */
    @PostMapping("/findByPage/{current}/{limit}")
    public Result findByPage(@PathVariable("current") Integer current,
                             @PathVariable("limit") Integer limit,
                             @RequestBody SysRoleDto sysRoleDto) {
        // pagrHelper插件实现分页
        PageInfo<SysRole> pageInfo = sysRoleService.findByPage(sysRoleDto, current, limit);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }

    /**
     * 添加用户
     * @param sysRole
     * @return
     */
    @Log(title = "角色添加",businessType = 0) //添加Log注解，设置属性
    @PostMapping(value = "/saveSysRole")
    public Result saveSysRole(@RequestBody SysRole sysRole) {
        sysRoleService.saveSysRole(sysRole) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 修改用户
     * @param sysRole
     * @return
     */
    @PutMapping(value = "/updateSysRole")
    public Result updateSysRole(@RequestBody SysRole sysRole) {
        sysRoleService.updateSysRole(sysRole) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 逻辑删除用户【数据库设置is_delete=1】
     * @param roleId
     * @return
     */
    @DeleteMapping(value = "/deleteById/{roleId}")
    public Result deleteById(@PathVariable(value = "roleId") Long roleId) {
        sysRoleService.deleteById(roleId) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 查询所有角色以及根据用户id查询对应的角色封装返回
     * @param userId
     * @return
     */
    @GetMapping(value = "/findAllRoles/{userId}")
    public Result<Map<String , Object>> findAllRoles(@PathVariable(value = "userId") Long userId) {
        Map<String, Object> resultMap = sysRoleService.findAllRoles(userId);
        return Result.build(resultMap , ResultCodeEnum.SUCCESS)  ;
    }
}
