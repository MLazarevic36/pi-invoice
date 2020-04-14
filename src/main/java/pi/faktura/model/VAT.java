package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vat")
public class VAT implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="vat_id", unique=true, nullable=false)
    private Long id;

    @Column(name="name", unique=false, nullable=false, length = 50)
    private String name;

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "vat")
    private Set<VAT_rate> rates = new HashSet<VAT_rate>();

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "vat")
    private Set<Goods_group> groups = new HashSet<Goods_group>();

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;
}
