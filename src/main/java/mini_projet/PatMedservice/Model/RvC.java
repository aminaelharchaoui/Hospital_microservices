package mini_projet.PatMedservice.Model;

import lombok.Data;

import java.util.Date;

@Data
public class RvC {
    private long id;
    private Date dateRDV;
    private Date heureRDV;
}
