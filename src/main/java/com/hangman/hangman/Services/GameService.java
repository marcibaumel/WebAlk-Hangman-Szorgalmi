package com.hangman.hangman.Services;

public interface GameService {
    String game();
    String writeOutUsedCharacterLists();
    String guess(String c);
    int actualHealth();
}
