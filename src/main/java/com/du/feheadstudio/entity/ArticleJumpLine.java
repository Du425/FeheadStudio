package com.du.feheadstudio.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用于行间换位
 * @author wrobby
 * @version 1.0
 * @date 2022/3/8 20:08
 */
@TableName("article")
@Data
public class ArticleJumpLine {
    @TableId
    private String articleId;
    private String userId;
    private Integer sort;
    private Integer top;
}
