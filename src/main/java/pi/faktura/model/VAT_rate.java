package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vat_rates")
public class VAT_rate implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="vat_rate_id", unique=true, nullable=false)
    private Long id;

    @Column(name="percent", nullable=false)
    private Long percent;

    @Column(name="expiration_date", nullable=false)
    private Date expiration_date;

    @ManyToOne
    @JoinColumn(name = "vat_id", referencedColumnName = "vat_id")
    private VAT vat;

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private boolean deleted;

}
