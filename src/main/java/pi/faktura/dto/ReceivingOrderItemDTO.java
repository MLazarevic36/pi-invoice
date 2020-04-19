package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Receiving_order;
import pi.faktura.model.Receiving_order_item;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ReceivingOrderItemDTO implements Serializable {

    private Long id;
    private String name;
    private Long quantity;
    private String unit_of_measure;
    private ReceivingOrderDTO receiving_order;
    private GoodsDTO goods;
    private boolean deleted;

    public ReceivingOrderItemDTO(Long id, String name, Long quantity, String unit_of_measure,
                                 ReceivingOrderDTO receiving_order, GoodsDTO goods, boolean deleted) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit_of_measure = unit_of_measure;
        this.receiving_order = receiving_order;
        this.goods = goods;
        this.deleted = deleted;
    }

    public ReceivingOrderItemDTO(Receiving_order_item r) {
        this(r.getId(), r.getName(), r.getQuantity(), r.getUnit_of_measure(), new ReceivingOrderDTO(r.getReceiving_order()),
                new GoodsDTO(r.getGoods()), r.isDeleted());
    }
}
