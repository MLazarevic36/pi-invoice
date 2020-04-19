package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.VAT;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class VatDTO implements Serializable {

    private Long id;
    private String name;
    private boolean deleted;

    public VatDTO(Long id, String name, boolean deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
    }

    public VatDTO(VAT v) {
        this(v.getId(), v.getName(), v.isDeleted());
    }
}
