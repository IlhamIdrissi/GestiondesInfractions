package ma.enset.immatriculationquery.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Personne {
    @Id
    private String id;
    private String nomPer;
    private Date dDNPer;
    private String emailPer;
    @OneToMany(mappedBy = "personne")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Vehicule> vehicules;
}
