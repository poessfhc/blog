package com.poe.ssfhc.blog.authority.service.impl;

import com.poe.ssfhc.blog.authority.dao.UserMapper;
import com.poe.ssfhc.blog.authority.domain.User;
import com.poe.ssfhc.blog.authority.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: Vicne
 * @Date: 2020/1/17 15:21
 * @Version: v1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }
}
