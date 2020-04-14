package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
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

}
