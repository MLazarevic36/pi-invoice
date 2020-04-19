package pi.faktura.dto;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class InvoiceItemDTO implements Serializable {

    private Long id;
    private Long quantity;
    private Long unit_price;
    private Long rebate;
    private Long base_for_vat;
    private Long vat_percent;
    private Long vat_amount;
    private Long item_amount;
    private String unit_of_measure;
    private InvoiceDTO invoice;
    private GoodsDTO goods;
    private boolean deleted;

    public InvoiceItemDTO(Long id, Long quantity, Long unit_price, Long rebate, Long base_for_vat, Long vat_percent, Long vat_amount, Long item_amount, String unit_of_measure, InvoiceDTO invoice, GoodsDTO goods, boolean deleted) {
        this.id = id;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.rebate = rebate;
        this.base_for_vat = base_for_vat;
        this.vat_percent = vat_percent;
        this.vat_amount = vat_amount;
        this.item_amount = item_amount;
        this.unit_of_measure = unit_of_measure;
        this.invoice = invoice;
        this.goods = goods;
        this.deleted = deleted;
    }

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

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDTO invoice) {
        this.invoice = invoice;
    }

    public GoodsDTO getGoods() {
        return goods;
    }

    public void setGoods(GoodsDTO goods) {
        this.goods = goods;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
