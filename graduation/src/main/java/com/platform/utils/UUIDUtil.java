package com.platform.utils;

import java.util.UUID;

/**
 * @description:UUID工具类
 * @author: Air
 * @date: 2019-03-03 16:54
 */
public class UUIDUtil {

    /**
     * 带-的UUID
     *
     * @return 36位的字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 去掉-的UUID
     *
     * @return 32位的字符串
     */
    public static String getUUID2() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
