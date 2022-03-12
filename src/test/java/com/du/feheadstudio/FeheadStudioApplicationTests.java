package com.du.feheadstudio;

import com.du.feheadstudio.mapper.ArticleJumpLineMapper;
import com.du.feheadstudio.mapper.BriefArticleMapper;
import com.du.feheadstudio.mapper.SimpleArticleMapper;
import com.du.feheadstudio.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FeheadStudioApplicationTests {

    @Autowired
    ArticleJumpLineMapper articleJumpLineMapper;
    @Autowired
    BriefArticleMapper mapper;
    @Autowired
    SimpleArticleMapper simpleArticleMapper;
    @Autowired
    UserMapper userMapper;

    //    @Test
//    void contextLoads() {
//        Image image =new Image();
//        image.setFile(FileUtil.readBytes(new File("D:\\IDEACode\\FeheadStudio\\src\\main\\resources\\static\\0.png")));
//        image.setId("0");
//        imageService.saveImage(image);
//
//        image.setFile(FileUtil.readBytes(new File("D:/IDEACode/FeheadStudio/src/main/resources/static/1.jpg")));
//        image.setId("1");
//        imageService.saveImage(image);
//
//        System.out.println(image.getId());
//    }
    @Test
    void userTest() {
//        System.out.println(userMapper.getArticleMum("123"));
//        QueryWrapper<ArticleJumpLine> wrapper=new QueryWrapper<>();
//        wrapper.like("user_id","123");
//
//        System.out.println(articleJumpLineMapper.selectOne(wrapper));
//        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println(userMapper);
    }

}
