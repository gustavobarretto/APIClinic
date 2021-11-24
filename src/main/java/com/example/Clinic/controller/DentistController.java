package com.example.Clinic.controller;

import com.example.Clinic.persistence.entities.Dentist;
import com.example.Clinic.services.impl.DentistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    private DentistServiceImpl dentistService;

    @PostMapping("/save")
    public ResponseEntity<Dentist> dentistSave(@RequestBody Dentist dentist) {
        return ResponseEntity.ok(dentistService.save(dentist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> searchDentist(@PathVariable Integer id) {
        return ResponseEntity.ok(dentistService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dentist>> searchAllDentists() {
        return ResponseEntity.ok(dentistService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDentist(@PathVariable Integer id) {
        dentistService.delete(id);
        return ResponseEntity.ok("Dentist deleted with success");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Dentist> updateDentist(@PathVariable Integer id, @RequestBody Dentist dentist) {
        return ResponseEntity.ok(dentistService.update(id, dentist));
    }

}
