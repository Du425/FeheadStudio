package com.du.feheadstudio.controller;

import com.du.feheadstudio.pojo.Image;
import com.du.feheadstudio.response.CommonResult;
import com.du.feheadstudio.service.impl.ImageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/6 16:40
 */
@RestController
@RequestMapping("/api/v1/image")
@Slf4j
public class ImageController {
    ImageServiceImpl imageService;
    private static String URL_PATH="localhost:8888/api/v1/image/";

    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public CommonResult uploadImage(MultipartFile image) {
        Image save = new Image();
        try {
            save.setFile(image.getBytes());
        } catch (IOException e) {
            return CommonResult.failed("io异常");
        }
        imageService.saveImage(save);
        Map<String,Object> data=new HashMap<>(1);
        data.put("imageId",URL_PATH+save.getId());
        return CommonResult.success(data);
    }
    @GetMapping("/{imageId}")
    public void getImage(HttpServletResponse response, @PathVariable String imageId) {
        response.setContentType("image/jpg");
        Image image = imageService.getImageById(imageId);
        try {
            response.getOutputStream().write(image.getFile());
        } catch (IOException e) {
            log.error(imageId + ":" + e.getMessage());
            e.printStackTrace();
        }
    }
}
