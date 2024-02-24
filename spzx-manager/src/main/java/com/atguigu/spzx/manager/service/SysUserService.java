package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.AssginRoleDto;
import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.dto.system.SysUserDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.system.LoginVo;
import com.github.pagehelper.PageInfo;

public interface SysUserService {
    // 用户登录
    LoginVo login(LoginDto loginDto);

    // 获取用户信息
    SysUser getUserInfo(String token);

    // 用户退出
    void logout(String token);

    /**
     *
     * 用户条件分页查询
     * @param sysUserDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    void saveSysUser(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    void updateSysUser(SysUser sysUser);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    void deleteById(Long userId);

    /**
     * 分配用户
     * @param assginRoleDto
     * @return
     */
    void doAssign(AssginRoleDto assginRoleDto);
}
