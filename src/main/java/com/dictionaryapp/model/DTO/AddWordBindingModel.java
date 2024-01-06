package com.dictionaryapp.model.DTO;

import com.dictionaryapp.model.entity.LanguageName;
import com.dictionaryapp.validation.StringDateInPastOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AddWordBindingModel {
    @Size(min = 2, max = 40)
    private String term;
    @Size(min = 2, max = 80)
    private String translation;
    @Size(min = 2, max = 200)
    private String example;
    @StringDateInPastOrPresent(message = "Input date must be in the past or in the present!")
    private String inputDate;
    @NotNull(message = "You must select a language!")
    private LanguageName language;

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

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public LanguageName getLanguage() {
        return language;
    }

    public void setLanguage(LanguageName language) {
        this.language = language;
    }
}
