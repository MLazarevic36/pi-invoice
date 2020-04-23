package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Dispatch_note;

public interface DispatchNoteInterface {

    Dispatch_note findOne(Long id);
    Page<Dispatch_note> findAll(Pageable pageable);
    Dispatch_note save(Dispatch_note dispatch_note);
    Dispatch_note update(Dispatch_note dispatch_note);
    void delete(Dispatch_note dispatch_note);
}
