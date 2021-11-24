package com.example.Clinic.services.impl;

import com.example.Clinic.persistence.entities.Address;
import com.example.Clinic.persistence.repository.IAddressRepository;
import com.example.Clinic.services.IClinicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IClinicServices<Address> {

    @Autowired
    private IAddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address findById(Integer id) {
        return addressRepository.findById(id).get();
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    public Address update(Integer id, Address address) {
        Address addressToBeUpdated = addressRepository.findById(id).get();
        if(address.getCity() != null)
            addressToBeUpdated.setCity(address.getCity());
        if(address.getNumber() != null)
            addressToBeUpdated.setNumber(address.getNumber());
        if(address.getStreet() != null)
            addressToBeUpdated.setStreet(address.getStreet());
        return addressRepository.saveAndFlush(addressToBeUpdated);
    }

}
