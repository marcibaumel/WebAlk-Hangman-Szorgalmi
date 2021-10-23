package com.hangman.hangman.Dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hangman.hangman.Models.WordModel;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnitOfWork {

    public List<WordModel> wordModelList;

    public UnitOfWork(){
        this.wordModelList = worldReader();
    }

    public List<WordModel> worldReader(){
        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<WordModel>>() {}.getType();
            Reader reader = Files.newBufferedReader(Paths.get("src/main/java/com/hangman/hangman/Dao/data.json"));
            List<WordModel> resultList = gson.fromJson(reader, listType);
            reader.close();
            return resultList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteJSON() throws IOException {
        File file = new File(Paths.get("src/main/java/com/hangman/hangman/Dao/data.json").toString());
        file.setWritable(true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(Paths.get("src/main/java/com/hangman/hangman/Dao/data.json").toString()));
        bufferedOutputStream.write("{}".getBytes());
        bufferedOutputStream.flush();
    }

    public void rewriteJSON(List<WordModel> newWordList){}

}
