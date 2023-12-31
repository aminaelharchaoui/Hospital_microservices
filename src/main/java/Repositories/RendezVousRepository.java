package Repositories;

import entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
