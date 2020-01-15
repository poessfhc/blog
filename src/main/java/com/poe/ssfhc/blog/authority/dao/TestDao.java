package com.poe.ssfhc.blog.authority.dao;


import com.poe.ssfhc.blog.authority.domain.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TestDao {
    List<TestEntity> selectAllDate();
}
