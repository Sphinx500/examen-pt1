package com.examen.pt1.examen.controller;

import com.examen.pt1.examen.exception.Message;
import com.examen.pt1.examen.model.Language;
import com.examen.pt1.examen.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/listalanguage")
    public ResponseEntity<?> getAllLanguage(){
        List<Language> lista = languageService.getAllLanguage();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Message("Sin productos en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(languageService.getAllLanguage());
    }

    @GetMapping("/detallelanguage/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable long id){
        return ResponseEntity.ok().body(languageService.getLanguageById(id));
    }


    @PutMapping("/actualizalanguage/{id}")
    public  ResponseEntity<Language> updateLanguage(@PathVariable long id, @RequestBody Language language){
        language.setId(id);
        return ResponseEntity.ok().body(this.languageService.updateLanguage(language));
    }

    @DeleteMapping("/eliminalanguage/{id}")
    public HttpStatus deleteLanguage(@PathVariable long id){
        this.languageService.deleteLanguage(id);
        return  HttpStatus.OK;
    }
}
