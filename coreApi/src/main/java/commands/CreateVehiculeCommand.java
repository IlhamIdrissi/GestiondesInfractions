package commands;


import lombok.Getter;

import java.util.Date;

public class CreateVehiculeCommand extends BaseCommand<String>{
    @Getter
    private String numMat;
    @Getter
    private String Marque;
    @Getter
    private float puisFis;
    @Getter
    private String modele;
    @Getter
    private String nomPer;
    @Getter
    private Date dDNPer;
    @Getter
    private String emailPer;

    public CreateVehiculeCommand(String id, String numMat, String Marque, float puisFis,String modele,String nomPer,Date dDNPer,String emailPer) {
        super(id);
        this.numMat = numMat;
        this.Marque = Marque;
        this.puisFis = puisFis;
        this.modele = modele;
        this.nomPer = nomPer;
        this.dDNPer = dDNPer;
        this.emailPer = emailPer;
    }


}
