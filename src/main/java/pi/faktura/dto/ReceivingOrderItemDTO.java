package pi.faktura.dto;



import lombok.NoArgsConstructor;



import java.io.Serializable;

@NoArgsConstructor
public class ReceivingOrderItemDTO implements Serializable {

    private Long id;
    private String name;
    private Long quantity;
    private String unit_of_measure;
    private ReceivingOrderDTO receiving_order;
    private GoodsDTO goods;
    private boolean deleted;

    public ReceivingOrderItemDTO(Long id, String name, Long quantity, String unit_of_measure, ReceivingOrderDTO receiving_order, GoodsDTO goods, boolean deleted) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit_of_measure = unit_of_measure;
        this.receiving_order = receiving_order;
        this.goods = goods;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getUnit_of_measure() {
        return unit_of_measure;
    }

    public void setUnit_of_measure(String unit_of_measure) {
        this.unit_of_measure = unit_of_measure;
    }

    public ReceivingOrderDTO getReceiving_order() {
        return receiving_order;
    }

    public void setReceiving_order(ReceivingOrderDTO receiving_order) {
        this.receiving_order = receiving_order;
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
