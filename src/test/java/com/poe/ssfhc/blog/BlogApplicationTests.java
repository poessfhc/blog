package com.poe.ssfhc.blog;

import com.poe.ssfhc.blog.dao.TestDao;
import com.poe.ssfhc.blog.domain.TestEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private TestDao testDao;

    @Test
    void contextLoads() {
        List<TestEntity> testEntities = testDao.selectAllDate();
        System.out.println(testEntities);
    }

}
