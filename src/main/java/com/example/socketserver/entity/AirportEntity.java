package com.example.socketserver.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "airport")
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String icao;
    private String country;
    private String iata;
    private Double latitude;
    private Double longitude;
    private Double altitude;
}