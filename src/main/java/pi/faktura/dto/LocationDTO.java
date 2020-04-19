package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Location;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class LocationDTO implements Serializable {

    private Long id;
    private String city;
    private Long zip_code;
    private boolean deleted;

    public LocationDTO(Long id, String city, Long zip_code, boolean deleted) {
        super();
        this.id = id;
        this.city = city;
        this.zip_code = zip_code;
        this.deleted = deleted;
    }

    public LocationDTO(Location l) {
        this(l.getId(), l.getCity(), l.getZip_code(), l.isDeleted());
    }
}
