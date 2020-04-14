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

}
