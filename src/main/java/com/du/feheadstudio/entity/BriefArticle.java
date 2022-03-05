package com.du.feheadstudio.entity;

import lombok.Data;

/**
 * @Author DU425
 * @Date 2022/3/5 14:49
 * @Version 1.0
 * @Description
 */
@Data
public class BriefArticle {

    private String articleId;

    private Integer year;

    private Integer month;

    private String columnId;

    private String titleAbstract;
}
