package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Business_partner;
import pi.faktura.model.Business_partner_type;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BusinessPartnerDTO implements Serializable {

    private Long id;
    private String name;
    private Date creation_date;
    private String address;
    private Long tax_id;
    private LocationDTO location;
    private CompanyDTO company;
    private Business_partner_type business_partner_type;
    private Boolean deleted;

    public BusinessPartnerDTO(Long id, String name, Date creation_date, String address, Long tax_id, LocationDTO location, CompanyDTO company, Business_partner_type business_partner_type, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.creation_date = creation_date;
        this.address = address;
        this.tax_id = tax_id;
        this.location = location;
        this.company = company;
        this.business_partner_type = business_partner_type;
        this.deleted = deleted;
    }

    public BusinessPartnerDTO(Business_partner b) {
        this(b.getId(), b.getName(), b.getCreation_date(), b.getAddress(), b.getTax_id(),
                new LocationDTO(b.getLocation()), new CompanyDTO(b.getCompany()), b.getBusiness_partner_type(),
                b.getDeleted());
    }

}
