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
}
