package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Invoice_item;

import java.io.Serializable;

@Getter
@Setter
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

    public InvoiceItemDTO(Long id, Long quantity, Long unit_price, Long rebate, Long base_for_vat,
                          Long vat_percent, Long vat_amount, Long item_amount, String unit_of_measure,
                          InvoiceDTO invoice, GoodsDTO goods, boolean deleted) {
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

    public InvoiceItemDTO(Invoice_item i) {
        this(i.getId(), i.getQuantity(), i.getUnit_price(), i.getRebate(), i.getBase_for_vat(), i.getVat_percent(),
                i.getVat_amount(), i.getItem_amount(), i.getUnit_of_measure(), new InvoiceDTO(i.getInvoice()),
                new GoodsDTO(i.getGoods()), i.isDeleted());
    }
}
