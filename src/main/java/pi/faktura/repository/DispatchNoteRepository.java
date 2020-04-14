package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Dispatch_note;

@Repository
public interface DispatchNoteRepository extends JpaRepository<Dispatch_note, Long> {
}
