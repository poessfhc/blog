package com.poe.ssfhc.blog.authority.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @Author: Vicne
 * @Date: 2020/1/17 15:37
 * @Version: v1.0
 */
@RestController
@Api(value = "简单登录测试")
public class LoginController {
    @ApiOperation(value = "简单登录测试接口")
    @PostMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password){
        Assert.notNull(username,"username不能为空");
        Assert.notNull(password,"password不能为空");
        UsernamePasswordToken upToken=new UsernamePasswordToken(username,password);
        Subject subject= SecurityUtils.getSubject();
        if(subject==null){
            throw new RuntimeException("登陆异常");
        }
        try{
            subject.login(upToken);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

}
