package com.example.jokeapi.repository;

import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jokeapi.model.Joke;

@Repository
public class JdbcJokeRepository implements JokeRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcJokeRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    

    @Override
    public Joke getRandomJoke() {
        // Based on "SQL Antipatterns Avoiding the Pitfalls of Database Programming" chapter on random rows
        String randomOffsetQuery = "SELECT ROUND(RANDOM() * (SELECT COUNT(*) - 1 FROM jokes))";
        Integer random = jdbcTemplate.queryForObject(randomOffsetQuery, Map.of(), Integer.class);
        String randomJokeQuery = "SELECT * FROM jokes LIMIT 1 OFFSET :random";

        return jdbcTemplate.queryForObject(randomJokeQuery, Map.of("random", random), (rs, rowNum) -> {
            String id = rs.getString("id");
            String joke = rs.getString("joke");
            String punchline = rs.getString("punchline");
            return new Joke(id, joke, punchline);
        });
    }

    @Override
    public Joke getJokeById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getJokeById'");
    }
    
}
