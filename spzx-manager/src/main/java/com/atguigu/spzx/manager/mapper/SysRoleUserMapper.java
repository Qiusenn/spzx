package com.atguigu.spzx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleUserMapper {
    List<Long> findSysUserRoleByUserId(Long userId);

    void deleteByUserId(Long userId);

    void doAssign(Long userId, Long roleId);
}
