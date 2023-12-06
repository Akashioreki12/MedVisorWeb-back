package com.emi.medicalimageprocessing.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.Instant;

@Data
@Builder
public class PatientDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Instant dateOfBirth;
    private String gender;
    private Integer Age;
    private String address;
    private String phoneNumber;
}
