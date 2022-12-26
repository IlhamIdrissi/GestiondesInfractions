package ma.enset.immatriculationcommand.aggregates;

import commands.CreateVehiculeCommand;
import events.VehiculeCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class VehiculeAggregate {
    @AggregateIdentifier
    private String id;
    private String numMat;
    private String Marque;
    private float puisFis;
    private String modele;
    private String nomPer;
    private Date dDNPer;
    private String emailPer;

    public VehiculeAggregate(){}

    @CommandHandler
    public VehiculeAggregate(CreateVehiculeCommand createVehiculeCommand){
        AggregateLifecycle.apply(new VehiculeCreatedEvent(
                createVehiculeCommand.getId(),
                createVehiculeCommand.getNumMat(),
                createVehiculeCommand.getMarque(),
                createVehiculeCommand.getPuisFis(),
                createVehiculeCommand.getModele(),
                createVehiculeCommand.getNomPer(),
                createVehiculeCommand.getDDNPer(),
                createVehiculeCommand.getEmailPer()

        ));
    }
    @EventSourcingHandler
    public void on(VehiculeCreatedEvent vehiculeCreatedEvent){
        this.id = vehiculeCreatedEvent.getId();
        this.numMat = vehiculeCreatedEvent.getNumMat();
        this.Marque = vehiculeCreatedEvent.getMarque();
        this.puisFis = vehiculeCreatedEvent.getPuisFis();
        this.modele = vehiculeCreatedEvent.getModele();
        this.nomPer = vehiculeCreatedEvent.getNomPer();
        this.dDNPer = vehiculeCreatedEvent.getDDNPer();
        this.emailPer = vehiculeCreatedEvent.getEmailPer();
    }

}
