package controllers;

import Repositories.ConsultationRepository;
import entities.Consultation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v2/consultation")
public class ConsultationController {


    private List<Consultation> consultations;
    private ConsultationRepository consultationRepository ;


    @GetMapping("/consultations")
    public List<Consultation> getPatients(){
        return consultationRepository.findAll();
    }


}
