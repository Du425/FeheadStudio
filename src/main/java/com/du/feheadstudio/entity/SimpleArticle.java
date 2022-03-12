package com.du.feheadstudio.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 返回的简略文章
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/7 22:10
 */
@Data
@TableName("article")
public class SimpleArticle {
    @TableId
    private String articleId;
    private String userId;
    private String title;
    private String alreadyPublished;
    /**
     * 文章浏览量
     */
    private Integer viewNum;
    /**
     * 文章发布时间
     */
    private Long publishTime;
    /**
     * 是否置顶
     */
    private Integer top;
    private Integer sort;
    /**
     * 文章封面
     */
    private String coverImgId;
    /**
     * 作者昵称
     */
    @TableField(exist = false)
    private String nickname;
    /**
     * 文章摘要
     */
    private String abstracts;


}
