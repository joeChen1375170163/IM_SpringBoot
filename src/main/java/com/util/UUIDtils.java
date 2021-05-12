package com.util;

import java.util.UUID;

/**
 * TODO
 * 一般工具类
 * @author cxh
 * @date 2021/5/7 14:24
 */
public class UUIDtils {

    /**
     * 获取 主键
     *
     * @return
     */
    public static String uuId () {
        return UUID.randomUUID().toString().replaceAll("-", "").trim();
    }

    /**
     * 获取编码
     * @return
     */
    public static String getCode ()
    {
        return uuId().substring(3)+System.currentTimeMillis();
    }
}
