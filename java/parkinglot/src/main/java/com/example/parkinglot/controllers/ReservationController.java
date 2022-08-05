package com.example.parkinglot.controllers;

import com.example.parkinglot.dto.CustomerDTO;
import com.example.parkinglot.exceptions.RecordNotFoundException;
import com.example.parkinglot.models.Customer;
import com.example.parkinglot.services.BaseService;
import com.example.parkinglot.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController()
@RequestMapping("/customers")
public class CustomerController extends BaseController<Customer, CustomerDTO> {
    @Autowired
    private CustomerService service;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BaseService<Customer> getService() {
        return service;
    }

    @Override
    public Customer convertToVO(CustomerDTO dto) {
        return modelMapper.map(dto, Customer.class);
    }

    @Override
    public CustomerDTO convertToDTO(Customer vo) {
        return modelMapper.map(vo, CustomerDTO.class);
    }

    @PostMapping("/new")
    public CustomerDTO create(@RequestBody @Validated CustomerDTO input) {
        CustomerDTO customerDTO = super.create(input);
        return customerDTO;
    }

    @PutMapping("/update")
    public CustomerDTO update(@RequestBody @Validated CustomerDTO input) throws RecordNotFoundException {
        return super.update(input);
    }

    @GetMapping("/get_by_id/{id}")
    public CustomerDTO getById(@PathVariable String id) throws RecordNotFoundException {
        return super.getById(id);
    }

    @GetMapping("/get")
    public List<CustomerDTO> get() {
        return super.get();
    }

    @DeleteMapping("/delete/{id}")
    public CustomerDTO delete(@PathVariable String id) throws RecordNotFoundException {
        return super.delete(id);
    }
}
