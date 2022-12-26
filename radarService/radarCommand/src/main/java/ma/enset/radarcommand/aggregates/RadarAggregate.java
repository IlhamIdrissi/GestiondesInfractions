package ma.enset.radarcommand.aggregates;


import commands.CreateRadarCommand;
import events.RadarCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class RadarAggregate {
    @AggregateIdentifier
    private String id;
    private float vMax;
    private String longi;
    private String lat;

    public RadarAggregate(){}

    @CommandHandler
    public RadarAggregate(CreateRadarCommand createRadarCommand){
        AggregateLifecycle.apply(new RadarCreatedEvent(
                createRadarCommand.getId(),
                createRadarCommand.getVMax(),
                createRadarCommand.getLongi(),
                createRadarCommand.getLat()

        ));
    }
    @EventSourcingHandler
    public void on(RadarCreatedEvent radarCreatedEvent){
        this.id = radarCreatedEvent.getId();
        this.vMax = radarCreatedEvent.getVMax();
        this.longi = radarCreatedEvent.getLongi();
        this.lat = radarCreatedEvent.getLat();

    }

}
