package com.example.jokeapi.model;


public class Joke {
    private String id;
    private String joke;
    private String punchline;

    public Joke(String id, String joke, String punchline) {
        this.id = id;
        this.joke = joke;
        this.punchline = punchline;
    }

    public String getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }

    public String getPunchline() {
        return punchline;
    }
}