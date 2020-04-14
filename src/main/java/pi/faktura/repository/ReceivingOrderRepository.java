package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Receiving_order;

@Repository
public interface ReceivingOrderRepository extends JpaRepository<Receiving_order, Long> {
}
