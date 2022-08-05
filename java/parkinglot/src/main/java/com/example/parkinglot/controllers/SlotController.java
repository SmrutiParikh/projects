package com.example.parkinglot.controllers;

import com.example.parkinglot.dto.ReservationDTO;
import com.example.parkinglot.exceptions.RecordNotFoundException;
import com.example.parkinglot.models.Reservation;
import com.example.parkinglot.models.Reservation;
import com.example.parkinglot.services.BaseService;
import com.example.parkinglot.services.CustomerService;
import com.example.parkinglot.services.ReservationService;
import com.example.parkinglot.services.SlotService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController()
@RequestMapping("/reservations")
public class ReservationController extends BaseController<Reservation, ReservationDTO> {
    @Autowired
    private ReservationService service;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SlotService slotService;

    @Override
    public BaseService<Reservation> getService() {
        return service;
    }

    @Override
    public Reservation convertToVO(ReservationDTO dto) {
        return modelMapper.map(dto, Reservation.class);
    }

    @Override
    public ReservationDTO convertToDTO(Reservation vo) {
        return modelMapper.map(vo, ReservationDTO.class);
    }

    @PostMapping("/new")
    public ReservationDTO create(@RequestBody @Validated ReservationDTO input) throws RecordNotFoundException {
        Reservation reservation = convertToVO(input);
        reservation.setCustomer(customerService.findById(reservation.getCustomer().getId()));
        reservation.setSlot(slotService.findById(reservation.getSlot().getId()));

        return convertToDTO(getService().save(reservation));
    }

    @PutMapping("/update")
    public ReservationDTO update(@RequestBody @Validated ReservationDTO input) throws RecordNotFoundException {
        return super.update(input);
    }

    @GetMapping("/get_by_id/{id}")
    public ReservationDTO getById(@PathVariable String id) throws RecordNotFoundException {
        return super.getById(id);
    }

    @GetMapping("/get")
    public List<ReservationDTO> get() {
        return super.get();
    }

    @DeleteMapping("/delete/{id}")
    public ReservationDTO delete(@PathVariable String id) throws RecordNotFoundException {
        return super.delete(id);
    }
}
