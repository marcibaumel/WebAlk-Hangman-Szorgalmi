package com.hangman.hangman.Controllers;

import com.hangman.hangman.Services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(path="/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(path="")
    public String startTheGame(){
        String result = gameService.game();
        return result+"     Used characters: "+gameService.writeOutUsedCharacterLists()+"     Health: "+gameService.actualHealth();
    }

    @PostMapping(path="/{char}")
    public String makeAGuess(@PathVariable("char") String c){
        return gameService.guess(c);
    }


}
