package mini_projet.PatMedservice.controller;

import mini_projet.PatMedservice.Model.RvC;
import mini_projet.PatMedservice.client.RvCRestClient;
import mini_projet.PatMedservice.dto.MedecinDto;
import mini_projet.PatMedservice.dto.PatientDto;
import mini_projet.PatMedservice.entity.Medecin;
import mini_projet.PatMedservice.entity.Patient;
import lombok.AllArgsConstructor;
import mini_projet.PatMedservice.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/Patient/{id}")
    public PatientDto getMedecinsById(@PathVariable Long id){
        Patient patient= patientRepository.findById(String.valueOf(id)).get();
        List<RvC> rdvs=rvCRestClient.getRendezvousByPatient(id);
        PatientDto patientDto=new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setEmail(patient.getEmail());
        patientDto.setRdvs(rdvs);
        return patientDto;
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
