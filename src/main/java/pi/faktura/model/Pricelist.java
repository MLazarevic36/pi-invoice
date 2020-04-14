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

@Getter
@Setter
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
}
