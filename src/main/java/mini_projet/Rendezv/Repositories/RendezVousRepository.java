package mini_projet.Rendezv.Repositories;

import mini_projet.Rendezv.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
    List<RendezVous> findByMedecinId(Long medecinId);
    List<RendezVous> findByPatientId(Long medecinId);


}
