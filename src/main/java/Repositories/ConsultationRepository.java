package Repositories;

import entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ConsultationRepository extends JpaRepository<Consultation,String> {
}
