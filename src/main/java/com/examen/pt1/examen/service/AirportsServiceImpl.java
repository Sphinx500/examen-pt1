package com.examen.pt1.examen.service;

import com.examen.pt1.examen.exception.ResourceNotFoundException;
import com.examen.pt1.examen.model.Airports;
import com.examen.pt1.examen.repository.AirportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportsServiceImpl implements AirportsService{

    @Autowired
    private AirportsRepository airportsRepository;

    @Override
    public List<Airports> getAllAirports() {
        return this.airportsRepository.findAll();
    }

    @Override
    public Airports getAirportById(long id) {
        Optional<Airports> airport = this.airportsRepository.findById(id);
        if (airport.isPresent()){
            return airport.get();
        } else{
            throw new ResourceNotFoundException("Record not found whit id: "+ id);
        }
    }

    @Override
    public Airports updateAirport(Airports airports) {
        Optional<Airports> airport = this.airportsRepository.findById(airports.getId());

        if (airport.isPresent()){
            Airports airportsUpdate = airport.get();
            airportsUpdate.setId(airports.getId());
            airportsUpdate.setName(airports.getName());

            airportsRepository.save(airportsUpdate);
            return airports;
        }else{
            throw new ResourceNotFoundException("Record not found whit id: "+ airports.getId());
        }
    }

    @Override
    public void deleteAirport(long id) {
        Optional<Airports> airport = this.airportsRepository.findById(id);

        if(airport.isPresent()){
            this.airportsRepository.delete(airport.get());
        }else{
            throw new ResourceNotFoundException("Record not found whit id: "+ id);
        }
    }
}
