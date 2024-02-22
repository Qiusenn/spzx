package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.system.LoginVo;

public interface SysUserService {
    // 用户登录
    LoginVo login(LoginDto loginDto);

    // 获取用户信息
    SysUser getUserInfo(String token);

    // 用户退出
    void logout(String token);
}
