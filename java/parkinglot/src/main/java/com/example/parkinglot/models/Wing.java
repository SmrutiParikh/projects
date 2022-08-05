package com.example.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "tblm_block")
public class Block extends Base {
    @ManyToOne
    @JoinColumn(name = "lot_id")
    private ParkingLot parkingLot;
}
