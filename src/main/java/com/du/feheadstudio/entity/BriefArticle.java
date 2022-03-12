package com.du.feheadstudio.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 搜索用的各字段
 * @Author DU425
 * @Date 2022/3/5 14:49
 * @Version 1.0
 * @Description
 */
@Data
@NoArgsConstructor
public class BriefArticle {
    @TableId(type = IdType.ASSIGN_ID)
    private String articleId;
    private String userId;
    private Integer year;
    private Integer month;
    private String columnId;

    private String titleAbstract;

    public BriefArticle(Integer year, Integer month, String columnId, String titleAbstract) {
        this.year = year;
        this.month = month;
        this.columnId = columnId;
        this.titleAbstract = titleAbstract;
    }
}
