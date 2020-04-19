package pi.faktura.dto;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
public class VatRateDTO implements Serializable{

    private Long id;
    private Long percent;
    private Date expiration_date;
    private VatDTO vat;
    private boolean deleted;

    public VatRateDTO(Long id, Long percent, Date expiration_date, VatDTO vat, boolean deleted) {
        this.id = id;
        this.percent = percent;
        this.expiration_date = expiration_date;
        this.vat = vat;
        this.deleted = deleted;
    }

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

    public VatDTO getVat() {
        return vat;
    }

    public void setVat(VatDTO vat) {
        this.vat = vat;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
