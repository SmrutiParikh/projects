package com.example.parkinglot.repositories;

import com.example.parkinglot.models.Slot;
import com.example.parkinglot.models.Wing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WingRepository extends JpaRepository<Wing, String>, JpaSpecificationExecutor<Wing> {
}
