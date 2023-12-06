package com.emi.medicalimageprocessing.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="medicalImage")
public class MedicalImage extends AbstractEntity {
    @Column(name="imageID")
    private String imageID;
    @Column(name="patientID")
    private String patientID;
    @Column(name="imageType")
    private String imageType;
    @Column(name="dateTimeTaken")
    private Instant dateTimeTaken;
    @Column(name="description")
    private String description;
    @Column(name="institution")
    private String  institution;
}
