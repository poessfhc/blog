package com.poe.ssfhc.blog.article.service.impl;

import com.poe.ssfhc.blog.article.dao.ArticleHistoryMapper;
import com.poe.ssfhc.blog.article.domain.ArticleHistory;
import com.poe.ssfhc.blog.article.dto.ArticleHistoryDTO;
import com.poe.ssfhc.blog.article.service.ArticleHistoryService;
import com.poe.ssfhc.blog.article.utils.UUIDGenerator;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName:
 * @Description: TODO
 * @Author: 23974
 * @Date: 2020/1/17 17:23
 * @Version: v1.0
 */
@Service
public class ArticleHistoryServiceImpl implements ArticleHistoryService {
    @Autowired
    ArticleHistoryMapper articleHistoryMapper;

    @Override
    public String addArticle(String json) {
        JSONObject object = JSONObject.fromObject(json);
        ArticleHistory articleHistory = new ArticleHistory();

        JSONObject jsonResponse = new JSONObject();
        if (object.get("useruuid") == null || "".equals(object.get("useruuid"))) {
            jsonResponse.put("msg", "请登录");
            return jsonResponse.toString();
        }
        articleHistory.setCreateArticleTime(new Date());
        articleHistory.setUserUuid(object.get("useruuid").toString());
        articleHistory.setArticleDescription(object.get("article").toString());
        articleHistory.setArticleTitle(object.get("articleTitle").toString());
        articleHistory.setArticleUuid(UUIDGenerator.getUUID());
        articleHistory.setLastUpdateTime(new Date());
        System.out.println(articleHistory.getArticleTitle()+"######################");
        articleHistoryMapper.insertSelective(articleHistory);
        jsonResponse.put("msg", "插入成功");
        return jsonResponse.toString();
    }

    @Override
    public String deleteArticle(String json) {
        JSONObject object = JSONObject.fromObject(json);
        ArticleHistory articleHistory = new ArticleHistory();

        JSONObject jsonResponse = new JSONObject();
        if (object.get("useruuid") == null || "".equals(object.get("useruuid"))) {
            jsonResponse.put("msg", "请登录");
            return jsonResponse.toString();
        }
        if (object.get("articleuuid") == null || "".equals(object.get("articleuuid"))) {
            jsonResponse.put("msg", "请登录");
            return jsonResponse.toString();
        }
        articleHistory.setLastUpdateTime(new Date());
        articleHistory.setDeleteTime(new Date());
        articleHistory.setArticleUuid(object.get("articleuuid").toString());
        articleHistoryMapper.deleteByArticleUuid(articleHistory);
        jsonResponse.put("msg", "删除成功");
        return jsonResponse.toString();
    }

    @Override
    public String updateArticle(String json) {
        JSONObject object = JSONObject.fromObject(json);
        ArticleHistory articleHistory = new ArticleHistory();

        JSONObject jsonResponse = new JSONObject();
        if (object.get("useruuid") == null || "".equals(object.get("useruuid"))) {
            jsonResponse.put("msg", "请登录");
            return jsonResponse.toString();
        }
        if (object.get("articleuuid") == null || "".equals(object.get("articleuuid"))) {
            jsonResponse.put("msg", "请登录");
            return jsonResponse.toString();
        }
        articleHistory.setLastUpdateTime(new Date());
        articleHistory.setArticleUuid(object.get("articleuuid").toString());
        articleHistory.setArticleTitle(object.get("articleTitle").toString());
        articleHistory.setArticleDescription(object.get("article").toString());
        articleHistoryMapper.updateByArticleUuid(articleHistory);
        jsonResponse.put("msg", "更新成功");
        return jsonResponse.toString();
    }
    @Override
    public String showArticle(String json){
        JSONObject object = JSONObject.fromObject(json);
        JSONObject jsonResponse = new JSONObject();

        List<ArticleHistoryDTO> list;
        String userUuid = object.getString("useruuid");
        int currentPage = (int) object.get("currentPage");//当前页数
        int pageSize = (int) object.get("pageSize");//每页条数
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("useruuid",userUuid);
        map.put("start",((currentPage-1)*pageSize));  //从第几条开始
        map.put("end",pageSize);
        int total = articleHistoryMapper.countArticle(userUuid);
        list = articleHistoryMapper.selectByUserUuid(map);

        jsonResponse.put("useruuid",userUuid);
        jsonResponse.put("currentPage",currentPage);
        jsonResponse.put("pageSize",list.size());
        jsonResponse.put("total",total);
        jsonResponse.put("list",list);
        return jsonResponse.toString();
    }

}
