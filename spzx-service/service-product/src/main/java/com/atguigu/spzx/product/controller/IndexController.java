package com.atguigu.spzx.product.controller;

import com.atguigu.spzx.model.entity.product.Category;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.h5.IndexVo;
import com.atguigu.spzx.product.service.CategoryService;
import com.atguigu.spzx.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "首页接口管理")
@RestController
@AllArgsConstructor
@RequestMapping(value="/api/product/index")
public class IndexController {

    private CategoryService categoryService;

    private ProductService productService;

    @Operation(summary = "获取首页数据")
    @GetMapping
    public Result<IndexVo> findData(){
        List<Category> categoryList = categoryService.findOneCategory();
        List<ProductSku> productSkuList = productService.findProductSkuBySale();
        IndexVo indexVo = new IndexVo() ;
        indexVo.setCategoryList(categoryList);
        indexVo.setProductSkuList(productSkuList);
        return Result.build(indexVo , ResultCodeEnum.SUCCESS);
    }

}
