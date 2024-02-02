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
        return patientRepository.save(patient);
    }




    @Override
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }

    @Override
    public Optional<Patient> findByFirstnameAndLastname(String firstname, String lastname) {
        return patientRepository.findByFirstNameAndLastName(firstname, lastname);
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
        Optional<Patient> existingPatientOptional = patientRepository.findById(id);
        if (existingPatientOptional.isPresent()) {
            patient.setId(id);
            return patientRepository.save(patient);
        } else {
            throw new IllegalArgumentException("Patient with id " + id + " not found");
        }
    }


}
