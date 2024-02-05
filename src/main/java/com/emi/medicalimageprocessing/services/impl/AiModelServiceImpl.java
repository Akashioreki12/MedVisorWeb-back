package com.emi.medicalimageprocessing.services.impl;

import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.services.AiModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AiModelServiceImpl implements AiModelService {


    private RestTemplate restTemplate;

    @Autowired
    public AiModelServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    final String AIAPIURL = "http://localhost:4090/submitData";
    @Override
    public SurveyDto preProcessData(SurveyDto dto) {
        return dto;
    }
    @Override
    public ResponseEntity<String> sendRequestToAiModel(SurveyDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SurveyDto> requestEntity = new HttpEntity<>(dto, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(AIAPIURL, requestEntity, String.class);
        return responseEntity;
    }


}
