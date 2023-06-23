package com.bytecode.startcms.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDtaSource(){
        DriverManagerDataSource dataSoruce = new DriverManagerDataSource();
        dataSoruce.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSoruce.setUrl(env.getProperty("spring.datasource.url"));
        dataSoruce.setUsername(env.getProperty("spring.datasource.data-username"));
        dataSoruce.setPassword(env.getProperty("spring.datasource.password"));
        return dataSoruce;
    }

}
