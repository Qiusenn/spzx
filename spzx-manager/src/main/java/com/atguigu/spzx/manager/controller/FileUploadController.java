package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.FileUploadService;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/system")
@AllArgsConstructor
public class FileUploadController {

    private FileUploadService fileUploadService ;

    @PostMapping(value = "/fileUpload")
    public Result<String> fileUploadService(@RequestParam(value = "file") MultipartFile file) {
        String fileUrl = fileUploadService.fileUpload(file) ;
        return Result.build(fileUrl , ResultCodeEnum.SUCCESS) ;
    }
}
