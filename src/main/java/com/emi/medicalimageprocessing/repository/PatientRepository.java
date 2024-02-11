package com.emi.medicalimageprocessing.repository;

import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<Patient> findByCin(String cin);

    Patient save(Patient patient);
    Optional<Patient> findById(Integer id);
    List<Patient> findByFirstNameOrLastName(String firstName, String lastName);


    @Query("SELECT p FROM Patient p WHERE DATE(p.creationDate) = DATE(:date)")
    List<Patient> findByCreationDate(@Param("date") Instant date);

}

