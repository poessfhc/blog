package com.poe.ssfhc.blog.authority.service;

import com.poe.ssfhc.blog.authority.domain.User;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/1/17 15:21
 * @Version: v1.0
 */
public interface UserService {
    User selectByPrimaryKey(String id);
}
