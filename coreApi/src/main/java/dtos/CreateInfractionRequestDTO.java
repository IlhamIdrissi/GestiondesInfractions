package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateInfractionRequestDTO {
    private Date date;
    private String numRadar;
    private String numMat;
    private float vitesse;
    private float vMax;
    private float montant;

}
