package com.example.parkinglot.repositories;

import com.example.parkinglot.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot, String>, JpaSpecificationExecutor<Slot> {
}
