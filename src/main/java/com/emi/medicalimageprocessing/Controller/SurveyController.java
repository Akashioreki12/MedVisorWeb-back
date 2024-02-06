package com.emi.medicalimageprocessing.Controller;


import com.emi.medicalimageprocessing.Controller.api.SurveyApi;
import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.services.AiModelService;
import com.emi.medicalimageprocessing.services.PatientService;
import com.emi.medicalimageprocessing.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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


}
