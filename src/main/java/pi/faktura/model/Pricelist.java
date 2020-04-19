package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Entity
@Table(name = "pricelists")
public class Pricelist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricelist_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "serial_number")
    private Long serial_number;

    @Column(name="expiration_date", unique=false, nullable=false)
    private Date expiration_date;

    @Column(name="creation_date", unique=false, nullable=false)
    private Date creation_date;

    @Column(name="active", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = true)
    private Company company;

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "pricelist")
    private Set<Pricelist_item> pricelist_items = new HashSet<Pricelist_item>();

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(Long serial_number) {
        this.serial_number = serial_number;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Pricelist_item> getPricelist_items() {
        return pricelist_items;
    }

    public void setPricelist_items(Set<Pricelist_item> pricelist_items) {
        this.pricelist_items = pricelist_items;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
