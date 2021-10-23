package com.hangman.hangman.Repositories;

import com.hangman.hangman.Dao.UnitOfWork;
import com.hangman.hangman.Models.WordModel;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WordRepository {
    List<WordModel> findAllWord();
    List<WordModel> findAllWordByDifficulty();
    WordModel findWordById(Long id);
}
