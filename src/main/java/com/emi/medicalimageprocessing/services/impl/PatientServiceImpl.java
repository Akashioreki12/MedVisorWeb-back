package com.emi.medicalimageprocessing.services.impl;

import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.model.Survey;
import com.emi.medicalimageprocessing.repository.PatientRepository;
import com.emi.medicalimageprocessing.repository.SurveyRepository;
import com.emi.medicalimageprocessing.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    private SurveyRepository surveyRepository;
    private int nextId = 1;
    @Autowired
    private PatientServiceImpl(PatientRepository patientRepository, SurveyRepository surveyRepository){
        this.patientRepository=patientRepository;
        this.surveyRepository = surveyRepository;
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

    @Override
    public List<Patient> searchPatients(String searchTerm) {
        return patientRepository.findByFirstNameOrLastName(searchTerm, searchTerm);
    }

    @Override

    public List<Patient> searchPatientsByDate(Instant date) {
        return patientRepository.findByCreationDate(date);
    }

    public Patient findByCin(String cin) {
        Optional<Patient> patientOptional = patientRepository.findByCin(cin);
        return patientOptional.orElse(null);
    }


    @Override
    public Patient createOrUpdatePatient(Patient patient) {
        // Save or update the patient record
        patientRepository.save(patient);

        // Create or update the corresponding survey record
        Survey survey = new Survey();
        survey.setPatient(patient);
        survey.setFirstName(patient.getFirstName());
        survey.setLastName(patient.getLastName());
        survey.setAge(patient.getAge());
        survey.setGender(patient.getGender());
        survey.setPhoneNumber(patient.getPhoneNumber());
        // Set other common fields between Patient and Survey
        // For simplicity, assume other common fields are set similarly

        surveyRepository.save(survey);

        return patient;
    }

    }
