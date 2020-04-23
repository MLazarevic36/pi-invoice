package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Dispatch_note_item;
import pi.faktura.repository.DispatchNoteItemRepository;
import pi.faktura.service.interfaces.DispatchNoteItemInterface;

@Service
public class DispatchNoteItemService implements DispatchNoteItemInterface {

    @Autowired
    private DispatchNoteItemRepository dispatchNoteItemRepository;

    @Override
    public Dispatch_note_item findOne(Long id) {
        return dispatchNoteItemRepository.getOne(id);
    }

    @Override
    public Page<Dispatch_note_item> findAll(Pageable pageable) {
        return dispatchNoteItemRepository.findAll(pageable);
    }

    @Override
    public Dispatch_note_item save(Dispatch_note_item dispatch_note_item) {
        return dispatchNoteItemRepository.save(dispatch_note_item);
    }

    @Override
    public Dispatch_note_item update(Dispatch_note_item dispatch_note_item) {
        return dispatchNoteItemRepository.save(dispatch_note_item);
    }

    @Override
    public void delete(Dispatch_note_item dispatch_note_item) {
        dispatch_note_item.setDeleted(true);
        dispatchNoteItemRepository.save(dispatch_note_item);
    }
}
