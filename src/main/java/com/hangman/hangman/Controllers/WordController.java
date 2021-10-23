package com.hangman.hangman.Controllers;

import com.hangman.hangman.Models.WordModel;
import com.hangman.hangman.Services.WordService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {
    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<WordModel> findAllWord(){
        return wordService.findAllWord();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public WordModel findAllWord(@PathVariable("id") Long id){
        return wordService.findWordById(id);
    }
}
