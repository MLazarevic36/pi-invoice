package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="location_id", unique=true, nullable=false)
    private Long id;

    @Column(name="city", unique=false, nullable=false, length = 50)
    private String city;

    @Column(name="zip_code", unique=true, nullable=false, length = 20)
    private Long zip_code;

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "location")
    private Set<Company> companies = new HashSet<Company>();

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "location")
    private Set<Business_partner> business_partners = new HashSet<Business_partner>();

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;
}
