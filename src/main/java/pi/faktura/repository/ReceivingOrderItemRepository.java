package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Receiving_order_item;

@Repository
public interface ReceivingOrderItemRepository extends JpaRepository<Receiving_order_item, Long> {
}
