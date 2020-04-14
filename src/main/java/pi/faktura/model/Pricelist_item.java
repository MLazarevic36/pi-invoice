package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pricelist_items")
public class Pricelist_item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricelist_item_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "goods_id", nullable = true)
    private Goods goods;

    @ManyToOne
    @JoinColumn(name = "pricelist_id", referencedColumnName = "pricelist_id", nullable = true)
    private Pricelist pricelist;

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;
}
