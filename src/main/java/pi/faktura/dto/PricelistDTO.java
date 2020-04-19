package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Pricelist;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PricelistDTO implements Serializable {

    private Long id;
    private Long serial_number;
    private Date expiration_date;
    private Date creation_date;
    private boolean active;
    private CompanyDTO company;
    private boolean deleted;

    public PricelistDTO(Long id, Long serial_number, Date expiration_date, Date creation_date,
                        boolean active, CompanyDTO company, boolean deleted) {
        this.id = id;
        this.serial_number = serial_number;
        this.expiration_date = expiration_date;
        this.creation_date = creation_date;
        this.active = active;
        this.company = company;
        this.deleted = deleted;
    }

    public PricelistDTO(Pricelist p) {
        this(p.getId(), p.getSerial_number(), p.getExpiration_date(), p.getCreation_date(), p.isActive(),
                new CompanyDTO(p.getCompany()), p.isDeleted());

    }
}
