package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Receiving_order;

public interface ReceivingOrderInterface {

    Receiving_order findOne(Long id);
    Page<Receiving_order> findAll(Pageable pageable);
    Receiving_order save(Receiving_order receiving_order);
    Receiving_order update(Receiving_order receiving_order);
    void delete(Receiving_order receiving_order);
}
