package com.examen.pt1.examen.controller;

import com.examen.pt1.examen.exception.Message;
import com.examen.pt1.examen.model.Airports;
import com.examen.pt1.examen.service.AirportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportsController {

    @Autowired
    private AirportsService airportsService;

    @GetMapping("/listaaeropuertos")
    public ResponseEntity<?> getAllAirports(){
        List<Airports> lista = airportsService.getAllAirports();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Message("Sin productos en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(airportsService.getAllAirports());
    }

    @GetMapping("/detalleaeroperto/{id}")
    public ResponseEntity<Airports> getAirportById(@PathVariable long id){
        return ResponseEntity.ok().body(airportsService.getAirportById(id));
    }

    @PutMapping("/actualizaaeropuerto/{id}")
    public  ResponseEntity<Airports> updateAirport(@PathVariable long id, @RequestBody Airports airports){
        airports.setId(id);
        return ResponseEntity.ok().body(this.airportsService.updateAirport(airports));
    }

    @DeleteMapping("/eliminaaeropuerto/{id}")
    public HttpStatus deleteProduct(@PathVariable long id){
        this.airportsService.deleteAirport(id);
        return  HttpStatus.OK;
    }
}
