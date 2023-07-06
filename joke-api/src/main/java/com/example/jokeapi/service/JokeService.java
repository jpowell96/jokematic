package com.example.jokeapi.service;

import org.springframework.stereotype.Service;

import com.example.jokeapi.model.Joke;
import com.example.jokeapi.repository.JokeRepository;

@Service
public class JokeService  {
    private final JokeRepository jokeRepository;

    public JokeService(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    public Joke getRandomJoke() {
        return jokeRepository.getRandomJoke();
    }

    public Joke getJokeById(String id) {
        return jokeRepository.getJokeById(id);
    }

}