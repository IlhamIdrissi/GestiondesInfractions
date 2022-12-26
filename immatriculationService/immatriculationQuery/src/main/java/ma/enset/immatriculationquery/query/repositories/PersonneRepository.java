package ma.enset.immatriculationquery.query.repositories;


import ma.enset.immatriculationquery.query.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
