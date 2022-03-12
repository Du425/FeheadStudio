package com.du.feheadstudio.pojo;

import lombok.Data;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/7 22:03
 */
@Data
public class ArticleSearchInfo {
    private String userId;
    private Integer year;
    private Integer month;
    /**
     * 专栏名
     */
    private String columnName;
    /**
     * 可能的标题
     */
    private String titleAbstruct;
}
