package com.emi.medicalimageprocessing.services;

import com.emi.medicalimageprocessing.dto.PatientDto;
import com.emi.medicalimageprocessing.model.Patient;


import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient createPatient(Patient dto);
    Optional<Patient> findById(Integer id);
    Optional<Patient> findByFirstnameAndLastname(String fullname);
    List<Patient> findAll();
    void delete(Integer id);
    Patient updatePatient(Integer id, Patient patient);
}