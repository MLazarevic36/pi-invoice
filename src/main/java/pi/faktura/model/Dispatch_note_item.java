package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


@NoArgsConstructor
@Entity
@Table(name = "dispatch_note_items")
public class Dispatch_note_item implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="dispatch_note_item_id", unique=true, nullable=false)
    private Long id;

    @Column(name="dispatch_note_item_number", nullable=false, length = 50)
    private Long number;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "delivered_quantity")
    private Long delivered_quantity;

    @Column(name = "note")
    private String note;

    @Column(name = "measure_of_unit")
    private String measure_of_unit;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="goods_id")
    private Goods goods;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="dispatch_note_id")
    private Dispatch_note dispatch_note;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDelivered_quantity() {
        return delivered_quantity;
    }

    public void setDelivered_quantity(Long delivered_quantity) {
        this.delivered_quantity = delivered_quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMeasure_of_unit() {
        return measure_of_unit;
    }

    public void setMeasure_of_unit(String measure_of_unit) {
        this.measure_of_unit = measure_of_unit;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Dispatch_note getDispatch_note() {
        return dispatch_note;
    }

    public void setDispatch_note(Dispatch_note dispatch_note) {
        this.dispatch_note = dispatch_note;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
