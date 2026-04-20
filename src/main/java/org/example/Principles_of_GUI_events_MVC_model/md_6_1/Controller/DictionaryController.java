package org.example.task1.Controller;

import org.example.task1.Model.Dictionary;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController (){
        // initialize the dictionary with some words

        dictionary = new Dictionary();
        dictionary.addWord("appel", "fruit");
        dictionary.addWord("banana", "fruit");
        dictionary.addWord("car", "vehicle");

    }

    public String searchWord(String word) {

        // validate the input
        if(word == null || word.trim().isEmpty()) {
            System.out.println("Please enter a word to search.");
            return null;
        }

        // search for the word in the dictionary
        String restul = dictionary.searchWord(word);
        if (restul == null){
            System.out.println("Word not found in the dictionary.");
            return null;
        }

        return restul;

    }


}
