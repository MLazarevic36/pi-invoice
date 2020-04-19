package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Company;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO implements Serializable {

    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Long tax_identification_number;
    private LocationDTO location;
    private Boolean deleted;

    public CompanyDTO(Long id, String name, String address, String email, String phone, Long tax_identification_number, LocationDTO location, Boolean deleted) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.tax_identification_number = tax_identification_number;
        this.location = location;
        this.deleted = deleted;
    }

    public CompanyDTO(Company c) {
        this(c.getId(), c.getName(), c.getAddress(), c.getEmail(), c.getPhone(),
                c.getTax_identification_number(), new LocationDTO(c.getLocation()), c.isDeleted());
    }

}
