package com.poe.ssfhc.blog.article.service.impl;

import com.poe.ssfhc.blog.article.dao.ArticleHistoryMapper;
import com.poe.ssfhc.blog.article.domain.ArticleHistory;
import com.poe.ssfhc.blog.article.service.ArticleHistoryService;
import com.poe.ssfhc.blog.article.util.UUIDGenerator;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName:
 * @Description: TODO
 * @Author: 23974
 * @Date: 2020/1/17 17:23
 * @Version: v1.0
 */
@Service
public class ArticleHistoryServiceImpl implements ArticleHistoryService{
    @Autowired
    ArticleHistoryMapper articleHistoryMapper;
    @Override
    public String addArticle(String json) {
        JSONObject object = JSONObject.fromObject(json);
        ArticleHistory articleHistory = new ArticleHistory();

        JSONObject jsonResponse = new JSONObject();
        if (object.get("useruuid")==null||"".equals(object.get("useruuid"))){
            jsonResponse.put("msg","请登录");
            return jsonResponse.toString();
        }else {
            articleHistory.setCreateArticleTime(new Date());
            articleHistory.setUserUuid(object.get("useruuid").toString());
            articleHistory.setArticleDescription(object.get("article").toString());
            articleHistory.setArticleUuid(UUIDGenerator.getUUID());
            articleHistory.setLastUpdateTime(new Date());
            articleHistoryMapper.insertSelective(articleHistory);
        }
        jsonResponse.put("msg","插入成功");
        return jsonResponse.toString();
    }

}
