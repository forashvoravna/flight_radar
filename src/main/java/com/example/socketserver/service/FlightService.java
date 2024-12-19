package com.example.socketserver.service;

import com.example.socketserver.entity.FlightEntity;
import com.example.socketserver.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public List<FlightEntity> getAllFlights(){
        return flightRepository.findAll();
    }

    public List<Double[]> getAllById(String id){
        List<FlightEntity> flightEntities = flightRepository.findAllByIdOrderByTime(id);
        List<Double[]> doubles = new ArrayList<>();
        for (FlightEntity flightEntity : flightEntities) {
            doubles.add(new Double[]{flightEntity.getLatitude(),flightEntity.getLongitude()});
        }
        return doubles;
    }
}
