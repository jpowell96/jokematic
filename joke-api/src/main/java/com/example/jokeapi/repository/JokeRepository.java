package com.example.jokeapi.repository;

import com.example.jokeapi.model.Joke;

public interface JokeRepository {
    Joke getRandomJoke();
    Joke getJokeById(String id);
}
