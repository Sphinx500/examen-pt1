package com.examen.pt1.examen.repository;

import com.examen.pt1.examen.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
