package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateVehiculeRequestDTO {
    private String numMat;
    private String Marque;
    private float puisFis;
    private String modele;
    private String nomPer;
    private Date dDNPer;
    private String emailPer;
}
