package com.examen.pt1.examen.service;

import com.examen.pt1.examen.model.Language;

import java.util.List;

public interface LanguageService {

    List<Language> getAllLanguage();

    Language getLanguageById(long languaje_id);

    Language updateLanguage(Language language);

    void deleteLanguage(long languaje_id);
}
