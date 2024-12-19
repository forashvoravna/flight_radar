package com.example.socketserver.controller;

import com.example.socketserver.entity.AirportEntity;
import com.example.socketserver.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airport")
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/getAll")
    public List<AirportEntity> getAll(){
        System.out.println();
        return airportService.getAllAirports();
    }
}
