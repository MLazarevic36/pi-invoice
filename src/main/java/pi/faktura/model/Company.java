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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getTax_identification_number() {
        return tax_identification_number;
    }

    public void setTax_identification_number(Long tax_identification_number) {
        this.tax_identification_number = tax_identification_number;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Pricelist> getPricelists() {
        return pricelists;
    }

    public void setPricelists(Set<Pricelist> pricelists) {
        this.pricelists = pricelists;
    }

    public Set<Goods_group> getGoods_groups() {
        return goods_groups;
    }

    public void setGoods_groups(Set<Goods_group> goods_groups) {
        this.goods_groups = goods_groups;
    }

    public Set<Business_partner> getBusiness_partners() {
        return business_partners;
    }

    public void setBusiness_partners(Set<Business_partner> business_partners) {
        this.business_partners = business_partners;
    }

    public Set<Business_year> getBusiness_year() {
        return business_year;
    }

    public void setBusiness_year(Set<Business_year> business_year) {
        this.business_year = business_year;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Dispatch_note> getDispatch_notes() {
        return dispatch_notes;
    }

    public void setDispatch_notes(List<Dispatch_note> dispatch_notes) {
        this.dispatch_notes = dispatch_notes;
    }

    public List<Receiving_order> getReceiving_orders() {
        return receiving_orders;
    }

    public void setReceiving_orders(List<Receiving_order> receiving_orders) {
        this.receiving_orders = receiving_orders;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
