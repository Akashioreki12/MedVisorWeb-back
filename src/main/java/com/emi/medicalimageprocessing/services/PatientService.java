package com.emi.medicalimageprocessing.services;

import com.emi.medicalimageprocessing.dto.PatientDto;
import com.emi.medicalimageprocessing.model.Patient;


import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient createPatient(Patient dto);
    Optional<Patient> findById(Integer id);
    Optional<Patient> findByFirstnameAndLastname(String firstname , String lastname);
    List<Patient> findAll();
    void delete(Integer id);
    Patient updatePatient(Integer id, Patient patient);

    List<Patient> searchPatients(String searchTerm);


    List<Patient> searchPatientsByDate(Instant date);

    Patient createOrUpdatePatient(Patient patient);
    Patient findByCin(String cin);


}
