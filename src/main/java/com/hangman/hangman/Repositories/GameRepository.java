package com.hangman.hangman.Repositories;

import java.util.List;

public interface GameRepository {
    void setTheCharacterList(String randomVerb);
    void setPlayerCharacterList(Character word);
    List<Character> getCharacterList();
    List<Character> getGoodCharacterList();
    List<Character> getUsedCharacterList();
}
