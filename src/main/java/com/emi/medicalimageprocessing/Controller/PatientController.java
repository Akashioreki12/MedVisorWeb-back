package com.emi.medicalimageprocessing.Controller;

import com.emi.medicalimageprocessing.model.Patient;
import com.emi.medicalimageprocessing.repository.PatientRepository;
import com.emi.medicalimageprocessing.services.PatientService;
import com.emi.medicalimageprocessing.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;
    private final SurveyService surveyService;

    @Autowired
    public PatientController(PatientService patientService, SurveyService surveyService) {
        this.patientService = patientService;
        this.surveyService = surveyService;

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer id) {
        Optional<Patient> patient = patientService.findById(id);
        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @PostMapping("/add")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createOrUpdatePatient(patient);
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

    @GetMapping("/search/{searchTerm}")
    public List<Patient> searchPatients(@PathVariable String searchTerm) {
        return patientService.searchPatients(searchTerm);
    }

    @GetMapping("/searchByDate/{date}")
    public List<Patient> searchPatientsByDate(@PathVariable String date) {
        Instant instant = Instant.parse(date + "T00:00:00Z");
        return patientService.searchPatientsByDate(instant);
    }
}
