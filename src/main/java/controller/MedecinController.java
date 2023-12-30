package controller;

import Model.RvC;
import client.RvCRestClient;
import entity.Medecin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import repository.MedecinRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medecin")
@AllArgsConstructor
public class MedecinController {

    private List<Medecin> medecins;
    private MedecinRepository medecinRepository ;
    private RvCRestClient rvCRestClient;

    @GetMapping("/medecins")
    public List<Medecin> getMedecins(){
        return medecinRepository.findAll();
    }

    @GetMapping("/medecins/{id}")
    public Medecin getMedecinsById(@PathVariable Long id){

          Medecin medecin= medecinRepository.findById(String.valueOf(id)).get();
        List<RvC> rdvs=rvCRestClient.getRendezVousById(medecin.getId());
        medecin.setRdvs(rdvs);
        return medecin;
    }


    @PostMapping
    public Medecin enregistrerMedecin(@RequestBody Medecin medecin) {
        medecins.add(medecin);
        return medecin;
    }

    @PutMapping("/{medecinId}")
    public Medecin modifierMedecin(@PathVariable Long medecinId, @RequestBody Medecin medecin) {
        for (Medecin m : medecins) {
            if (m.getId()==medecinId) {
                m.setNom(medecin.getNom());
                m.setSpecialite(medecin.getSpecialite());
                return m;
            }
        }
        return null;
    }
    @DeleteMapping("/{medecinId}")
    public void supprimerMedecin(@PathVariable Long medecinId) {
        medecins.removeIf(m -> m.getId()==(medecinId));
    }
}
