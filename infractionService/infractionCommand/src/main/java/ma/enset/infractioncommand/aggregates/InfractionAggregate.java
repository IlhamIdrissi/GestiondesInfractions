package ma.enset.infractioncommand.aggregates;


import commands.CreateInfractionCommand;
import events.InfractionCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class InfractionAggregate {
    @AggregateIdentifier
    private String id;
    private Date date;
    private String numRadar;
    private String numMat;
    private float vitesse;
    private float vMax;
    private float montant;

    public InfractionAggregate(){}

    @CommandHandler
    public InfractionAggregate(CreateInfractionCommand createInfractionCommand){
        AggregateLifecycle.apply(new InfractionCreatedEvent(
                createInfractionCommand.getId(),
                createInfractionCommand.getDate(),
                createInfractionCommand.getNumRadar(),
                createInfractionCommand.getNumMat(),
                createInfractionCommand.getVitesse(),
                createInfractionCommand.getVMax(),
                createInfractionCommand.getMontant()

        ));
    }
    @EventSourcingHandler
    public void on(InfractionCreatedEvent infractionCreatedEvent){
        this.id = infractionCreatedEvent.getId();
        this.date = infractionCreatedEvent.getDate();
        this.numRadar = infractionCreatedEvent.getNumRadar();
        this.numMat = infractionCreatedEvent.getNumMat();
        this.vitesse = infractionCreatedEvent.getVitesse();
        this.vMax = infractionCreatedEvent.getVMax();
        this.montant = infractionCreatedEvent.getMontant();

    }

}
