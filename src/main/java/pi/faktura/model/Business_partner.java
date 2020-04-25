package pi.faktura.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="location_id", referencedColumnName = "location_id")
    private Location location;

    @JsonBackReference
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

    public Business_partner() {
    }

    public Business_partner(String name, Date creation_date, String address, Long tax_id, Location location, Company company, Set<Dispatch_note> dispatch_notes, List<Receiving_order> receiving_orders, List<Invoice> invoices, Business_partner_type business_partner_type, Boolean deleted) {
        this.name = name;
        this.creation_date = creation_date;
        this.address = address;
        this.tax_id = tax_id;
        this.location = location;
        this.company = company;
        this.dispatch_notes = dispatch_notes;
        this.receiving_orders = receiving_orders;
        this.invoices = invoices;
        this.business_partner_type = business_partner_type;
        this.deleted = deleted;
    }

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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTax_id() {
        return tax_id;
    }

    public void setTax_id(Long tax_id) {
        this.tax_id = tax_id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Dispatch_note> getDispatch_notes() {
        return dispatch_notes;
    }

    public void setDispatch_notes(Set<Dispatch_note> dispatch_notes) {
        this.dispatch_notes = dispatch_notes;
    }

    public List<Receiving_order> getReceiving_orders() {
        return receiving_orders;
    }

    public void setReceiving_orders(List<Receiving_order> receiving_orders) {
        this.receiving_orders = receiving_orders;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Business_partner_type getBusiness_partner_type() {
        return business_partner_type;
    }

    public void setBusiness_partner_type(Business_partner_type business_partner_type) {
        this.business_partner_type = business_partner_type;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
