package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.VAT;

@Repository
public interface VATRepository extends JpaRepository<VAT, Long> {
}
