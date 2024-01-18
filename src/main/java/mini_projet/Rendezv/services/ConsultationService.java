package mini_projet.Rendezv.services;

import mini_projet.Rendezv.Repositories.ConsultationRepository;
import mini_projet.Rendezv.entities.Consultation;
import mini_projet.Rendezv.entities.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsultationService {
    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private  RendezVousService rendezVousService;


    public Consultation associateConsultationWithRendezVous(Long rendezVousId, Consultation consultation) {
        RendezVous rendezVous = rendezVousService.getRendezVousById(rendezVousId);

        if (rendezVous != null) {
            consultation.setRendezVous(rendezVous);
            return consultationRepository.save(consultation);
        } else {
            return null;
        }
    }

    public List<Consultation> getAllRendezVous() {
        return consultationRepository.findAll();
    }
}
