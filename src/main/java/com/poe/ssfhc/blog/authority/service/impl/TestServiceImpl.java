package com.poe.ssfhc.blog.authority.service.impl;

import com.poe.ssfhc.blog.authority.dao.TestDao;
import com.poe.ssfhc.blog.authority.domain.TestEntity;
import com.poe.ssfhc.blog.authority.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: TestServiceImpl
 * @Description: TODO
 * @Author: Vicne
 * @Date: 2020/1/16 11:21
 * @Version: v1.0
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestDao testDao;
    @Override
    public List<TestEntity> queryAllDate() {
        return testDao.selectAllDate();
    }
}
