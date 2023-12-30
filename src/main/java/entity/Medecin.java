package entity;

import Model.RvC;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor @Builder
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom ;
    private String email;
    private String Specialite;

    @OneToMany(mappedBy = "rvc")
    private List<RvC> rdvs;





}
