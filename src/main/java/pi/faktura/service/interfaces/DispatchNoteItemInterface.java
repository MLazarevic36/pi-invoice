package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Dispatch_note_item;

public interface DispatchNoteItemInterface {

    Dispatch_note_item findOne(Long id);
    Page<Dispatch_note_item> findAll(Pageable pageable);
    Dispatch_note_item save(Dispatch_note_item dispatch_note_item);
    Dispatch_note_item update(Dispatch_note_item dispatch_note_item);
    void delete(Dispatch_note_item dispatch_note_item);

}
