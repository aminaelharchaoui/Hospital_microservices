package client;

import Model.RvC;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Rendez-v")

public interface RvCRestClient {
    @CircuitBreaker(
            name = "rendez-vService",
            fallbackMethod = "getDefaulRendezVous")
    public List<RvC> getRendezVousById(@PathVariable Long id);
    default RvC getDefaulRendezVous(
            Long id,Exception exception){
        RvC rdv=new RvC();
        rdv.setId(id);
        rdv.getHeureRDV();
        rdv.getDateRDV();
        return rdv;
    }
}
