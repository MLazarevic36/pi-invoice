package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@Entity
@Table(name = "receiving_order_items")
public class Receiving_order_item implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="receiving_order_item_id", unique=true, nullable=false)
    private Long id;

    @Column(name="name", nullable=false, length = 50)
    private String name;

    @Column(name="quantity", nullable=false, length = 20)
    private Long quantity;

    @Column(name="unit_of_measure", nullable=false, length = 50)
    private String unit_of_measure;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="receiving_order_id")
    private Receiving_order receiving_order;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="goods_id")
    private Goods goods;

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;

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

    public Receiving_order getReceiving_order() {
        return receiving_order;
    }

    public void setReceiving_order(Receiving_order receiving_order) {
        this.receiving_order = receiving_order;
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
