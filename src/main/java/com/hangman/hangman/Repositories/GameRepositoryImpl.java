package com.hangman.hangman.Repositories;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameRepositoryImpl implements GameRepository {

    private final List<Character> characterList = new ArrayList<>();
    private final List<Character> correctCharacterList = new ArrayList<>();
    private final List<Character> usedCharacterList = new ArrayList<>();
    private int Health = 6;

    @Override
    public void setTheCharacterList(String randomVerb){
        for (char ch : randomVerb.toCharArray()) {
            if(!characterList.contains(ch)) {
                characterList.add(ch);
            }
        }
    }

    @Override
    public void setPlayerCharacterList(Character word){
        if(characterList.contains(word)){
            correctCharacterList.add(word);
        }
        else {
            usedCharacterList.add(word);
        }
    }

    @Override
    public List<Character> getCharacterList() {
        return characterList;
    }

    @Override
    public List<Character> getGoodCharacterList() {
        return correctCharacterList;
    }

    @Override
    public List<Character> getUsedCharacterList() {
        return usedCharacterList;
    }


}
