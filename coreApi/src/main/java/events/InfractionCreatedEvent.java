package events;


import commands.BaseCommand;
import lombok.Getter;

import java.util.Date;


public class InfractionCreatedEvent extends BaseEvent<String> {
    @Getter
    private Date date;
    @Getter
    private String numRadar;
    @Getter
    private String numMat;
    @Getter
    private float vitesse;
    @Getter
    private float vMax;
    @Getter
    private float montant;

    public InfractionCreatedEvent(String id, Date date , String numRadar, String numMat, float vitesse, float vMax, float montant) {
        super(id);
        this.date = date;
        this.numRadar = numRadar;
        this.numMat = numMat;
        this.vitesse = vitesse;
        this.vMax = vMax;
        this.montant = montant;

    }


}
