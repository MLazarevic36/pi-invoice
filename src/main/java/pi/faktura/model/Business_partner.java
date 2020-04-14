package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "business_partner")
public class Business_partner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_partner_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="creation_date", nullable=false)
    private Date creation_date;

    @Column(name="address", length = 50)
    private String address;

    @Column(name="tax_id", length = 20)
    private Long tax_id;

    @ManyToOne
    @JoinColumn(name="location_id", referencedColumnName = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name="company_id", referencedColumnName = "company_id")
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyer")
    private Set<Dispatch_note> dispatch_notes = new HashSet<Dispatch_note>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyer")
    private List<Receiving_order> receiving_orders;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "business_partner")
    private List<Invoice> invoices;

    @Enumerated(EnumType.STRING)
    @Column(name = "business_partner_type", nullable = false)
    private Business_partner_type business_partner_type;

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private Boolean deleted;
}
