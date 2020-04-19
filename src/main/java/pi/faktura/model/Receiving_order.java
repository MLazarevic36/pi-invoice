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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public List<Receiving_order_item> getReceiving_order_items() {
        return receiving_order_items;
    }

    public void setReceiving_order_items(List<Receiving_order_item> receiving_order_items) {
        this.receiving_order_items = receiving_order_items;
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

    public Business_partner getBuyer() {
        return buyer;
    }

    public void setBuyer(Business_partner buyer) {
        this.buyer = buyer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
