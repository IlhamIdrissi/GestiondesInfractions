package ma.enset.infractionservice.query.services;


import events.InfractionCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ma.enset.infractionservice.query.entities.Infraction;
import ma.enset.infractionservice.query.repositories.InfractionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import queries.GetAllInfractionsQuery;
import queries.GetInfractionByIdQuery;


import javax.transaction.Transactional;
import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class RadarServiceHandler {
    private InfractionRepository infractionRepository;

    @EventHandler
    public void on(InfractionCreatedEvent infractionCreatedEvent){
        log.info("InfractionCreatedEvent ");
        Infraction infraction =  new Infraction();
        infraction.setId(infractionCreatedEvent.getId());
        infraction.setDate(infractionCreatedEvent.getDate());
        infraction.setNumRadar(infractionCreatedEvent.getNumRadar());
        infraction.setNumMat(infractionCreatedEvent.getNumMat());
        infraction.setVitesse(infractionCreatedEvent.getVitesse());
        infraction.setVMax(infractionCreatedEvent.getVMax());
        infraction.setMontant(infractionCreatedEvent.getMontant());

        infractionRepository.save(infraction);
    }


    @QueryHandler
    public List<Infraction> on(GetAllInfractionsQuery getAllRadarQuery){
        return infractionRepository.findAll();
    }

    @QueryHandler
    public Infraction on(GetInfractionByIdQuery getRadarQuery){
        return infractionRepository.findById(getRadarQuery.getId()).get();
    }
}
