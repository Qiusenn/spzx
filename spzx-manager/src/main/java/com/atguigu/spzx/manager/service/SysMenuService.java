package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.entity.system.SysMenu;

import java.util.List;

public interface SysMenuService {

    /**
     * 查找菜单
     * @return
     */
    List<SysMenu> findNodes();

    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    void save(SysMenu sysMenu);

    /**
     * 修改菜单
     * @param sysMenu
     * @return
     */
    void updateById(SysMenu sysMenu);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    void removeById(Long id);
}
