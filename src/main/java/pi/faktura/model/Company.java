package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="company_id", unique=true, nullable=false)
    private Long id;

    @Column(name="name", unique=false, nullable=false, length = 50)
    private String name;

    @Column(name="address", unique=false, nullable=false, length = 50)
    private String address;

    @Column(name="email", unique=false, nullable=false, length = 50)
    private String email;

    @Column(name="phone", unique=false, nullable=false, length = 50)
    private String phone;

    @Column(name="tin", unique=true, nullable=false, length = 20)
    private Long tax_identification_number;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "company")
    private Set<Pricelist> pricelists = new HashSet<Pricelist>();

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "company")
    private Set<Goods_group> goods_groups = new HashSet<Goods_group>();

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "company")
    private Set<Business_partner> business_partners = new HashSet<Business_partner>();

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "company")
    private Set<Business_year> business_year = new HashSet<Business_year>();

    @OneToMany(mappedBy="company",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Invoice> invoices;

    @OneToMany(mappedBy="company",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Dispatch_note> dispatch_notes;

    @OneToMany(mappedBy="company",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Receiving_order> receiving_orders;

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "company")
    private Set<User> users = new HashSet<User>();

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;
}
