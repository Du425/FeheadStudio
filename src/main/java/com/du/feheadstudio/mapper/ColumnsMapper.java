package com.du.feheadstudio.mapper;

import com.du.feheadstudio.entity.Columns;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
public interface ColumnsMapper extends BaseMapper<Columns> {

    @Select("select total_article_num from columns where user_id = #{userId}")
    Integer getTotalArticleNum(String userId);

    @Update("update columns set total_article_num =#{totalArticleNum} where uer_id =#{userId}")
    void updateColumnsNum(@Param("totalArticleNum") Integer totalArticleNum, @Param("userId") String userId);

}
