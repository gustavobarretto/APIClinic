package com.example.Clinic.services.impl;

import com.example.Clinic.persistence.entities.Patient;
import com.example.Clinic.persistence.repository.IPatientRepository;
import com.example.Clinic.services.IClinicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IClinicServices<Patient> {

    @Autowired
    private IPatientRepository patientRepository;
    @Autowired
    private AddressServiceImpl addressService;

    @Override
    public Patient save(Patient patient) {
        addressService.save(patient.getAddress());
        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(Integer id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        patientRepository.deleteById(id);

    }

    @Override
    public Patient update(Integer id, Patient patient) {
        Patient patientToBeUpdated = patientRepository.findById(id).get();

        if(patient.getName() != null)
            patientToBeUpdated.setName(patient.getName());
        if(patient.getSurname() != null)
            patientToBeUpdated.setSurname(patient.getSurname());
        if(patient.getAddress() != null)
            addressService.update(patientToBeUpdated.getAddress().getId(), patient.getAddress());

        return patientRepository.saveAndFlush(patientToBeUpdated);
    }
}
