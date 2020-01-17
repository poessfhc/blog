package com.poe.ssfhc.blog.article.dao;

import com.poe.ssfhc.blog.article.domain.ArticleHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleHistory record);

    int insertSelective(ArticleHistory record);

    ArticleHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleHistory record);

    int updateByPrimaryKey(ArticleHistory record);
}