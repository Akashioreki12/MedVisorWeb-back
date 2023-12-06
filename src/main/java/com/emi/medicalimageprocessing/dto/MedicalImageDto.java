package com.emi.medicalimageprocessing.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.Instant;

@Data
@Builder
public class MedicalImageDto {
    private Integer id;
    private String imageID;
    private String patientID;
    private String imageType;
    private Instant dateTimeTaken;
    private String description;
    private String  institution;
}
