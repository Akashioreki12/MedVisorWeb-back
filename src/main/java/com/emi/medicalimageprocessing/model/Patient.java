package com.emi.medicalimageprocessing.model;

import io.swagger.models.auth.In;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Patient extends AbstractEntity {

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private Survey survey;



    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="dateOfBirth")
    private String dateOfBirth;
    @Column(name="gender")
    private String gender;
    @Column(name="age")
    private String age;
    @Column(name="address")
    private String address;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name = "cin")
    private String cin;
}
