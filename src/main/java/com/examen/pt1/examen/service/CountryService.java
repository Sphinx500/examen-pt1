package com.examen.pt1.examen.service;

import com.examen.pt1.examen.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountry();

    Country getCountryById(long country_id);

    Country updateCountry(Country country);

    void deleteCountry(long country_id);
}
