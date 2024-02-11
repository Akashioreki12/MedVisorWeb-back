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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/survey")
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
        Patient patient = new Patient();
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setDateOfBirth(dto.getAge());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setCin(dto.getCin());
        patientService.createPatient(patient);
        SurveyDto data = aiModelService.preProcessData(dto);
        return aiModelService.sendRequestToAiModel(data);
    }


    @GetMapping("/find/{id}")
    public Optional<Survey> getSurveyById(@PathVariable Integer id) {
        Optional<Survey> survey = surveyService.findById(id);
        return survey;
    }

    @GetMapping("/all")
    public List<Survey> getAllSurveys() {
        return surveyService.findAll();
    }

    @PostMapping("/add")
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyService.createOrUpdateSurvey(survey);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Integer id, @RequestBody Survey survey) {
        try {
            Survey updatedSurvey = surveyService.updateSurvey(id, survey);
            return ResponseEntity.ok(updatedSurvey);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Integer id) {
        surveyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/{searchTerm}")
    public List<Survey> searchSurveys(@PathVariable String searchTerm) {
        return surveyService.searchSurveys(searchTerm);
    }

    @GetMapping("/searchByDate/{date}")
    public List<Survey> searchSurveysByDate(@PathVariable String date) {
        Instant instant = Instant.parse(date + "T00:00:00Z");
        return surveyService.searchSurveysByDate(instant);
    }


}
