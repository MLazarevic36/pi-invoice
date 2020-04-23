package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Dispatch_note;
import pi.faktura.repository.DispatchNoteRepository;
import pi.faktura.service.interfaces.DispatchNoteInterface;

@Service
public class DispatchNoteService implements DispatchNoteInterface {

    @Autowired
    private DispatchNoteRepository dispatchNoteRepository;

    @Override
    public Dispatch_note findOne(Long id) {
        return dispatchNoteRepository.getOne(id);
    }

    @Override
    public Page<Dispatch_note> findAll(Pageable pageable) {
        return dispatchNoteRepository.findAll(pageable);
    }

    @Override
    public Dispatch_note save(Dispatch_note dispatch_note) {
        return dispatchNoteRepository.save(dispatch_note);
    }

    @Override
    public Dispatch_note update(Dispatch_note dispatch_note) {
        return dispatchNoteRepository.save(dispatch_note);
    }

    @Override
    public void delete(Dispatch_note dispatch_note) {

        dispatch_note.setDeleted(true);
        dispatchNoteRepository.save(dispatch_note);

    }
}
