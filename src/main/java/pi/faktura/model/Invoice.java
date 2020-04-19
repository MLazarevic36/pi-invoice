package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(Long invoice_number) {
        this.invoice_number = invoice_number;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    public Date getCurrency_date() {
        return currency_date;
    }

    public void setCurrency_date(Date currency_date) {
        this.currency_date = currency_date;
    }

    public Long getBase() {
        return base;
    }

    public void setBase(Long base) {
        this.base = base;
    }

    public Long getVat_total() {
        return vat_total;
    }

    public void setVat_total(Long vat_total) {
        this.vat_total = vat_total;
    }

    public Long getAmount_to_be_paid() {
        return amount_to_be_paid;
    }

    public void setAmount_to_be_paid(Long amount_to_be_paid) {
        this.amount_to_be_paid = amount_to_be_paid;
    }

    public Invoice_status getInvoice_status() {
        return invoice_status;
    }

    public void setInvoice_status(Invoice_status invoice_status) {
        this.invoice_status = invoice_status;
    }

    public List<Invoice_item> getInvoice_items() {
        return invoice_items;
    }

    public void setInvoice_items(List<Invoice_item> invoice_items) {
        this.invoice_items = invoice_items;
    }

    public Receiving_order getReceiving_order() {
        return receiving_order;
    }

    public void setReceiving_order(Receiving_order receiving_order) {
        this.receiving_order = receiving_order;
    }

    public Dispatch_note getDispatch_note() {
        return dispatch_note;
    }

    public void setDispatch_note(Dispatch_note dispatch_note) {
        this.dispatch_note = dispatch_note;
    }

    public Business_partner getBusiness_partner() {
        return business_partner;
    }

    public void setBusiness_partner(Business_partner business_partner) {
        this.business_partner = business_partner;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
