package ma.enset.radarquery.query.repositories;


import ma.enset.radarquery.query.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {
}
