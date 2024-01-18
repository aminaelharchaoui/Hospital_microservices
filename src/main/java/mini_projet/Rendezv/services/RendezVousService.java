package mini_projet.Rendezv.services;


import mini_projet.Rendezv.entities.RendezVous;
import mini_projet.Rendezv.Repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    public RendezVous getRendezVousById(Long id) {
        Optional<RendezVous> optionalRendezVous = rendezVousRepository.findById(id);
        return optionalRendezVous.orElse(null);
    }

    // les rendez-vous qui corresponds à un medecin donne {id}

    public List<RendezVous> RendezVousForMedecin(Long id){
        List<RendezVous> rndvsformedecin=rendezVousRepository.findByMedecinId(id);
        return rndvsformedecin;
    }
    // les rendez-vous qui corresponds à un Patient donne {id}

    public List<RendezVous> RendezVousForPatient(Long id){
        List<RendezVous> rndvsforpatient=rendezVousRepository.findByPatientId(id);
        return rndvsforpatient;
    }


    public RendezVous createRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    public RendezVous updateRendezVous(long id, RendezVous updatedRendezVous) {
        Optional<RendezVous> optionalRendezVous = rendezVousRepository.findById(id);
        if (optionalRendezVous.isPresent()) {
            RendezVous existingRendezVous = optionalRendezVous.get();
            // Mettez à jour les propriétés du rendez-vous existant avec les nouvelles valeurs
            existingRendezVous.setDateRDV(updatedRendezVous.getDateRDV());
            existingRendezVous.setHeureRDV(updatedRendezVous.getHeureRDV());
            existingRendezVous.setConsultation(updatedRendezVous.getConsultation());
            existingRendezVous.setMedecin(updatedRendezVous.getMedecin());
            existingRendezVous.setPatient(updatedRendezVous.getPatient());

            // Enregistrez les modifications dans la base de données
            return rendezVousRepository.save(existingRendezVous);
        } else {
            return null; // Rendez-vous non trouvé
        }
    }


    public boolean deleteRendezVous(Long id) {
        Optional<RendezVous> optionalRendezVous = rendezVousRepository.findById(id);
        if (optionalRendezVous.isPresent()) {
            rendezVousRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

