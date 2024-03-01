package com.atguigu.spzx.manager.service.impl;

import com.atguigu.spzx.manager.mapper.ProductUnitMapper;
import com.atguigu.spzx.manager.service.ProductUnitService;
import com.atguigu.spzx.model.entity.base.ProductUnit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductUnitServiceImpl implements ProductUnitService {

    private ProductUnitMapper productUnitMapper;
    @Override
    public List<ProductUnit> findAll() {
        return productUnitMapper.findAll() ;
    }
}
