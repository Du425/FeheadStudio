package com.du.feheadstudio.controller;

import com.du.feheadstudio.pojo.Image;
import com.du.feheadstudio.response.CommonResult;
import com.du.feheadstudio.service.impl.ImageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private static String URL_PATH = "http://192.168.52.1:8888//api/v1/image/";

    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }
    /**
     * 图片上传
     *
     * @param image
     * @return
     */
    @PostMapping("/upload")
    public CommonResult uploadImage(MultipartFile image) {
        Image save = new Image();
        try {
            save.setFile(image.getBytes());
        } catch (IOException e) {
            return CommonResult.failed("io异常");
        }
        imageService.saveImage(save);
        Map<String, Object> data = new HashMap<>(1);
        data.put("imageId", URL_PATH + save.getId());
        return CommonResult.success(data);
    }

    /**
     * 图片获取
     *
     * @param response
     * @param imageId
     */
    @GetMapping("/onload/{imageId}")
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

    @GetMapping("/rotation")
    public CommonResult getImageForRotation() {
        List<String> list = new ArrayList<>(3);
        list.add("https://img1.baidu.com/it/u=874859830,4128480885&fm=253&fmt=auto&app=120&f=JPEG?w=960&h=540");
        list.add("https://img0.baidu.com/it/u=216288347,2174882443&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500");
        list.add("https://img1.baidu.com/it/u=2955451002,3142132243&fm=253&fmt=auto&app=120&f=JPEG?w=1422&h=800");
        return CommonResult.ok(list);
    }

}
