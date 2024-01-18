package mini_projet.Rendezv.entities;

import mini_projet.Rendezv.Model.Medecin;
import mini_projet.Rendezv.Model.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class RendezVous {

    private Long id;
    private Date dateRDV;
    private Date heureRDV;
    @OneToOne
    private Consultation consultation;
    @Transient
    private Medecin medecin;
    private Long medecinId; // Pour lier le rendez-vous au médecin

    @Transient
    private Patient patient;
    private Long rendezvousId;// Pour lier le rendez-vous au patient




}
