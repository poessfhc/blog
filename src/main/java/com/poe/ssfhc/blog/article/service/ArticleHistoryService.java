package com.poe.ssfhc.blog.article.service;


/**
 * @ClassName:
 * @Description: TODO
 * @Author: honghao
 * @Date: 2020/1/17 17:22
 * @Version: v1.0
 */
public interface ArticleHistoryService {
    String addArticle(String json);
    String deleteArticle(String json);
    String updateArticle(String json);
    String showArticle(String json);
}
