package com.emi.medicalimageprocessing.services.impl;

import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.model.Survey;
import com.emi.medicalimageprocessing.repository.PatientRepository;
import com.emi.medicalimageprocessing.repository.SurveyRepository;
import com.emi.medicalimageprocessing.services.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SurveyServiceImpl implements SurveyService {
    private SurveyRepository surveyRepository;
    private PatientRepository patientRepository;
    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository ,PatientRepository patientRepository) {
        this.surveyRepository = surveyRepository;
        this.patientRepository  = patientRepository;
    }
    @Override
    public SurveyDto save(SurveyDto dto) {
        System.out.println(dto);
        return SurveyDto.fromEntity(surveyRepository.save(SurveyDto.toEntity(dto)));
    }

    @Override
    public Optional<Survey> getSurveyDataByPatientId(Integer patientId) {

        return surveyRepository.findById(patientId);
    }


    @Override
    public Survey createPatient(Survey survey) {
        return surveyRepository.save(survey);
    }




    @Override
    public Optional<Survey> findById(Integer id) {
        return surveyRepository.findById(id);
    }

    @Override
    public Optional<Survey> findByFirstnameAndLastname(String firstname, String lastname) {
        return surveyRepository.findByFirstNameAndLastName(firstname, lastname);
    }

    @Override
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            System.out.println("Patient ID is null");
        }
        surveyRepository.deleteById(id);
    }



    @Override
    public Survey updateSurvey(Integer id, Survey survey) {
        Optional<Survey> existingSurveyOptional = surveyRepository.findById(id);
        if (existingSurveyOptional.isPresent()) {
            survey.setId(id);
            return surveyRepository.save(survey);
        } else {
            throw new IllegalArgumentException("Patient with id " + id + " not found");
        }
    }

    @Override
    public List<Survey> searchSurveys(String searchTerm) {
        return surveyRepository.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(searchTerm, searchTerm);
    }

    @Override
    public List<Survey> searchSurveysByDate(Instant date) {
        return surveyRepository.findByCreationDate(date);
    }




    @Override
    public Survey createOrUpdateSurvey(Survey survey) {
        // Save or update the survey record
        surveyRepository.save(survey);

        // Ensure the corresponding patient record is synchronized
        Patient patient = patientRepository.findById(survey.getPatient().getId()).orElse(null);
        if (patient != null) {
            patient.setFirstName(survey.getFirstName());
            patient.setLastName(survey.getLastName());
            patient.setAge(survey.getAge());
            patient.setGender(survey.getGender());
            patient.setPhoneNumber(survey.getPhoneNumber());
            // Update other common fields between Patient and Survey
            // For simplicity, assume other common fields are updated similarly
            patientRepository.save(patient);
        }
        return survey;
    }

    @Override
    public Patient createPatient(Patient dto) {
        return null;
    }
    @Override
    public Optional<Survey> findByCin(String cin){
        return surveyRepository.findByCin(cin);
    }
    @Override
    public List<Survey> findAllByCin(String cin){
        return surveyRepository.findAllByCin(cin);
    }
}
