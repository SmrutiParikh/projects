package com.example.parkinglot.services;

import com.example.parkinglot.models.Reservation;
import com.example.parkinglot.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public class ReservationService extends BaseService<Reservation> {
    @Autowired
    private ReservationRepository repository;

    @Override
    JpaRepository<Reservation, String> getRepository() {
        return repository;
    }

    @Override
    JpaSpecificationExecutor<Reservation> getSpecificationExecutor() {
        return repository;
    }
}
