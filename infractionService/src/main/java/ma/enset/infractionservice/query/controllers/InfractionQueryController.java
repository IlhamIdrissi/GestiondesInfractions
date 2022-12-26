package ma.enset.infractionservice.query.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.infractionservice.query.entities.Infraction;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.GetAllInfractionsQuery;
import queries.GetRadarByIdQuery;

import java.util.List;

@RestController
@RequestMapping("/query/infractions")
@Slf4j
@AllArgsConstructor
public class InfractionQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allInfractions")
    public List<Infraction> infractionsList(){
        List<Infraction> response = queryGateway.query(new GetAllInfractionsQuery(), ResponseTypes.multipleInstancesOf(Infraction.class)).join();
        return  response;
    }

    @GetMapping("/byId/{id}")
    public Infraction getInfraction(@PathVariable String id){
        return queryGateway.query(new GetRadarByIdQuery(id), ResponseTypes.instanceOf(Infraction.class)).join();
    }
}
