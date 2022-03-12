package com.du.feheadstudio.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.du.feheadstudio.entity.Article;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
    /**
     * 返回文章对应的用户id
     * @param articleId
     * @return 用户id
     */
    @Select("select user_id from article where article_id=#{articleId}")
    String getUserId(String articleId);


    /**
     * 浏览量喜加一
     * @param articleId
     * @return
     */
    @Update("update article set view_num=view_num+1 where article_id=#{articleId}")
    Integer addOneViewNum(String articleId);
}
