package com.poe.ssfhc.blog.authority.controller;

import com.poe.ssfhc.blog.authority.domain.TestEntity;
import com.poe.ssfhc.blog.authority.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: Vicne
 * @Date: 2020/1/16 11:19
 * @Version: v1.0
 */
@RestController
@Api(value = "测试类")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping
    @ApiOperation(value = "测试接口")
    public List<TestEntity> queryAllDate() {
        return testService.queryAllDate();
    }
}
