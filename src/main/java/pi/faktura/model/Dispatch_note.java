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
@Table(name = "dispatch_note")
public class Dispatch_note implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="dispatch_note_id", unique=true, nullable=false)
    private Long id;

    @Column(name="dispatch_note_number", nullable=false, length = 50)
    private Long number;

    @Column(name = "dispatch_note_date")
    private Date date;

    @Column(name = "delivery_date")
    private Date delivery_date;

    @JsonIgnore
    @OneToMany(mappedBy="dispatch_note", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Dispatch_note_item> dispatch_note_items;

    @ManyToOne
    @JoinColumn(name = "carrier_id", referencedColumnName = "carrier_id")
    private Carrier carrier;


    @ManyToOne
    @JoinColumn(name = "business_partner_id", referencedColumnName = "business_partner_id")
    private Business_partner buyer;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    @OneToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = true)
    private User user;

    @Column(name="received_goods", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean received_goods;

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;
}
