package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Pricelist;

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Long> {
}
