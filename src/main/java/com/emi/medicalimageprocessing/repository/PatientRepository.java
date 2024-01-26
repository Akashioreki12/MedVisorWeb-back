package com.emi.medicalimageprocessing.repository;

import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByFirstNameAndLastName(String firstName, String lastName);
    Patient save(Patient patient);
    Optional<Patient> findById(Integer id);
}
