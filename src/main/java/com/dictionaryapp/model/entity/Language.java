package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity {
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageName languageName;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "language")
    private List<Word> words;

    public LanguageName getLanguageName() {
        return languageName;
    }

    public void setLanguageName(LanguageName languageName) {
        this.languageName = languageName;
        setDescription(languageName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
    public void setDescription(LanguageName languageName){
        String desc = "";
        switch (languageName){
            case GERMAN: desc = "A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe.";
            break;
            case SPANISH: desc = "A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure.";
            break;
            case FRENCH: desc = "A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature.";
            break;
            case ITALIAN: desc = "A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.";
        }
        this.description = desc;
    }
}
