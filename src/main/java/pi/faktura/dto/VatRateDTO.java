package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.VAT;
import pi.faktura.model.VAT_rate;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
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

    public VatRateDTO(VAT_rate v) {
        this(v.getId(), v.getPercent(), v.getExpiration_date(), new VatDTO(v.getVat()), v.isDeleted());
    }
}
