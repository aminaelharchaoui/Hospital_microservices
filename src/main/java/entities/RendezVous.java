package entities;

import Model.Medecin;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class RendezVous {

    private long id;
    private Date dateRDV;
    private Date heureRDV;
    @OneToOne
    private Consultation consultation;

    @ManyToMany()
    private Medecin medecin;


}
