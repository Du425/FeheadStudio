package com.du.feheadstudio.entity;

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
    private String articleId;
    private String title;

    private String alreadyPublish;
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
    /**
     * 文章封面
     */
    private String coverImgId;
    /**
     * 作者昵称
     */
    private String nickname;
    /**
     * 文章摘要
     */
    private String abstracts;
}
