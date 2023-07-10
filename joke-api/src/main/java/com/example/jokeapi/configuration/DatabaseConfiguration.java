package com.example.jokeapi.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableConfigurationProperties
public class DatabaseConfiguration {
    
    @Bean
    @ConfigurationProperties(prefix="joke.db.datasource")
    public DataSource postgresJokeDataSource() {
        // DataSource autopopulates jdbcUrl, user, and password from the properties file, which pulls from env variables.
        return DataSourceBuilder.create().build();
    }

    @Bean
    public NamedParameterJdbcTemplate postgresJdbcTemplate(DataSource postgresJokeDataSource) {
        return new NamedParameterJdbcTemplate(postgresJokeDataSource);
    }
}
