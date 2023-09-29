package com.matthewa.ingauth;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/ing_auth", "springuser", "password");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return (DataSource) dataSource;
    }
}
