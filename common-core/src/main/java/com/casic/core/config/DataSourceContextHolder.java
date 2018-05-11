package com.casic.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by huguoju on 2016/12/29.
 * 本地线程全局变量
 */
public class DataSourceContextHolder  {

    private final static Logger logger = LoggerFactory.getLogger(DataSourceContextHolder.class);

    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 读可能是多个库
     */
    public static void read() {

        local.set(DataSourceType.read.getType());
    }

    /**
     * 写只有一个库
     */
    public static void write() {
        logger.debug("设置write库");
        local.set(DataSourceType.write.getType());
    }

    public static String getJdbcType() {
        return local.get();
    }
}

