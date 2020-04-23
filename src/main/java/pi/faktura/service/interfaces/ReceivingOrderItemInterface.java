package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Receiving_order_item;

public interface ReceivingOrderItemInterface {

    Receiving_order_item findOne(Long id);
    Page<Receiving_order_item> findAll(Pageable pageable);
    Receiving_order_item save(Receiving_order_item receiving_order_item);
    Receiving_order_item update(Receiving_order_item receiving_order_item);
    void delete(Receiving_order_item receiving_order_item);

}
