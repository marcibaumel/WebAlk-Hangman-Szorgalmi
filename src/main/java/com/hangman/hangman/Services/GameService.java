package com.hangman.hangman.Services;

public interface GameService {
    String getUsedCharacters();
    String getGoodCharacters(String searchedWord);
}
