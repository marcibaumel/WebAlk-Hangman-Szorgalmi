package com.hangman.hangman.Models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WordModel {
    @NotNull
    private Long id;
    @NotEmpty
    private String text;
    @NotEmpty
    private Difficulty level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Difficulty getLevel() {
        return level;
    }

    public void setLevel(Difficulty level) {
        this.level = level;
    }

    public WordModel(Long id, String text, Difficulty level) {
        this.id = id;
        this.text = text;
        this.level = level;
    }

    public WordModel(){ }

    @Override
    public String toString() {
        return "WordModel{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", level=" + level +
                '}';
    }
}
