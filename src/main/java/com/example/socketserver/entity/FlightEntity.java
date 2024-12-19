package com.example.socketserver.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "fly_radar")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primary_key;


    private String id;
    private String icao_24bit;
    private Double heading;
    private Double altitude;
    private Double ground_speed;
    private String squawk;
    private String aircraft_code;
    private String registration;
    private String time;
    private String origin_airport_iata;
    private String destination_airport_iata;
    private String number;
    private String airline_iata;
    private Boolean on_ground;
    private Double vertical_speed;
    private String callsign;
    private String airline_icao;
    private Double latitude;
    private Double longitude;
}