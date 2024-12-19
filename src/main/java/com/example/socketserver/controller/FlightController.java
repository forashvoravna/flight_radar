package com.example.socketserver.controller;

import com.example.socketserver.entity.AirportEntity;
import com.example.socketserver.entity.FlightEntity;
import com.example.socketserver.service.AirportService;
import com.example.socketserver.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/getAll")
    public List<FlightEntity> getAll(){
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public List<Double[]> getAllById(@PathVariable("id") String id){
        return flightService.getAllById(id);
    }

}
