package com.dictionaryapp.model.DTO;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;

public class WordDTO {
    private Long id;
    private String term;
    private String translation;
    private String example;
    private String username;
    private String inputDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }
    public static WordDTO createFromWord(Word word){
        WordDTO wordDTO = new WordDTO();

        wordDTO.setId(word.getId());
        wordDTO.setTerm(word.getTerm());
        wordDTO.setExample(word.getExample());
        wordDTO.setTranslation(word.getTranslation());
        wordDTO.setUsername(word.getAddedBy().getUsername());
        wordDTO.setInputDate(word.getInputDate().toString());

        return wordDTO;
    }
}
