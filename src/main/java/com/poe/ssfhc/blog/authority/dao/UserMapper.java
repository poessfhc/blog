package com.poe.ssfhc.blog.authority.dao;

import com.poe.ssfhc.blog.authority.domain.Role;
import com.poe.ssfhc.blog.authority.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByUsername(String username);

    User login(String username);

    List<String> getRolesByName(String username);

    List<String> getPermissionsByUsername(List<String> roleName);
}