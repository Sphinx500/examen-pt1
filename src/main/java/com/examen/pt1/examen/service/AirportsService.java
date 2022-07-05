package com.examen.pt1.examen.service;

import com.examen.pt1.examen.model.Airports;

import java.util.List;

public interface AirportsService {

    List<Airports> getAllAirports();

    Airports getAirportById(long id);

    Airports updateAirport(Airports airports);

    void deleteAirport(long id);
}
