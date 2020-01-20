package com.poe.ssfhc.blog.article.dao;

import com.poe.ssfhc.blog.article.domain.ArticleHistory;
import com.poe.ssfhc.blog.article.dto.ArticleHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleHistoryMapper {
    int deleteByArticleUuid(ArticleHistory record);

    int insert(ArticleHistory record);

    int insertSelective(ArticleHistory record);

    ArticleHistory selectByPrimaryKey(Integer id);

    int updateByArticleUuid(ArticleHistory record);

    int updateByPrimaryKey(ArticleHistory record);

    List<ArticleHistoryDTO> selectByUserUuid(Map<String,Object> map);

    int countArticle(String userUuid);
}