package com.dictionaryapp.controller;

import com.dictionaryapp.model.DTO.AddWordBindingModel;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class WordController {
    private final WordService wordService;
    private final LoggedUser loggedUser;

    public WordController(WordService wordService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/word/add")
    public ModelAndView addWord(@ModelAttribute("addWordBindingModel") AddWordBindingModel addWordBindingModel){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("word-add");
    }
    @PostMapping("/word/add")
    public ModelAndView addWord(@ModelAttribute("addWordBindingModel") @Valid AddWordBindingModel addWordBindingModel, BindingResult bindingResult){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        if(bindingResult.hasErrors()){
            return new ModelAndView("word-add");
        }

        wordService.add(addWordBindingModel);

        return new ModelAndView("redirect:/home");
    }
    @GetMapping("/word/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        wordService.remove(id);

        return new ModelAndView("redirect:/home");
    }
    @GetMapping("/home/remove-all")
    public ModelAndView removeAll(){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        wordService.removeAll();

        return new ModelAndView("redirect:/home");
    }
}
