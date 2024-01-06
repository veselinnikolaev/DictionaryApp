package com.dictionaryapp.service;

import com.dictionaryapp.model.DTO.UserLoginBindingModel;
import com.dictionaryapp.model.DTO.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
