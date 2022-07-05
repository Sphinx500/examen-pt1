package com.examen.pt1.examen.service;

import com.examen.pt1.examen.exception.ResourceNotFoundException;
import com.examen.pt1.examen.model.Language;
import com.examen.pt1.examen.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LanguageServiceImpl implements LanguageService{

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<Language> getAllLanguage() {
        return this.languageRepository.findAll();
    }

    @Override
    public Language getLanguageById(long languaje_id) {
        Optional<Language> lang = this.languageRepository.findById(languaje_id);
        if (lang.isPresent()){
            return lang.get();
        } else{
            throw new ResourceNotFoundException("Record not found whit id: "+ languaje_id);
        }
    }

    @Override
    public Language updateLanguage(Language language) {
         Optional<Language> lang = this.languageRepository.findById(language.getId());

        if (lang.isPresent()){
            Language languageUpdate = lang.get();
            languageUpdate.setId(language.getId());
            languageUpdate.setName(language.getName());

            languageRepository.save(languageUpdate);
            return language;
        }else{
            throw new ResourceNotFoundException("Record not found whit id: "+ language.getId());
        }
    }

    @Override
    public void deleteLanguage(long languaje_id) {
        Optional<Language> lang = this.languageRepository.findById(languaje_id);

        if(lang.isPresent()){
            this.languageRepository.delete(lang.get());
        }else{
            throw new ResourceNotFoundException("Record not found whit id: "+ languaje_id);
        }
    }
}
