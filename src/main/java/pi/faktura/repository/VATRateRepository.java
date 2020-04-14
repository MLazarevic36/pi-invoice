package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.VAT_rate;

@Repository
public interface VATRateRepository extends JpaRepository<VAT_rate, Long> {
}
