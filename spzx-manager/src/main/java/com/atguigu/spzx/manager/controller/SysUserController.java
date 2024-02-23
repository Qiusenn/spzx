package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.SysUserService;
import com.atguigu.spzx.model.dto.system.SysUserDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin/system/sysUser")
@AllArgsConstructor
public class SysUserController {

    private SysUserService sysUserService;

    /**
     *
     * 用户条件分页查询
     * @param sysUserDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/findByPage/{pageNum}/{pageSize}")
    public Result findByPage(SysUserDto sysUserDto ,
                                                @PathVariable(value = "pageNum") Integer pageNum ,
                                                @PathVariable(value = "pageSize") Integer pageSize) {
        PageInfo<SysUser> pageInfo = sysUserService.findByPage(sysUserDto , pageNum , pageSize) ;
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    @PostMapping(value = "/saveSysUser")
    public Result saveSysUser(@RequestBody SysUser sysUser) {
        sysUserService.saveSysUser(sysUser) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    @PutMapping(value = "/updateSysUser")
    public Result updateSysUser(@RequestBody SysUser sysUser) {
        sysUserService.updateSysUser(sysUser) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @DeleteMapping(value = "/deleteById/{userId}")
    public Result deleteById(@PathVariable(value = "userId") Long userId) {
        sysUserService.deleteById(userId) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
}
