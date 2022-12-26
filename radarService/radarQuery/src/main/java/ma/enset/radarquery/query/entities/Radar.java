package ma.enset.radarquery.query.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Radar {
    @Id
    private String id;
    private float vMax;
    private String longi;
    private String lat;

}
