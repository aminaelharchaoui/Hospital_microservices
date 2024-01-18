package mini_projet.PatMedservice.client;

import mini_projet.PatMedservice.Model.RvC;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Rendez-v",url = "http://localhost:8081")
public interface RvCRestClient {
    @CircuitBreaker(
            name = "default",
            fallbackMethod = "getDefaultRendezVous")

    @GetMapping("/api/v2/rendezVous/RendezVousFormedecin/{medecinId}")
    List<RvC> getRendezvousByMedecin(@PathVariable("medecinId") Long medecinId);
   @GetMapping("/api/v2/rendezVous/RendezVousForPatient/{patientId}")
   List<RvC> getRendezvousByPatient(@PathVariable("medecinId") Long medecinId);

    default RvC getDefaulRendezVousByID(
            Long id,Exception exception){
        RvC rdv=new RvC();
        rdv.setId(id);
        rdv.setDateRDV(null);
        rdv.setHeureRDV(null);
        return rdv;
    }


}
