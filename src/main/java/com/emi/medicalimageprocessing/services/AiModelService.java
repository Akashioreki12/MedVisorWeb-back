package com.emi.medicalimageprocessing.services;

import com.emi.medicalimageprocessing.dto.SurveyDto;
import org.springframework.http.ResponseEntity;

public interface AiModelService {
    SurveyDto preProcessData(SurveyDto dto);
    ResponseEntity<String> sendRequestToAiModel(SurveyDto dto);

    public int extractResultValue(ResponseEntity<String> responseEntity);

}
