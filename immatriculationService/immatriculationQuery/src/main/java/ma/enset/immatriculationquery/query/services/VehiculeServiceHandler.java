package ma.enset.immatriculationquery.query.services;

import events.VehiculeCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.immatriculationquery.query.entities.Vehicule;
import ma.enset.immatriculationquery.query.repositories.PersonneRepository;
import ma.enset.immatriculationquery.query.repositories.VehiculeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import queries.GetAllVehiculesQuery;
import queries.GetVehiculeByIdQuery;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class VehiculeServiceHandler {
    private VehiculeRepository vehiculeRepository;
    private PersonneRepository personneRepository;
    @EventHandler
    public void on(VehiculeCreatedEvent vehiculeCreatedEvent){
        log.info("VehiculeCreatedEvent ");
        Vehicule vehicule =  new Vehicule();
        vehicule.setId(vehiculeCreatedEvent.getId());
        vehicule.setNumMat(vehiculeCreatedEvent.getNumMat());
        vehicule.setMarque(vehiculeCreatedEvent.getMarque());
        vehicule.setPuisFis(vehiculeCreatedEvent.getPuisFis());
        vehicule.setModele(vehiculeCreatedEvent.getModele());
        vehiculeRepository.save(vehicule);
    }


    @QueryHandler
    public List<Vehicule> on(GetAllVehiculesQuery getAllAccountQuery){
        return vehiculeRepository.findAll();
    }

    @QueryHandler
    public Vehicule on(GetVehiculeByIdQuery getVehiculeQuery){
        return vehiculeRepository.findById(getVehiculeQuery.getId()).get();
    }
}
