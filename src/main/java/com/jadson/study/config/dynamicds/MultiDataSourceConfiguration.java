package com.jadson.study.config.dynamicds;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

/**
 * 多数据源自动切换配置
 * <p>
 * 注意，
 * 1. 启动类需要添加：@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 * 2. 在定义transactionManager和sqlSessionFactory时，需要将DynamicDataSourceRouting注入进去，否则会报错
 * </p>
 */
@Configuration
public class MultiDataSourceConfiguration {


    @Bean
    public DataSource masterDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3406/demo?useUnicode=true&characterEncoding=utf8&useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public DataSource slaveDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3407/demo?useUnicode=true&characterEncoding=utf8&useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }
    @Primary
    @Bean
    public DynamicDataSourceRouting dynamicDataSource() {
        DynamicDataSourceRouting dynamicDataSource = new DynamicDataSourceRouting();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("master", masterDataSource());
        targetDataSources.put("slave", slaveDataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }


    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("dynamicDataSource") DynamicDataSourceRouting dynamicDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dynamicDataSource);
        return transactionManager;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSourceRouting dynamicDataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis.xml"));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() throws Exception {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.jadson.study.mapper");
        mapperScannerConfigurer.afterPropertiesSet();
        return mapperScannerConfigurer;
    }


}
