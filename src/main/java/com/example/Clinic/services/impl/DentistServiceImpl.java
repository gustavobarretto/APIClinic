package com.example.Clinic.services.impl;

import com.example.Clinic.persistence.entities.Dentist;
import com.example.Clinic.persistence.repository.IDentistRepository;
import com.example.Clinic.services.IClinicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DentistServiceImpl implements IClinicServices<Dentist> {

    @Autowired
    private IDentistRepository dentistRepository;

    public Dentist save(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    public Dentist findById(Integer id) {
        return dentistRepository.findById(id).get();
    }

    public List<Dentist> findAll() {
        return dentistRepository.findAll();
    }

    public void delete(Integer id) {
        dentistRepository.deleteById(id);
    }

    public Dentist update(Integer id, Dentist dentist) {
        Dentist dentistToBeUpdated = dentistRepository.findById(id).get();
        if(dentist.getName() != null)
            dentistToBeUpdated.setName(dentist.getName());
        if(dentist.getSurname() != null)
            dentistToBeUpdated.setSurname(dentist.getSurname());
        if(dentist.getRegistration() != null)
            dentistToBeUpdated.setRegistration(dentist.getRegistration());
        return dentistRepository.saveAndFlush(dentistToBeUpdated);
    }
}