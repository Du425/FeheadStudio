package com.du.feheadstudio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class FeheadStudioApplicationTests {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

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
        String userId = "1234";
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        HashOperations<String, Object, Object> forHash = redisTemplate.opsForHash();
        String date = format.format(new Date());

        //存在就加一
        if (forHash.hasKey(userId, date)) {
            Integer integer = (Integer) forHash.get(userId, date);
            forHash.put(userId, date, ++integer);
        } else {
            forHash.put(userId, date, 1);
        }


    }

}
