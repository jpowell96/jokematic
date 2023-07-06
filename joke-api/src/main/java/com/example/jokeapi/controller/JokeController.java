package com.example.jokeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jokeapi.dto.JokeDto;
import com.example.jokeapi.model.Joke;
import com.example.jokeapi.service.JokeService;

@RestController
public class JokeController {
    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }




    @GetMapping("/joke")
    public JokeDto getJoke() {
        Joke joke = jokeService.getRandomJoke();
        JokeDto response = new JokeDto();
        response.setId(joke.getId());
        response.setJoke(joke.getJoke());
        response.setPunchline(joke.getPunchline());
        return response;
    }
    
}
