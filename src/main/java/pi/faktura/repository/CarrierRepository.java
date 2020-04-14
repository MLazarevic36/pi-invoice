package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Carrier;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {
}
