package com.emi.medicalimageprocessing.repository;


import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    Survey save(Survey survey);
    Optional<Survey> findById(Integer id);

    Optional<Survey> findByFirstNameAndLastName(String firstName, String lastName);



    List<Survey> findByFirstNameOrLastName(String firstName, String lastName);


    @Query("SELECT p FROM Survey p WHERE DATE(p.creationDate) = DATE(:date)")
    List<Survey> findByCreationDate(@Param("date") Instant date);



}
