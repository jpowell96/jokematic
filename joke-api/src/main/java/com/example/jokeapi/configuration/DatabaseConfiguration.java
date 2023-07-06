package com.example.jokeapi.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {
    
    @Bean
    public DataSource postgresJokeDataSource() {
        // TODO: Read URL, Username, and Password from application.properties or from external source (AWS Secrets Manager)
        return DataSourceBuilder.create()
        .url("jdbc:postgresql://localhost:5432/joke_db")
        .username("postgres")
        .password(null)
        .driverClassName("org.postgresql.Driver")
        .type(HikariDataSource.class)
        .build();
    }

    @Bean
    public NamedParameterJdbcTemplate postgresJdbcTemplate(DataSource postgresJokeDataSource) {
        return new NamedParameterJdbcTemplate(postgresJokeDataSource);
    }
}
