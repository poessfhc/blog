package com.poe.ssfhc.blog.authority.controller;

import com.poe.ssfhc.blog.authority.domain.ArticleHistory;
import com.poe.ssfhc.blog.authority.service.ArticleHistoryService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:
 * @Description: TODO
 * @Author: honghao
 * @Date: 2020/1/17 17:20
 * @Version: v1.0
 */
@RestController
public class ArticleController {
    @Autowired
    ArticleHistoryService articleHistoryService;

    /**
     * 添加文章
     * @param json_package
     */
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    public String addArticle(@RequestBody String json_package){
        String rep = articleHistoryService.addArticle(json_package);
        return jsonResponse(rep);
    }

    protected String jsonResponse(String str){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("head",str);
        return jsonObject.toString();
    }
}
