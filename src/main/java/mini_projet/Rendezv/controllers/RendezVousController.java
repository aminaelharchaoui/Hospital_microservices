package mini_projet.Rendezv.controllers;

import mini_projet.Rendezv.entities.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mini_projet.Rendezv.services.RendezVousService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/rendezVous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;
    @GetMapping("/RendezVous")
    public ResponseEntity<List<RendezVous>> getAllRendezVous() {
        try {
            List<RendezVous> rendezVousList = rendezVousService.getAllRendezVous();
            return new ResponseEntity<>(rendezVousList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Rendezvous/{id}")
    public ResponseEntity<RendezVous> getRendezVousById(@PathVariable long id) {
        try {
            RendezVous rendezVous = rendezVousService.getRendezVousById(id);
            if (rendezVous != null) {
                return new ResponseEntity<>(rendezVous, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // get all rendez-vous for medecin
    @GetMapping("/RendezVousFormedecin/{medecinId}")
     public ResponseEntity<List<RendezVous>> getRendezvousForMedecin(@PathVariable Long medecinId) {
        try {
        List<RendezVous> rendezvous = rendezVousService.RendezVousForMedecin(medecinId);
        return new ResponseEntity<>(rendezvous, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    // get all rendez-vous for patient
    @GetMapping("/RendezVousFormedecin/{medecinId}")
    public ResponseEntity<List<RendezVous>> getRendezvousForPatient(@PathVariable Long patientId) {
        try {
            List<RendezVous> rendezvous = rendezVousService.RendezVousForPatient(patientId);
            return new ResponseEntity<>(rendezvous, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


// ajout d'un rendez-vous
    @PostMapping
    public ResponseEntity<RendezVous> createRendezVous(@RequestBody RendezVous rendezVous) {
        try {
            RendezVous createdRendezVous = rendezVousService.createRendezVous(rendezVous);
            return new ResponseEntity<>(createdRendezVous, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//update info for an rendez-vous
    @PutMapping("updateRendezVous/{id}")
    public ResponseEntity<RendezVous> updateRendezVous(@PathVariable long id, @RequestBody RendezVous updatedRendezVous) {
        try {
            RendezVous updatedRendezVousResult = rendezVousService.updateRendezVous(id, updatedRendezVous);
            if (updatedRendezVousResult != null) {
                return new ResponseEntity<>(updatedRendezVousResult, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//delete
    @DeleteMapping("deleteRendezVous/{id}")
    public ResponseEntity<HttpStatus> deleteRendezVous(@PathVariable long id) {
        try {
            boolean result = rendezVousService.deleteRendezVous(id);
            if (result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
