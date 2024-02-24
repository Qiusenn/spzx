package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface SysRoleService {
    /**
     * 角色列表方法
     * @param current     当前页
     * @param limit       每页显示记录数
     * @param sysRoleDto  条件角色名称对象
     * @return
     */
    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer current, Integer limit);

    /**
     * 添加用户
     * @param sysRole
     * @return
     */
    void saveSysRole(SysRole sysRole);

    /**
     * 修改用户
     * @param sysRole
     */
    void updateSysRole(SysRole sysRole);

    /**
     * 逻辑删除用户【数据库设置is_delete=1】
     * @param roleId
     * @return
     */
    void deleteById(Long roleId);

    /**
     * 查询所有角色以及根据用户id查询对应的角色封装返回
     * @param userId
     * @return
     */
    Map<String, Object> findAllRoles(Long userId);
}
