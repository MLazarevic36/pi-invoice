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

@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "user")
    private Set<Receiving_order> receiving_orders =new HashSet<Receiving_order>();

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "user")
    private Set<Invoice> invoices =new HashSet<Invoice>();

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "user")
    private Set<Dispatch_note> dispatch_notes =new HashSet<Dispatch_note>();

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Receiving_order> getReceiving_orders() {
        return receiving_orders;
    }

    public void setReceiving_orders(Set<Receiving_order> receiving_orders) {
        this.receiving_orders = receiving_orders;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Set<Dispatch_note> getDispatch_notes() {
        return dispatch_notes;
    }

    public void setDispatch_notes(Set<Dispatch_note> dispatch_notes) {
        this.dispatch_notes = dispatch_notes;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
