package com.atguigu.spzx.manager.service.impl;

import com.atguigu.spzx.manager.mapper.SysRoleMapper;
import com.atguigu.spzx.manager.service.SysRoleService;
import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SysRoleServiceImpl implements SysRoleService {

    private SysRoleMapper sysRoleMapper;

    /**
     * 角色列表方法
     * @param current     当前页
     * @param limit       每页显示记录数
     * @param sysRoleDto  条件角色名称对象
     * @return
     */
    @Override
    public PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer current, Integer limit) {
        PageHelper.startPage(current, limit);
        List<SysRole> list = sysRoleMapper.findByPage(sysRoleDto.getRoleName());
        PageInfo<SysRole> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }

    /**
     * 添加用户
     * @param sysRole
     * @return
     */
    @Override
    public void saveSysRole(SysRole sysRole) {
        sysRoleMapper.saveSysRole(sysRole);
    }

    /**
     * 修改用户
     * @param sysRole
     */
    @Override
    public void updateSysRole(SysRole sysRole) {
        sysRoleMapper.updateSysRole(sysRole);
    }

    /**
     * 删除用户
     * @param roleId
     */
    @Override
    public void deleteById(Long roleId) {
        sysRoleMapper.deleteById(roleId);
    }
}
