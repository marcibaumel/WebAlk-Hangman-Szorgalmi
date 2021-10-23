package com.hangman.hangman.Repositories;

import java.util.List;

public interface GameRepository {
    String newCharacter(char newCharacter);
    List<Character> getExistingCharacters();

}
