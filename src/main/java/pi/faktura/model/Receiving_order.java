package pi.faktura.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "receiving_orders")
public class Receiving_order implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="receiving_order_id", unique=true, nullable=false)
    private Long id;

    @Column(name="number")
    private Long number;

    @Column(name="creation_date")
    private Date creation_date;

    @Column(name="delivery_date")
    private Date delivery_date;

    @JsonIgnore
    @OneToMany(mappedBy="receiving_order", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Receiving_order_item> receiving_order_items;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="companies")
    private Company company;

    @OneToOne()
    @JoinColumn(name="invoice_id")
    private Invoice invoice;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="business_partner_id")
    private Business_partner buyer;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = true)
    private User user;

    @Column(name="active", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean active;

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;
}
