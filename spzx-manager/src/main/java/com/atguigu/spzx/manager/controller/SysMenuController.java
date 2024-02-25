package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.SysMenuService;
import com.atguigu.spzx.model.entity.system.SysMenu;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/admin/system/sysMenu")
@AllArgsConstructor
public class SysMenuController {

    private SysMenuService sysMenuService;

    /**
     * 查询菜单
     * @return
     */
    @GetMapping("/findNodes")
    public Result<List<SysMenu>> findNodes() {
        List<SysMenu> list = sysMenuService.findNodes();
        return Result.build(list , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 修改菜单
     * @param sysMenu
     * @return
     */
    @PutMapping("/updateById")
    public Result updateById(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateById(sysMenu);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @DeleteMapping("/removeById/{id}")
    public Result removeById(@PathVariable Long id) {
        sysMenuService.removeById(id);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

}
