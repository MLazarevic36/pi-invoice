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

@NoArgsConstructor
@Entity
@Table(name = "vat")
public class VAT implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="vat_id", unique=true, nullable=false)
    private Long id;

    @Column(name="name", unique=false, nullable=false, length = 50)
    private String name;

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "vat")
    private Set<VAT_rate> rates = new HashSet<VAT_rate>();

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "vat")
    private Set<Goods_group> groups = new HashSet<Goods_group>();

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<VAT_rate> getRates() {
        return rates;
    }

    public void setRates(Set<VAT_rate> rates) {
        this.rates = rates;
    }

    public Set<Goods_group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Goods_group> groups) {
        this.groups = groups;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
