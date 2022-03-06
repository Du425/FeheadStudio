package com.du.feheadstudio;

import com.du.feheadstudio.mapper.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FeheadStudioApplicationTests {

    @Autowired
    ArticleMapper articleMapper;
    @Test
    void contextLoads() {
        articleMapper.selectList(null);
    }

}
