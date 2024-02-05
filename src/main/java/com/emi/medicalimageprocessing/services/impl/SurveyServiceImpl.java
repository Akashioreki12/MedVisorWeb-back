package com.emi.medicalimageprocessing.services.impl;


import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.repository.SurveyRepository;
import com.emi.medicalimageprocessing.services.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SurveyServiceImpl implements SurveyService {
    private SurveyRepository surveyRepository;
    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }
    @Override
    public SurveyDto save(SurveyDto dto) {
        System.out.println(dto);
        return SurveyDto.fromEntity(surveyRepository.save(SurveyDto.toEntity(dto)));
    }
}