package com.emi.medicalimageprocessing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {
    private Integer id;
    private String nom;
}
