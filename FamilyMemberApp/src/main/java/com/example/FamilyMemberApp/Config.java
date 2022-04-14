package com.example.FamilyMemberApp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@EnableAutoConfiguration
@ComponentScan
@Configuration
public class Config {
    private static JdbcTemplate jdbcTemplate;

    //Database connection configuration
    @Bean
    public static DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://host.docker.internal:3306/FamilyMemberDB");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }

    @Bean
    public static void setjdbcTemplate() {
        jdbcTemplate = new JdbcTemplate(getDataSource());
    }

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


}
