package com.weimai.dprs.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by baiqian@myweimai.com on 2016/11/10.
 */
@Configuration
@ConfigurationProperties(prefix = "mybatis", ignoreUnknownFields = false)
@MapperScan("com.weimai.ordercenter.dao")
public class MyBatisConfig {
    private Logger log = LoggerFactory.getLogger(MyBatisConfig.class);

    private String configLocationXml = "MyBatisConfig.xml";

    public String getConfigLocationXml() {
        return configLocationXml;
    }

    public void setConfigLocationXml(String configLocationXml) {
        this.configLocationXml = configLocationXml;
    }

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean
    @Autowired
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        log.info("Loading mybatis config: {}", configLocationXml);
        Resource configLocation = new ClassPathResource(configLocationXml);
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(configLocation);
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

}
