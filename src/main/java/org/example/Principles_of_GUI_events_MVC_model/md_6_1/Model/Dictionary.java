package org.example.task1.Model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words;


    public Dictionary() {
        words = new HashMap<>();
    }

    // add new word
    public void addWord(String word, String meaning) {
        words.put(word.toLowerCase(), meaning);
    }

    // get meaning of a word
    public String searchWord(String word) {
        return words.get(word.toLowerCase());
    }


}
