package com.example.jokeapi.dto;

public class JokeDto {
    public String id;
    public String joke;
    public String punchline;

    public JokeDto(String id, String joke, String punchline) {
        this.id = id;
        this.joke = joke;
        this.punchline = punchline;
    }

    public JokeDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }
}
