package com.example.parkinglot.repositories;

import com.example.parkinglot.models.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends JpaRepository<Block, String> {
}
