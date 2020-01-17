package com.poe.ssfhc.blog.article.domain;

import java.util.Date;

public class ArticleHistory {
    private Integer id;

    private String userUuid;

    private String articleUuid;

    private Date createArticleTime;

    private Date lastUpdateTime;

    private Date deleteTime;

    private String articleDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public String getArticleUuid() {
        return articleUuid;
    }

    public void setArticleUuid(String articleUuid) {
        this.articleUuid = articleUuid == null ? null : articleUuid.trim();
    }

    public Date getCreateArticleTime() {
        return createArticleTime;
    }

    public void setCreateArticleTime(Date createArticleTime) {
        this.createArticleTime = createArticleTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription == null ? null : articleDescription.trim();
    }
}