package ma.enset.immatriculationquery.query.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.immatriculationquery.query.entities.Vehicule;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.GetAllVehiculesQuery;
import queries.GetVehiculeByIdQuery;

import java.util.List;

@RestController
@RequestMapping("/query/vehicules")
@Slf4j
@AllArgsConstructor
public class VehiculeQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allVehicules")
    public List<Vehicule> vehiculesList(){
        List<Vehicule> response = queryGateway.query(new GetAllVehiculesQuery(), ResponseTypes.multipleInstancesOf(Vehicule.class)).join();
        return  response;
    }

    @GetMapping("/byId/{id}")
    public Vehicule getVehicule(@PathVariable String id){
        return queryGateway.query(new GetVehiculeByIdQuery(id), ResponseTypes.instanceOf(Vehicule.class)).join();
    }
}
