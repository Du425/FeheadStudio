package com.du.feheadstudio.mapper;

import com.du.feheadstudio.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 获取文章总数
     *
     * @param userId
     * @return
     */
    @Select("select article_num from user where user_id=#{userId} ")
    Integer getArticleMum(String userId);

    /**
     * 返回用户昵称
     *
     * @param userId
     * @return
     */
    @Select("select nick_name from user where userId=#{userId}")
    String getUserNickName(String userId);

    /**
     * 更新文章数
     *
     * @param userId
     * @param articleNum
     * @return
     */
    @Update("update user set article_num=#{articleNum} where user_id=#{userId}")
    Integer updateArticleNum(String userId, Integer articleNum);

}
