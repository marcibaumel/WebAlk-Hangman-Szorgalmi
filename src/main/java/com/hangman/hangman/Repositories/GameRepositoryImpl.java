package com.hangman.hangman.Repositories;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameRepositoryImpl implements GameRepository {

    private final List<Character> characterList = new ArrayList<>();
    private final List<Character> allUsedCharacterList = new ArrayList<>();
    private int Health = 6;

    @Override
    public String newCharacter(char newCharacter) {
        if(!inList(newCharacter)){
            System.out.println(newCharacter+" already in the character list or wrong character.");
            Health--;
            allUsedCharacterList.add(newCharacter);
            if(Health == 0){
                System.out.println("Game over");
            }
        }
        characterList.add(newCharacter);
        return newCharacter+" added to the list";
    }

    @Override
    public List<Character> getExistingCharacters() {
        return characterList;
    }


    public boolean inList(char character) {
        if(characterList.contains(character)){
            return false;
        }
        return true;
    }


}
