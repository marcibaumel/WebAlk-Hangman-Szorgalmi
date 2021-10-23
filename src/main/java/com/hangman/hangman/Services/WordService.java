package com.hangman.hangman.Services;

import com.hangman.hangman.Models.WordModel;

import java.util.List;

public interface WordService {
    List<WordModel> findAllWord();
    List<WordModel> findAllWordByDifficulty();
    WordModel findWordById(Long id);
}
