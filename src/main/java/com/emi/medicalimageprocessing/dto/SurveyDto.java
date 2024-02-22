package com.emi.medicalimageprocessing.dto;

import com.emi.medicalimageprocessing.model.Survey;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class SurveyDto {




    private Integer id;




    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String countryCode;
    private String phoneNumber;
    private String maritalStatus;
    private String email;
    private String cin;
    private String weight;
    private String height;
    private String bmi;
    private String totalCholesterol;
    private String ldlCholesterol;
    private String hdlCholesterol;
    private String glucoseLevel;
    private String heartDisease;
    private String diabetes;
    private String hypertension;
    private String historyOfTIAs;
    private String heredityOrGenetics;
    private String residentialArea;
    private String smokingStatus;
    private String alcoholStatus;
    private String workType;
    private Double result;



    public static SurveyDto fromEntity (Survey survey) {
        if (survey == null) {
            return null;
        }
        return SurveyDto.builder()
                .id(survey.getId())
                .firstName(survey.getFirstName())
                .lastName(survey.getLastName())
                .age(survey.getAge())
                .gender(survey.getGender())
                .countryCode(survey.getCountryCode())
                .phoneNumber(survey.getPhoneNumber())
                .maritalStatus(survey.getMaritalStatus())
                .email(survey.getEmail())
                .cin(survey.getCin())
                .weight(survey.getWeight())
                .height(survey.getHeight())
                .bmi(survey.getBmi())
                .totalCholesterol(survey.getTotalCholesterol())
                .ldlCholesterol(survey.getLdlCholesterol())
                .hdlCholesterol(survey.getHdlCholesterol())
                .glucoseLevel(survey.getGlucoseLevel())
                .heartDisease(survey.getHeartDisease())
                .diabetes(survey.getDiabetes())
                .hypertension(survey.getHypertension())
                .historyOfTIAs(survey.getHistoryOfTIAst())
                .heredityOrGenetics(survey.getHeredityOrGenetics())
                .residentialArea(survey.getResidentialArea())
                .smokingStatus(survey.getSmokingStatus())
                .alcoholStatus(survey.getAlcoholStatus())
                .workType(survey.getWorkType())
                .result(survey.getResult())
                .build();

    }


    public static Survey toEntity(SurveyDto surveyDto) {
        if (surveyDto == null) {
            return null;
        }

        Survey survey = new Survey();
        survey.setFirstName(surveyDto.getFirstName());
        survey.setLastName(surveyDto.getLastName());
        survey.setAge(surveyDto.getAge());
        survey.setGender(surveyDto.getGender());
        survey.setCountryCode(surveyDto.getCountryCode());
        survey.setPhoneNumber(surveyDto.getPhoneNumber());
        survey.setMaritalStatus(surveyDto.getMaritalStatus());
        survey.setEmail(surveyDto.getEmail());
        survey.setCin(surveyDto.getCin());
        survey.setWeight(surveyDto.getWeight());
        survey.setHeight(surveyDto.getHeight());
        survey.setBmi(surveyDto.getBmi());
        survey.setTotalCholesterol(surveyDto.getTotalCholesterol());
        survey.setLdlCholesterol(surveyDto.getLdlCholesterol());
        survey.setHdlCholesterol(surveyDto.getHdlCholesterol());
        survey.setGlucoseLevel(surveyDto.getGlucoseLevel());
        survey.setHeartDisease(surveyDto.getHeartDisease());
        survey.setDiabetes(surveyDto.getDiabetes());
        survey.setHypertension(surveyDto.getHypertension());
        survey.setHistoryOfTIAst(surveyDto.getHistoryOfTIAs());
        survey.setHeredityOrGenetics(surveyDto.getHeredityOrGenetics());
        survey.setResidentialArea(surveyDto.getResidentialArea());
        survey.setSmokingStatus(surveyDto.getSmokingStatus());
        survey.setAlcoholStatus(surveyDto.getAlcoholStatus());
        survey.setWorkType(surveyDto.getWorkType());
        survey.setResult(surveyDto.getResult());

        return survey;
    }





}


