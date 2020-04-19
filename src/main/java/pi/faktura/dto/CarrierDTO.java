package pi.faktura.dto;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
public class CarrierDTO implements Serializable {

    private Long id;
    private String name;
    private Set<DispatchNoteDTO> dispatch_notes = new HashSet<>();
    private Boolean deleted;

    public CarrierDTO(Long id, String name, Set<DispatchNoteDTO> dispatch_notes, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.dispatch_notes = dispatch_notes;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DispatchNoteDTO> getDispatch_notes() {
        return dispatch_notes;
    }

    public void setDispatch_notes(Set<DispatchNoteDTO> dispatch_notes) {
        this.dispatch_notes = dispatch_notes;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
