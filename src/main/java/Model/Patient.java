package Model;


import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class Patient {
    private long id;
    private String nom ;
    private String email;
}
