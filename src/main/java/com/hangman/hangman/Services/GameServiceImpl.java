package com.hangman.hangman.Services;

import com.hangman.hangman.Repositories.GameRepository;
import com.hangman.hangman.Repositories.WordRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final WordRepository wordRepository;
    private String randomVerb;

    public GameServiceImpl(GameRepository gameRepository, WordRepository wordRepository) {
        this.gameRepository = gameRepository;
        this.wordRepository = wordRepository;
        this.randomVerb = generateRandomVerb();
    }

    public String generateRandomVerb(){
        SecureRandom secureRandom = new SecureRandom();
        int randomWordId = secureRandom.nextInt(wordRepository.findAllWord().size() ) + 1;
        Long id = (long) randomWordId;
        String result = wordRepository.findWordById(id).getText();
        return result;
    }


    @Override
    public String game(){
        gameRepository.setTheCharacterList(randomVerb);
        StringBuilder actualWord= new StringBuilder();
        for(int i = 0; i < randomVerb.length(); i++){
            if(gameRepository.getGoodCharacterList().contains(randomVerb.charAt(i))){
                actualWord.append(randomVerb.charAt(i));
            }
            else{
                actualWord.append(" _ ");
            }
        }
        String result = actualWord.toString();
        return result;
    }

    //TODO: setCharacterList upload, health counter, game over in the game, usedCharacter list upload, write out used characters
}
