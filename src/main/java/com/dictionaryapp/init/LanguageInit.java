package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LanguageInit implements CommandLineRunner {
    private final LanguageRepository languageRepository;

    public LanguageInit(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = languageRepository.count();
        if(count == 0){
            for(LanguageName languageName : LanguageName.values()){
                Language language = new Language();
                language.setLanguageName(languageName);
                languageRepository.save(language);
            }
        }

    }
}
