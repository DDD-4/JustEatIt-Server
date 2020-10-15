package com.ddd.justeatit.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Properties;

@Configuration
public class DBconfig {
    private BasicDataSource createDataSource;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        Properties properties = new Properties();

        properties.setProperty("username", username);
        properties.setProperty("password", password);
        properties.setProperty("url", url);

        createDataSource = BasicDataSourceFactory.createDataSource(properties);
        return new JdbcTemplate(createDataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        Properties properties = new Properties();

        properties.setProperty("username", username);
        properties.setProperty("password", password);
        properties.setProperty("url", url);

        createDataSource = BasicDataSourceFactory.createDataSource(properties);
        return new DataSourceTransactionManager(createDataSource);
    }

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcOperations() throws Exception {
        Properties properties = new Properties();

        properties.setProperty("username", username);
        properties.setProperty("password", password);
        properties.setProperty("url", url);

        createDataSource = BasicDataSourceFactory.createDataSource(properties);
        return new NamedParameterJdbcTemplate(createDataSource);
    }
}