package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.AssginMenuDto;

import java.util.Map;

public interface SysRoleMenuService {
    Map<String, Object> findSysRoleMenuByRoleId(Long roleId);

    /**
     * 保存菜单数据
     * @param assginMenuDto
     */
    void doAssign(AssginMenuDto assginMenuDto);
}
