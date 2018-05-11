package com.casic.sys.config;


import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by huguoju on 2016/12/28.
 * 配置mybatis
 */
@Configuration
@ConditionalOnClass({EnableTransactionManagement.class})
@Import({ DataBaseConfiguration.class})
@MapperScan(basePackages={"com.casic..*.mapper"})
public class MybatisConfiguration {
    @Value("${datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Value("${datasource.readSize}")
    private String dataSourceSize;
    @Resource(name = "writeDataSource")
    private DataSource dataSource;
    @Resource(name = "readDataSources")
    private List<DataSource> readDataSources;

    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(roundRobinDataSouceProxy());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.casic..*.entity");
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*/*.xml"));
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }
    /**
     * 有多少个数据源就要配置多少个bean
     * @return
     */
    @Bean
    public AbstractRoutingDataSource roundRobinDataSouceProxy() {
        int size = Integer.parseInt(dataSourceSize);
        MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource(size);
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        // DataSource writeDataSource = SpringContextHolder.getBean("writeDataSource");
        // 写
        targetDataSources.put(DataSourceType.write.getType(),dataSource);
        // targetDataSources.put(DataSourceType.read.getType(),readDataSource);
        //多个读数据库时
        for (int i = 0; i < size; i++) {
            targetDataSources.put(i, readDataSources.get(i));
        }
        proxy.setDefaultTargetDataSource(dataSource);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
