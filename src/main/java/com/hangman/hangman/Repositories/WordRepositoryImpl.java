package com.hangman.hangman.Repositories;

import com.hangman.hangman.Dao.UnitOfWork;
import com.hangman.hangman.Models.WordModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class WordRepositoryImpl implements WordRepository {

    private UnitOfWork unitOfWork = new UnitOfWork();
    private final List<WordModel> words = unitOfWork.wordModelList;

    @Override
    public List<WordModel> findAllWord() {
        return words;
    }

    @Override
    public List<WordModel> findAllWordByDifficulty() {
        return null;
    }

    @Override
    public WordModel findWordById(Long id) {

        int wordById = findWord(id);
        if(wordById == -1){
            return null;
        }
        else {
            return words.get(wordById);
        }

    }

    public int findWord(Long id) {
        int found = -1;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getId().equals(id)) {
                found = i;
                break;
            }
        }
        return found;
    }
}
