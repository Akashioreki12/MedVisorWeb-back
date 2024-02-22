package com.emi.medicalimageprocessing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name="survey")
public class Survey extends AbstractEntity {


    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;



    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "countryCode")
    private String countryCode;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "maritalStatus")
    private String maritalStatus;
    @Column(name = "email")
    private String email;
    @Column(name = "cin")
    private String cin;
    @Column(name = "weight")
    private String weight;

    @Column(name = "height")
    private String height;
    @Column(name = "bmi")
    private String bmi;
    @Column(name = "totalCholesterol")
    private String totalCholesterol;
    @Column(name = "ldlCholesterol")
    private String ldlCholesterol;
    @Column(name = "hdlCholesterol")
    private String hdlCholesterol;
    @Column(name = "glucoseLevel")
    private String glucoseLevel;
    @Column(name = "heartDisease")
    private String heartDisease;
    @Column(name = "diabetes")
    private String diabetes;
    @Column(name = "hypertension")
    private String hypertension;
    @Column(name = "historyOfTIAs")
    private String historyOfTIAst;
    @Column(name = "heredityOrGenetics")
    private String heredityOrGenetics;
    @Column(name = "residentialArea")
    private String residentialArea;
    @Column(name = "smokingStatus")
    private String smokingStatus;
    @Column(name = "alcoholStatus")
    private String alcoholStatus;
    @Column(name = "workType")
    private String workType;

    @Column(name ="result")
    private Double result;


}
