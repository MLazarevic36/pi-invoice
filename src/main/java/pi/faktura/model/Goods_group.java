package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "goods_groups")
public class Goods_group implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="goods_group_id", unique=true, nullable=false)
    private Integer id;

    @Column(name="name", nullable=false, length = 50)
    private String name;

    @Column(name="creation_date", nullable=false)
    private Date creation_date;

    @ManyToOne
    @JoinColumn(name = "vat_id", referencedColumnName = "vat_id")
    private VAT vat;

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "group")
    private Set<Goods> goods = new HashSet<Goods>();

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;
}
