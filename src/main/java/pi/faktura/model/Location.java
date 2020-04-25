package pi.faktura.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "location")
    private Set<Company> companies = new HashSet<Company>();

    @JsonBackReference
    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "location")
    private Set<Business_partner> business_partners = new HashSet<Business_partner>();

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;

    public Location() {
    }

    public Location(String city, Long zip_code, Set<Company> companies, Set<Business_partner> business_partners, boolean deleted) {
        this.city = city;
        this.zip_code = zip_code;
        this.companies = companies;
        this.business_partners = business_partners;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZip_code() {
        return zip_code;
    }

    public void setZip_code(Long zip_code) {
        this.zip_code = zip_code;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Business_partner> getBusiness_partners() {
        return business_partners;
    }

    public void setBusiness_partners(Set<Business_partner> business_partners) {
        this.business_partners = business_partners;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
