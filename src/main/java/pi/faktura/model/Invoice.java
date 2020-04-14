package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "invoice_number")
    private Long invoice_number;

    @Column(name = "invoice_date")
    private Date invoice_date;

    @Column(name = "currency_date")
    private Date currency_date;

    @Column(name = "base")
    private Long base;

    @Column(name = "vat_total")
    private Long vat_total;

    @Column(name = "amount_to_be_paid")
    private Long amount_to_be_paid;

    @Enumerated(EnumType.STRING)
    @Column(name = "invoice_status", nullable = false)
    private Invoice_status invoice_status;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Invoice_item> invoice_items;

    @OneToOne
    @JoinColumn(name = "receiving_order")
    private Receiving_order receiving_order;

    @OneToOne
    @JoinColumn(name = "dispatch_note")
    private Dispatch_note dispatch_note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="business_partner_id")
    private Business_partner business_partner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name="deleted", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean deleted;

}
