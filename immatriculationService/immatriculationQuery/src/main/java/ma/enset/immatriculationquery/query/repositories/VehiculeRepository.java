package ma.enset.immatriculationquery.query.repositories;


import ma.enset.immatriculationquery.query.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, String> {
}
