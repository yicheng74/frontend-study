package com.exampleforsb.demo.controller;

import com.exampleforsb.demo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String name, String age, MultipartFile file) throws IOException {
        log.info("接收上传: name={}, age={}, 文件名={}", name, age, file == null ? null : file.getOriginalFilename());
        if (file == null || file.isEmpty()) {
            return Result.error("请选择要上传的文件");
        }
        String originalFilename = file.getOriginalFilename();
        String ext = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        String newFilename = UUID.randomUUID() + ext;
        File dir = new File("upload");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        file.transferTo(new File(dir, newFilename));
        return Result.success("/files/" + newFilename);
    }
}
