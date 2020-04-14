package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Pricelist_item;

@Repository
public interface PricelistItemRepository extends JpaRepository<Pricelist_item, Long> {
}
