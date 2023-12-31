package entities;

import Model.Medecin;
import Model.Patient;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consultation {
    private long id;
    private Date dateConsultation;
    private Date rapportConsultation;
    @OneToOne(mappedBy = "rendezVous")
    private RendezVous rendezVous;

    @ManyToMany()
    private Patient patient;
}
