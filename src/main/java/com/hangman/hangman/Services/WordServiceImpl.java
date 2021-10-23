package com.hangman.hangman.Services;

import com.hangman.hangman.Models.WordModel;
import com.hangman.hangman.Repositories.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public List<WordModel> findAllWord() {
        return wordRepository.findAllWord();
    }

    @Override
    public List<WordModel> findAllWordByDifficulty() {
        return null;
    }

    @Override
    public WordModel findWordById(Long id) {
        return wordRepository.findWordById(id);
    }
}
