package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Carrier;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CarrierDTO implements Serializable {

    private Long id;
    private String name;
    private Boolean deleted;

    public CarrierDTO(Long id, String name, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
    }

    public CarrierDTO(Carrier c) {
        this(c.getId(), c.getName(), c.getDeleted());
    }

}
