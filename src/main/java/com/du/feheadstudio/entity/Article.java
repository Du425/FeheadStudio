package com.du.FeheadStudio.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@ApiModel(value = "Article对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private String articleId;

    private String userId;

    private String title;

    private String content;

    @ApiModelProperty("图片url")
    private String cover;

    private String abstract;

    private String label;

    private String columnId;

    private Integer publishMethod;

    private Integer isPublished;

    private LocalDateTime publishTime;

    private Integer viewNum;


    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAbstract() {
        return abstract;
    }

    public void setAbstract(String abstract) {
        this.abstract = abstract;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public Integer getPublishMethod() {
        return publishMethod;
    }

    public void setPublishMethod(Integer publishMethod) {
        this.publishMethod = publishMethod;
    }

    public Integer getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    @Override
    public String toString() {
        return "Article{" +
        "articleId=" + articleId +
        ", userId=" + userId +
        ", title=" + title +
        ", content=" + content +
        ", cover=" + cover +
        ", abstract=" + abstract +
        ", label=" + label +
        ", columnId=" + columnId +
        ", publishMethod=" + publishMethod +
        ", isPublished=" + isPublished +
        ", publishTime=" + publishTime +
        ", viewNum=" + viewNum +
        "}";
    }
}
