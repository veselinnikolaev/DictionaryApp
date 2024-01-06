package com.dictionaryapp.model;

import com.dictionaryapp.model.DTO.WordDTO;

import java.util.ArrayList;
import java.util.List;

public class WordHomeViewModel {
    private List<WordDTO> germanWords;
    private List<WordDTO> spanishWords;
    private List<WordDTO> frenchWords;
    private List<WordDTO> italianWords;
    private int allWordsCount;

    public WordHomeViewModel() {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>() ,new ArrayList<>());
    }

    public WordHomeViewModel(List<WordDTO> germanWords, List<WordDTO> spanishWords, List<WordDTO> frenchWords, List<WordDTO> italianWords) {
        this.germanWords = germanWords;
        this.spanishWords = spanishWords;
        this.frenchWords = frenchWords;
        this.italianWords = italianWords;
        this.allWordsCount = germanWords.size() + spanishWords.size() + frenchWords.size() + italianWords.size();
    }

    public List<WordDTO> getGermanWords() {
        return germanWords;
    }

    public List<WordDTO> getSpanishWords() {
        return spanishWords;
    }

    public List<WordDTO> getFrenchWords() {
        return frenchWords;
    }

    public List<WordDTO> getItalianWords() {
        return italianWords;
    }

    public int getAllWordsCount() {
        return allWordsCount;
    }
}
