package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Table(name = "invoice_items")
public class Invoice_item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_item_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "unit_price")
    private Long unit_price;

    @Column(name = "rebate")
    private Long rebate;

    @Column(name = "base_for_vat")
    private Long base_for_vat;

    @Column(name = "vat_percent")
    private Long vat_percent;

    @Column(name = "vat_amount")
    private Long vat_amount;

    @Column(name = "item_amount")
    private Long item_amount;

    @Column(name = "unit_of_measure")
    private String unit_of_measure;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="goods_id")
    private Goods goods;

    @Column(name="deleted", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Long unit_price) {
        this.unit_price = unit_price;
    }

    public Long getRebate() {
        return rebate;
    }

    public void setRebate(Long rebate) {
        this.rebate = rebate;
    }

    public Long getBase_for_vat() {
        return base_for_vat;
    }

    public void setBase_for_vat(Long base_for_vat) {
        this.base_for_vat = base_for_vat;
    }

    public Long getVat_percent() {
        return vat_percent;
    }

    public void setVat_percent(Long vat_percent) {
        this.vat_percent = vat_percent;
    }

    public Long getVat_amount() {
        return vat_amount;
    }

    public void setVat_amount(Long vat_amount) {
        this.vat_amount = vat_amount;
    }

    public Long getItem_amount() {
        return item_amount;
    }

    public void setItem_amount(Long item_amount) {
        this.item_amount = item_amount;
    }

    public String getUnit_of_measure() {
        return unit_of_measure;
    }

    public void setUnit_of_measure(String unit_of_measure) {
        this.unit_of_measure = unit_of_measure;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
