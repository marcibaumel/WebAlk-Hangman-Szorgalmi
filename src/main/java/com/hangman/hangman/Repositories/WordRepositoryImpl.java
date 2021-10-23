package com.hangman.hangman.Repositories;

import com.hangman.hangman.Dao.UnitOfWork;
import com.hangman.hangman.Models.WordModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class WordRepositoryImpl implements WordRepository {

    private UnitOfWork unitOfWork = new UnitOfWork();

    @Override
    public List<WordModel> findAllWord() {
        return unitOfWork.wordModelList;
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
            return unitOfWork.wordModelList.get(wordById);
        }

    }

    public int findWord(Long id) {
        int found = -1;
        for (int i = 0; i < unitOfWork.wordModelList.size(); i++) {

            if(unitOfWork.wordModelList.get(i).getId() == id){
                found = i;
                break;
            }

        }
        return found;
    }
}
