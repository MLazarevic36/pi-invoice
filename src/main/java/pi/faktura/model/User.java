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

@Getter
@Setter
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
}
