package com.example.Clinic.controller;

import com.example.Clinic.persistence.entities.Address;
import com.example.Clinic.services.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping("/save")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.save(address));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> searchAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> searchAllAddresses() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id) {
        addressService.delete(id);
        return ResponseEntity.ok("Address deleted with success");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Integer id, @RequestBody Address address) {
        return ResponseEntity.ok(addressService.update(id, address));
    }


}
