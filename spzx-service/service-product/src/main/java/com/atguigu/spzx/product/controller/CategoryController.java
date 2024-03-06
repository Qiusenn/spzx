package com.atguigu.spzx.product.controller;

import com.atguigu.spzx.model.entity.product.Category;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "分类接口管理")
@RestController
@RequestMapping(value="/api/product/category")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @Operation(summary = "获取分类树形数据")
    @Cacheable(value = "category" , key = "'all'")
    @GetMapping("/findCategoryTree")
    public Result<List<Category>> findCategoryTree(){
        List<Category> list = categoryService.findCategoryTree();
        return Result.build(list,  ResultCodeEnum.SUCCESS);
    }

}
