package ma.enset.infractionservice.query.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Infraction {
    @Id
    private String id;
    private Date date;
    private String numRadar;
    private String numMat;
    private float vitesse;
    private float vMax;
    private float montant;

}
