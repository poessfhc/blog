package com.poe.ssfhc.blog.authority.util;

import java.util.UUID;

/**
 * @ClassName:
 * @Description: TODO
 * @Author: honghao
 * @Date: 2020/1/17 19:00
 * @Version: v1.0
 */
public class UUIDGenerator {
    /**
     *
     * @return 返回去掉-的UUID
     */
    public static String getUUID(){
        UUID articleUuid = UUID.randomUUID();
        String str = articleUuid.toString();
        String temp =str.substring(0,8)+str.substring(9,13)+str.substring(14,18)+str.substring(19,23)+str.substring(24);
        return temp;
    }
}
