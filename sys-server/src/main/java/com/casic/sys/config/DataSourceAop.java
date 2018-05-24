package com.casic.sys.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by huguoju on 2016/12/29.
 * 拦截设置本地线程变量
 */
@Aspect
@Component
public class DataSourceAop {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.casic..*.provider..*.get*(..)) || execution(* com.casic..*.provider..*.find*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        logger.debug("dataSource切换到：Read模式");
    }

    @Before("execution(* com.casic..*.provider..*.save*(..)) || execution(* com.casic..*.provider..*.edit*(..)) || execution(* com.casic..*.provider..*.delete*(..)) || execution(* com.casic..*.provider..*.remove*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        logger.debug("dataSource切换到：write");
    }

//    @Before("execution(* com.hitech.core.base.provider..*.find*(..)) || execution(* com.hitech.core.base.provider..*.get*(..))")
//    public void setBaseReadDataSourceType() {
//        DataSourceContextHolder.read();
//        logger.debug("base-dataSource切换到：Read模式");
//    }
//
//    @Before("execution(* com.hitech.core.base.provider..*.save*(..)) || execution(* com.hitech.core.base.provider..*.edit*(..)) || execution(* com.hitech.core.base.provider..*.delete*(..)) || execution(* com.hitech.core.base.provider..*.remove*(..))")
//    public void setBaseWriteDataSourceType() {
//        DataSourceContextHolder.write();
//        logger.debug("base-dataSource切换到：write");
//    }
}

