package com.poe.ssfhc.blog.authority.controller;

import com.poe.ssfhc.blog.authority.domain.User;
import com.poe.ssfhc.blog.authority.service.UserService;
import com.poe.ssfhc.blog.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @ClassName: LoginController
 * @Description: TODO 还需进行修改
 * @Author: Vince
 * @Date: 2020/1/17 15:37
 * @Version: v1.0
 */
@RestController
@RequestMapping("/user")
@Api(value = "简单登录测试")
public class LoginController {
    @ApiOperation(value = "简单登录测试接口")
    @PostMapping("/login")
    public JsonResult login(@RequestParam String username, @RequestParam String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        SecurityUtils.getSubject().login(token);
        //设置session时间
        //SecurityUtils.getSubject().getSession().setTimeout(1000*60*30);
        //token信息
        Subject subject = SecurityUtils.getSubject();
        Serializable tokenId = subject.getSession().getId();
        return new JsonResult(tokenId);
    }
    @GetMapping("/test")
    public String test(){
        return "111";
    }

}
