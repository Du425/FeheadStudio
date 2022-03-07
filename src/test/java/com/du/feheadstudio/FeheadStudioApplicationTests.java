package com.du.feheadstudio;

import cn.hutool.core.io.FileUtil;
import com.du.feheadstudio.mapper.ArticleMapper;
import com.du.feheadstudio.pojo.Image;
import com.du.feheadstudio.service.ImageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class FeheadStudioApplicationTests {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ImageService imageService;
    @Test
    void contextLoads() {
        Image image =new Image();
        image.setFile(FileUtil.readBytes(new File("D:\\IDEACode\\FeheadStudio\\src\\main\\resources\\static\\0.png")));
        image.setId("0");
        imageService.saveImage(image);

        image.setFile(FileUtil.readBytes(new File("D:/IDEACode/FeheadStudio/src/main/resources/static/1.jpg")));
        image.setId("1");
        imageService.saveImage(image);

        System.out.println(image.getId());
    }

}
