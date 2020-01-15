package com.poe.ssfhc.blog.dao;

import com.poe.ssfhc.blog.domain.TestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDao {
    List<TestEntity> selectAllDate();
}
