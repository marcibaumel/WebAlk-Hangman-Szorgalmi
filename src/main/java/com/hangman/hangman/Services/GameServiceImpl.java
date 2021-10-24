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
        this.gameRepository.setHealth(6);
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
        if(gameRepository.getHealth() > 0) {
            gameRepository.setTheCharacterList(randomVerb);
            StringBuilder actualWord = new StringBuilder();
            for (int i = 0; i < randomVerb.length(); i++) {
                if (gameRepository.getGoodCharacterList().contains(randomVerb.charAt(i))) {
                    actualWord.append(randomVerb.charAt(i));
                } else {
                    actualWord.append(" _ ");
                }
            }
            String result = actualWord.toString();

            if(!result.contains("_")){
                return "You won, Restart the Program";
            }
            return result;

        }
        else{
            return "Game Over, Restart the Program";
        }
    }

    @Override
    public String writeOutUsedCharacterLists() {
        StringBuilder usedCharacters= new StringBuilder();
        for (int i =0; i<gameRepository.getUsedCharacterList().size(); i++){
            usedCharacters.append(gameRepository.getUsedCharacterList().get(i));
        }
        return usedCharacters.toString();
    }

    @Override
    public String guess(String c) {
        if(guessCharacterCorrectionChecker(c)){
            gameRepository.setPlayerCharacterList(c.charAt(0));
            return c+" added to a list";
        }
        else {
            return "Not good character";
        }
    }

    @Override
    public int actualHealth() {
        return gameRepository.getHealth();
    }

    public boolean guessCharacterCorrectionChecker(String testCharacter){
        if(isNumeric(testCharacter) && testCharacter.length()>0 && inThePlayerLists(testCharacter)){
            return true;
        }
        return false;
    }

    public boolean isNumeric(String str){
        try {
            Double.parseDouble(str);
            return false;
        } catch(NumberFormatException e){
            return true;
        }
    }

    public boolean inThePlayerLists(String str){
        if(gameRepository.getGoodCharacterList().contains(str.charAt(0)) || gameRepository.getUsedCharacterList().contains(str.charAt(0))){
            return false;
        }
        return true;
    }


    //TODO: setCharacterList upload, wrong character format exp throw, health counter, game over in the game, usedCharacter list upload, write out used characters, controller final impl


}
