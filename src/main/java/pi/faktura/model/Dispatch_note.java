package pi.faktura.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public List<Dispatch_note_item> getDispatch_note_items() {
        return dispatch_note_items;
    }

    public void setDispatch_note_items(List<Dispatch_note_item> dispatch_note_items) {
        this.dispatch_note_items = dispatch_note_items;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Business_partner getBuyer() {
        return buyer;
    }

    public void setBuyer(Business_partner buyer) {
        this.buyer = buyer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isReceived_goods() {
        return received_goods;
    }

    public void setReceived_goods(boolean received_goods) {
        this.received_goods = received_goods;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
