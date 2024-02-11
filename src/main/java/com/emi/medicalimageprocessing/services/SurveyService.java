package com.emi.medicalimageprocessing.services;

import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.model.Survey;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface SurveyService {

    SurveyDto save(SurveyDto dto);

    Optional<Survey> getSurveyDataByPatientId(Integer patientId);

    Survey createOrUpdateSurvey(Survey survey);

    Patient createPatient(Patient dto);

    Survey createPatient(Survey survey);

    Optional<Survey> findById(Integer id);
    Optional<Survey> findByFirstnameAndLastname(String firstname , String lastname);
    List<Survey> findAll();
    void delete(Integer id);


    Survey updateSurvey(Integer id, Survey survey);

    List<Survey> searchSurveys(String searchTerm);

    List<Survey> searchSurveysByDate(Instant date);



}
