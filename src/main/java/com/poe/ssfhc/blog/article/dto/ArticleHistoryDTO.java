package com.poe.ssfhc.blog.article.dto;

import java.util.Date;

/**
 * @ClassName:
 * @Description: TODO
 * @Author: honghao
 * @Date: 2020/1/20 17:53
 * @Version: v1.0
 */
public class ArticleHistoryDTO {
    private String createArticleTime;
    private String articleTitle;
    private String articleUuid;

    public String getArticleUuid() {
        return articleUuid;
    }

    public void setArticleUuid(String articleUuid) {
        this.articleUuid = articleUuid;
    }


    public String getCreateArticleTime() {
        return createArticleTime;
    }

    public void setCreateArticleTime(String createArticleTime) {
        this.createArticleTime = createArticleTime;
    }


    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
}
