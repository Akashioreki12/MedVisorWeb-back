package com.emi.medicalimageprocessing.Controller;


import com.emi.medicalimageprocessing.Controller.api.SurveyApi;
import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.services.AiModelService;
import com.emi.medicalimageprocessing.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyController implements SurveyApi {
    private SurveyService surveyService;
    private AiModelService aiModelService;



    @Autowired

    public SurveyController(SurveyService surveyService, AiModelService aiModelService) {
        this.surveyService = surveyService;
        this.aiModelService = aiModelService;
    }


    @Override
    public ResponseEntity<String> save(SurveyDto dto) {
        surveyService.save(dto);
        SurveyDto data = aiModelService.preProcessData(dto);
        return aiModelService.sendRequestToAiModel(data);
    }
}
