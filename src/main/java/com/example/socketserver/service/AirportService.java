package com.example.socketserver.service;

import com.example.socketserver.entity.AirportEntity;
import com.example.socketserver.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public List<AirportEntity> getAllAirports(){
        return airportRepository.findAllByCountryLike();
    }
}
