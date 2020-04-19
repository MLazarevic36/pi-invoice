package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;


@NoArgsConstructor
@Entity
@Table(name = "goods")
public class Goods implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="goods_id", unique=true, nullable=false)
    private Long id;

    @Column(name="name", nullable=false, length = 50)
    private String name;

    @Column(name = "measure_of_unit")
    private String unit_of_measure;

    @ManyToOne
    @JoinColumn(name = "goods_group_id", referencedColumnName = "goods_group_id")
    private Goods_group group;

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "goods")
    private Set<Pricelist_item> pricelist_items = new HashSet<Pricelist_item>();

    @OneToMany(mappedBy="goods", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Invoice_item> invoice_items;

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

    public String getUnit_of_measure() {
        return unit_of_measure;
    }

    public void setUnit_of_measure(String unit_of_measure) {
        this.unit_of_measure = unit_of_measure;
    }

    public Goods_group getGroup() {
        return group;
    }

    public void setGroup(Goods_group group) {
        this.group = group;
    }

    public Set<Pricelist_item> getPricelist_items() {
        return pricelist_items;
    }

    public void setPricelist_items(Set<Pricelist_item> pricelist_items) {
        this.pricelist_items = pricelist_items;
    }

    public List<Invoice_item> getInvoice_items() {
        return invoice_items;
    }

    public void setInvoice_items(List<Invoice_item> invoice_items) {
        this.invoice_items = invoice_items;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
