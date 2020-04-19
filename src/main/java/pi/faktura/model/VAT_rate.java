package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPercent() {
        return percent;
    }

    public void setPercent(Long percent) {
        this.percent = percent;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public VAT getVat() {
        return vat;
    }

    public void setVat(VAT vat) {
        this.vat = vat;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
