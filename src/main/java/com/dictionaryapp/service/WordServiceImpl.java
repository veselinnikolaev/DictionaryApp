package com.dictionaryapp.service;

import com.dictionaryapp.model.DTO.AddWordBindingModel;
import com.dictionaryapp.model.DTO.WordDTO;
import com.dictionaryapp.model.WordHomeViewModel;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.dictionaryapp.model.entity.LanguageName.*;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public WordServiceImpl(WordRepository wordRepository, LanguageRepository languageRepository, LoggedUser loggedUser, UserRepository userRepository) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public void add(AddWordBindingModel addWordBindingModel) {
        Language language = languageRepository.findByLanguageName(addWordBindingModel.getLanguage());

        if(language != null){
            Word word = new Word();
            word.setTerm(addWordBindingModel.getTerm());
            word.setExample(addWordBindingModel.getExample());
            word.setLanguage(language);
            word.setTranslation(addWordBindingModel.getTranslation());
            word.setInputDate(LocalDate.parse(addWordBindingModel.getInputDate()));

            User user = userRepository.findByUsername(loggedUser.getUsername());
            word.setAddedBy(user);

            wordRepository.save(word);
        }
    }

    @Override
    public void remove(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public WordHomeViewModel getHomeViewData() {
        if(wordRepository.count() != 0){
            List<WordDTO> germanWords = wordRepository.findByLanguage(languageRepository.findByLanguageName(GERMAN)).stream().map(WordDTO::createFromWord).collect(Collectors.toList());
            List<WordDTO> spanishWords = wordRepository.findByLanguage(languageRepository.findByLanguageName(SPANISH)).stream().map(WordDTO::createFromWord).collect(Collectors.toList());
            List<WordDTO> frenchWords = wordRepository.findByLanguage(languageRepository.findByLanguageName(FRENCH)).stream().map(WordDTO::createFromWord).collect(Collectors.toList());
            List<WordDTO> italianWords = wordRepository.findByLanguage(languageRepository.findByLanguageName(ITALIAN)).stream().map(WordDTO::createFromWord).collect(Collectors.toList());

            return new WordHomeViewModel(germanWords, spanishWords, frenchWords, italianWords);
        }
        return new WordHomeViewModel();
    }

    @Override
    public void removeAll() {
        wordRepository.deleteAll();
    }
}
