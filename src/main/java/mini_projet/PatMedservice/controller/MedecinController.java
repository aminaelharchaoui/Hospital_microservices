package mini_projet.PatMedservice.controller;

import mini_projet.PatMedservice.Model.RvC;
import mini_projet.PatMedservice.client.RvCRestClient;
import mini_projet.PatMedservice.dto.MedecinDto;
import mini_projet.PatMedservice.entity.Medecin;
import lombok.AllArgsConstructor;
import mini_projet.PatMedservice.repository.MedecinRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/medecin")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class MedecinController {

    private List<Medecin> medecins;
    private MedecinRepository medecinRepository ;
    private RvCRestClient rvCRestClient;
    @GetMapping("/medecins")
    public List<Medecin> getMedecins(){
        return medecinRepository.findAll();
    }

    @GetMapping("/{id}")
    public MedecinDto getMedecinsById(@PathVariable Long id){
        Medecin medecin= medecinRepository.findById(String.valueOf(id)).get();
        List<RvC> rdvs=rvCRestClient.getRendezvousByMedecin(id);
        MedecinDto medecinDto=new MedecinDto();
        medecinDto.setId(medecin.getId());
        medecinDto.setSpecialite(medecin.getSpecialite());
        medecinDto.setEmail(medecin.getEmail());
        medecinDto.setRdvs(rdvs);
        return medecinDto;
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
