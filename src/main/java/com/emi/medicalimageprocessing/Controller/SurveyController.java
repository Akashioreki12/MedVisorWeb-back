package com.emi.medicalimageprocessing.Controller;


import com.emi.medicalimageprocessing.Controller.api.SurveyApi;
import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.model.Survey;
import com.emi.medicalimageprocessing.services.AiModelService;
import com.emi.medicalimageprocessing.services.PatientService;
import com.emi.medicalimageprocessing.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
public class SurveyController implements SurveyApi {
    private SurveyService surveyService;
    private AiModelService aiModelService;
    private PatientService patientService;


    @Autowired

    public SurveyController(SurveyService surveyService, AiModelService aiModelService, PatientService patientService) {
        this.surveyService = surveyService;
        this.aiModelService = aiModelService;
        this.patientService=patientService;
    }


    @Override
    public ResponseEntity<String> save(SurveyDto dto) {
        surveyService.save(dto);
        Patient existingPatient = patientService.findByCin(dto.getCin());

        if (existingPatient == null) {
            // Patient does not exist, create a new one
            Patient patient = new Patient();
            patient.setFirstName(dto.getFirstName());
            patient.setLastName(dto.getLastName());
            patient.setDateOfBirth(dto.getAge());
            patient.setPhoneNumber(dto.getPhoneNumber());
            patient.setCin(dto.getCin());

            patientService.createPatient(patient);
        }
        SurveyDto data = aiModelService.preProcessData(dto);
        return aiModelService.sendRequestToAiModel(data);
    }

    @Override
    public Optional<Survey> getSurveyById(Integer id) {
        return surveyService.findById(id);
    }

    @Override
    public List<Survey> getAllSurveys() {
        return surveyService.findAll();
    }


    @Override
    public ResponseEntity<Survey> updateSurvey(Integer id, Survey survey) {
        try {
            Survey updatedSurvey = surveyService.updateSurvey(id, survey);
            return ResponseEntity.ok(updatedSurvey);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteSurvey(Integer id) {
        surveyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<Survey> searchSurveys(String searchTerm) {
        return surveyService.searchSurveys(searchTerm);
    }

    @Override
    public List<Survey> searchSurveysByDate(String date) {
        Instant instant = Instant.parse(date + "T00:00:00Z");
        return surveyService.searchSurveysByDate(instant);
    }

    @Override
    public List<Survey> findAllByCin(String cin) {
        return surveyService.findAllByCin(cin);
    }

    @Override
    public Optional<Survey> findByCin(String  cin){
        return surveyService.findByCin(cin);
    }


}
