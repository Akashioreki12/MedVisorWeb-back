package com.emi.medicalimageprocessing.Controller;


import com.emi.medicalimageprocessing.Controller.api.SurveyApi;
import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.model.Survey;
import com.emi.medicalimageprocessing.services.AiModelService;
import com.emi.medicalimageprocessing.services.PatientService;
import com.emi.medicalimageprocessing.services.SurveyService;
import com.emi.medicalimageprocessing.validator.SurveyValidator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SurveyController implements SurveyApi {
    private SurveyService surveyService;
    private AiModelService aiModelService;
    private PatientService patientService;
    private SurveyValidator surveyValidator;




    @Autowired
    public SurveyController(SurveyService surveyService, AiModelService aiModelService, PatientService patientService,SurveyValidator surveyValidator) {
        this.surveyService = surveyService;
        this.aiModelService = aiModelService;
        this.patientService=patientService;
        this.surveyValidator = surveyValidator;
    }


    @Override
    public ResponseEntity<String> save(SurveyDto dto) {




        /*
        List<String> validationErrors = SurveyValidator.validate(dto);

        if (!validationErrors.isEmpty()) {
            String errorMessage = "Validation errors: " + String.join(", ", validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

        */


        /*
        ResponseEntity<String> result= aiModelService.sendRequestToAiModel(data);
        String responseBody = result.getBody();

        if (responseBody != null) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                double resultValue = jsonNode.get("result").asInt();
                dto.setResult(resultValue);
                System.out.println("Result Value: " + resultValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
*/





        surveyService.save(dto);
        SurveyDto data = aiModelService.preProcessData(dto);
        Patient existingPatient = patientService.findByCin(dto.getCin());

        if (existingPatient == null) {
            Patient patient = new Patient();
            patient.setFirstName(dto.getFirstName());
            patient.setLastName(dto.getLastName());
            patient.setDateOfBirth(dto.getAge());
            patient.setPhoneNumber(dto.getPhoneNumber());
            patient.setGender(dto.getGender());
            patient.setCin(dto.getCin());
            patient.setAge(dto.getAge());

            patientService.createPatient(patient);
        }

        return aiModelService.sendRequestToAiModel(data);
    }




    @Override
    public Optional<Survey> getSurveyById(@PathVariable Integer id) {
        Optional<Survey> survey = surveyService.findById(id);
        return survey;
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
    public Optional<Survey> findSurveyByCin(String  cin){
        return surveyService.findSurveyByCin(cin);
    }


}
