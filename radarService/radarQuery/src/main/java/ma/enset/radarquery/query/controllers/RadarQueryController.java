package ma.enset.radarquery.query.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.radarquery.query.entities.Radar;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.GetAllRadarsQuery;
import queries.GetRadarByIdQuery;

import java.util.List;

@RestController
@RequestMapping("/query/radars")
@Slf4j
@AllArgsConstructor
public class RadarQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allVehicules")
    public List<Radar> radarsList(){
        List<Radar> response = queryGateway.query(new GetAllRadarsQuery(), ResponseTypes.multipleInstancesOf(Radar.class)).join();
        return  response;
    }

    @GetMapping("/byId/{id}")
    public Radar getRadar(@PathVariable String id){
        return queryGateway.query(new GetRadarByIdQuery(id), ResponseTypes.instanceOf(Radar.class)).join();
    }
}
