package controller;

import Model.RvC;
import client.RvCRestClient;
import entity.Medecin;
import entity.Patient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import repository.PatientRepository;

import java.util.List;
import java.util.Optional;
@RequestMapping("/api/v1/patient")
@AllArgsConstructor
@RestController
public class PatientController {

    private List<Patient> patients;
    private PatientRepository patientRepository ;
    private RvCRestClient rvCRestClient;

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long  id)
    {
            Patient patient= patientRepository.findById(String.valueOf(id)).get();
        List<RvC> rdvs=rvCRestClient.getRendezVousById(patient.getId());
        patient.setRdvs(rdvs);
        return patient;
    }

    @PostMapping
    public Patient enregistrerPatient(@RequestBody Patient patient) {
        patients.add(patient);
        return patient;
    }

    @PutMapping("/{patientId}")
    public Patient modifierPatient(@PathVariable Long patientId, @RequestBody Patient patient) {
        for (Patient p : patients) {
            if (p.getId()==(patientId)) {
                p.setNom(patient.getNom());
                return p;
            }
        }
        return null;
    }
    @DeleteMapping("/{patientId}")
    public void supprimerPatient(@PathVariable Long patientId) {
        patients.removeIf(p -> p.getId()==(patientId));
    }

}
