package com.examen.pt1.examen.service;

import com.examen.pt1.examen.exception.ResourceNotFoundException;
import com.examen.pt1.examen.model.Country;
import com.examen.pt1.examen.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountry() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country getCountryById(long country_id) {
        Optional<Country> country = this.countryRepository.findById(country_id);
        if(country.isPresent()){
            return country.get();
        } else {
            throw new ResourceNotFoundException("Record not found whit id: "+ country_id);
        }
    }

    @Override
    public Country updateCountry(Country country) {
        Optional<Country> cou = this.countryRepository.findById(country.getId());
        if(cou.isPresent()){
            Country countryUpdate = cou.get();
            countryUpdate.setId(country.getId());
            countryUpdate.setCode(country.getCode());
            countryUpdate.setName(country.getName());

            countryRepository.save(countryUpdate);
            return country;
        }else{
            throw new ResourceNotFoundException("Record not found whit id: "+ country.getId());
        }
    }

    @Override
    public void deleteCountry(long country_id) {
        Optional<Country> cou = this.countryRepository.findById(country_id);

        if(cou.isPresent()){
            this.countryRepository.delete(cou.get());
        }else{
            throw new ResourceNotFoundException("Record not found whit id: "+ country_id);
        }
    }
}
