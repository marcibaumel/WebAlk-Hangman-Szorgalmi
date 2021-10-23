package com.hangman.hangman;

import com.hangman.hangman.Dao.UnitOfWork;

import java.io.IOException;

public class JsonReaderMain {
    public static void main(String[] args) throws IOException {
        UnitOfWork jsonReader = new UnitOfWork();
        System.out.println(jsonReader.wordModelList.size());
    }
}
