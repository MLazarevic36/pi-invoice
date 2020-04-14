package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Dispatch_note_item;

@Repository
public interface DispatchNoteItemRepository extends JpaRepository<Dispatch_note_item, Long> {
}
