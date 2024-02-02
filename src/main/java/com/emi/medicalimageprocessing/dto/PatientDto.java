package com.emi.medicalimageprocessing.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Date;

@Data
@Builder
public class PatientDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private Integer age;
    private String address;
    private String phoneNumber;
    private String cin;
}
