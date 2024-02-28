package com.atguigu.spzx.manager.test;


import com.alibaba.excel.EasyExcel;
import com.atguigu.spzx.model.vo.product.CategoryExcelVo;

import java.util.List;

public class EasyExcelTest {
    public static void main(String[] args) {
        readDateToExcel();
    }

    public static void read() {

    }

    public static void write() {

    }

    //读取方法
    public static void readDateToExcel() {
        String fileName = "D://分类数据.xlsx" ;
        // 创建一个监听器对象
        ExcelListener<CategoryExcelVo> excelListener = new ExcelListener<>();
        EasyExcel.read(fileName, CategoryExcelVo.class, excelListener).sheet().doRead();         // 解析excel表格
        List<CategoryExcelVo> excelVoList = excelListener.getDatas();    //获取解析到的数据
        excelVoList.forEach(s -> System.out.println(s) );   // 进行遍历操作
    }
}
