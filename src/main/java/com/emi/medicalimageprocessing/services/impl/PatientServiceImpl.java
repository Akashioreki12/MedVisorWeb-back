package com.emi.medicalimageprocessing.services.impl;

import com.emi.medicalimageprocessing.dto.PatientDto;
import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.repository.PatientRepository;
import com.emi.medicalimageprocessing.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    private int nextId = 1;
    @Autowired
    private PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }


    @Override
    public Patient createPatient(Patient patient) {
        patient.setId(nextId++);
        patientRepository.findAll().add(patient.getId(), patient);
        return patient;
    }



    @Override
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }

    @Override
    public Optional<Patient> findByFirstnameAndLastname(String fullname) {
        return patientRepository.findByFirstNameAndLastName(fullname);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            System.out.println("Patient ID is null");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public Patient updatePatient(Integer id, Patient patient) {
        if (patientRepository.findAll().contains(id)) {
            patient.setId(id);
            patientRepository.findAll().add(patient);
            return patient;
        } else {
            throw new IllegalArgumentException("Patient with id " + id + " not found");
        }
    }
}
