package mini_projet.PatMedservice.repository;

import mini_projet.PatMedservice.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface MedecinRepository extends JpaRepository<Medecin,String> {
}
