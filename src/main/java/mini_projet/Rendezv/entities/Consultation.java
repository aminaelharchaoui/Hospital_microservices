package mini_projet.Rendezv.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
@Builder

public class Consultation {
    @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private Date dateConsultation;
    private Date rapportConsultation;
    @Transient
    private RendezVous rendezVous;



}
