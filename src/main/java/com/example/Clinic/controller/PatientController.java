package com.example.Clinic.controller;

import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.services.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping("/save")
    public ResponseEntity<Patient> patientSave(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.save(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> searchPatient(@PathVariable Integer id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> searchAllPatients() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Integer id) {
        patientService.delete(id);
        Patient patient = patientService.findById(id);
        if(patient != null)
            return ResponseEntity.internalServerError().body("Patient not deleted");
        return ResponseEntity.ok("Patient deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer id, @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.update(id, patient));
    }
}
