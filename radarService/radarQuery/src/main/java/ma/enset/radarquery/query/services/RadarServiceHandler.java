package ma.enset.radarquery.query.services;

import events.RadarCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.radarquery.query.entities.Radar;
import ma.enset.radarquery.query.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import queries.GetAllRadarsQuery;
import queries.GetRadarByIdQuery;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class RadarServiceHandler {
    private RadarRepository radarRepository;

    @EventHandler
    public void on(RadarCreatedEvent radarCreatedEvent){
        log.info("RadarCreatedEvent ");
        Radar radar =  new Radar();
        radar.setId(radarCreatedEvent.getId());
        radar.setVMax(radarCreatedEvent.getVMax());
        radar.setLongi(radarCreatedEvent.getLongi());
        radar.setLat(radarCreatedEvent.getLat());
        radarRepository.save(radar);
    }


    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery getAllRadarQuery){
        return radarRepository.findAll();
    }

    @QueryHandler
    public Radar on(GetRadarByIdQuery getRadarQuery){
        return radarRepository.findById(getRadarQuery.getId()).get();
    }
}
