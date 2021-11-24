package com.example.Clinic.services;

import java.util.List;

public interface IClinicServices <T> {

    T save(T t);
    T findById(Integer id);
    List<T> findAll();
    void delete(Integer id);
    T update(Integer id, T t);

}
