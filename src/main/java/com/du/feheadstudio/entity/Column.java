package com.du.FeheadStudio.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Du425
 * @since 2022-03-04
 */
@ApiModel(value = "Column对象", description = "")
public class Column implements Serializable {

    private static final long serialVersionUID = 1L;

    private String columnId;

    private String columnName;

    private String columnCover;

    private Integer totalArticleNum;


    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnCover() {
        return columnCover;
    }

    public void setColumnCover(String columnCover) {
        this.columnCover = columnCover;
    }

    public Integer getTotalArticleNum() {
        return totalArticleNum;
    }

    public void setTotalArticleNum(Integer totalArticleNum) {
        this.totalArticleNum = totalArticleNum;
    }

    @Override
    public String toString() {
        return "Column{" +
        "columnId=" + columnId +
        ", columnName=" + columnName +
        ", columnCover=" + columnCover +
        ", totalArticleNum=" + totalArticleNum +
        "}";
    }
}
