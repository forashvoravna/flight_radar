package com.example.socketserver.repository;

import com.example.socketserver.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {
    @Query(value = "SELECT * FROM public.airport where country like '%stan'", nativeQuery = true)
    List<AirportEntity> findAllByCountryLike();
}