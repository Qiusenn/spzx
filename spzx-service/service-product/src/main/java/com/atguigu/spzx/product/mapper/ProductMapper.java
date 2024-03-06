package com.atguigu.spzx.product.mapper;

import com.atguigu.spzx.model.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    Product getById(Long productId);
}
