package com.dictionaryapp.service;

import com.dictionaryapp.model.DTO.AddWordBindingModel;
import com.dictionaryapp.model.WordHomeViewModel;

public interface WordService {
    void add(AddWordBindingModel addWordBindingModel);

    void remove(Long id);
    WordHomeViewModel getHomeViewData();

    void removeAll();
}
