package com.emi.medicalimageprocessing.Controller;

import com.emi.medicalimageprocessing.dto.PatientDto;

import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/patient")
@RequestMapping("/patients")
public class PatientController {


    private PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Patient>> getPatientById(@PathVariable Integer id) {
        Optional<Patient> patient = patientService.findById(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.findAll();
        return ResponseEntity.ok(patients);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        return ResponseEntity.ok(createdPatient);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer id, @RequestBody Patient patient) {
        try {
            Patient updatedPatient = patientService.updatePatient(id, patient);
            return ResponseEntity.ok(updatedPatient);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
