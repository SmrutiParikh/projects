package com.example.parkinglot.repositories;

import com.example.parkinglot.models.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, String> {
}
