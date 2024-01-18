package mini_projet.Rendezv.controllers;

import mini_projet.Rendezv.entities.Consultation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mini_projet.Rendezv.services.ConsultationService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2/consultation")
public class ConsultationController {
    private ConsultationService consultationService;

    @GetMapping("/consultations")
    public ResponseEntity<List<Consultation>> getAllConsultations() {
        try {
            List<Consultation> consultationLit = consultationService.getAllRendezVous();
            return new ResponseEntity<>(consultationLit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/associate/{rendezVousId}")
    public ResponseEntity<Consultation> associateConsultationWithRendezVous(
            @PathVariable Long rendezVousId,
            @RequestBody Consultation consultation
    ) {
        try {
            Consultation associatedConsultation = consultationService.associateConsultationWithRendezVous(rendezVousId, consultation);
            if (associatedConsultation != null) {
                return new ResponseEntity<>(associatedConsultation, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    


}
