package com.hangman.hangman.Controllers;

import com.hangman.hangman.Services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return result;
    }

}
