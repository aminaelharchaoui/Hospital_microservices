package mini_projet.PatMedservice.dto;

import jakarta.persistence.Transient;
import lombok.Data;
import mini_projet.PatMedservice.Model.RvC;

import java.util.ArrayList;
import java.util.List;

@Data
public class MedecinDto {


    private Long id;
    private String nom ;
    private String email;
    private String Specialite;
    @Transient
    private List<RvC> rdvs= new ArrayList<>();
    private Long rndvId;


}
