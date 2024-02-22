package com.atguigu.spzx.manager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.atguigu.spzx.common.exception.GuiguException;
import com.atguigu.spzx.manager.mapper.SysUserMapper;
import com.atguigu.spzx.manager.service.SysUserService;
import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.system.LoginVo;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private SysUserMapper sysUserMapper;

    private RedisTemplate<String, String> redisTemplate;

    // 用户登录
    @Override
    public LoginVo login(LoginDto loginDto) {

        // 验证码对比
        String captcha = loginDto.getCaptcha();
        String key = loginDto.getCodeKey();
        String redisCodeValue = redisTemplate.opsForValue().get("user:login:validatecode:" + key);
        if(StrUtil.isEmpty(redisCodeValue) || !StrUtil.equalsIgnoreCase(captcha, redisCodeValue)){
            throw new GuiguException(ResultCodeEnum.VALIDATECODE_ERROR);
        }

        redisTemplate.delete("user:login:validatecode:" + key);

        String userName = loginDto.getUserName();
        SysUser sysUser = sysUserMapper.selectUserInfoByUserName(userName);
        if(sysUser == null) {
        // throw new RuntimeException("用户名不存在");
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);
        }
        String database_password = sysUser.getPassword();
        String input_password = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());
        if(!database_password.equals(input_password)){
        // throw new RuntimeException("密码错误");
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);
        }

        String token = UUID.randomUUID().toString().replaceAll("-" , "");
        redisTemplate.opsForValue()
                .set("user:login:" + token,
                        JSON.toJSONString(sysUser),
                        7,
                        TimeUnit.DAYS);
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        return loginVo;
    }

    // 获取用户信息
    @Override
    public SysUser getUserInfo(String token) {
        String userInfoJson = redisTemplate.opsForValue().get("user:login:" + token);
        return JSON.parseObject(userInfoJson, SysUser.class);
    }

    // 用户退出
    @Override
    public void logout(String token) {
        redisTemplate.delete("user:login:" + token);
    }
}
