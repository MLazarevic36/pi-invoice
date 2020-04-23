package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Receiving_order_item;
import pi.faktura.repository.ReceivingOrderItemRepository;
import pi.faktura.service.interfaces.ReceivingOrderItemInterface;

@Service
public class ReceivingOrderItemService implements ReceivingOrderItemInterface {

    @Autowired
    ReceivingOrderItemRepository receivingOrderItemRepository;

    @Override
    public Receiving_order_item findOne(Long id) {
        return receivingOrderItemRepository.getOne(id);
    }

    @Override
    public Page<Receiving_order_item> findAll(Pageable pageable) {
        return receivingOrderItemRepository.findAll(pageable);
    }

    @Override
    public Receiving_order_item save(Receiving_order_item receiving_order_item) {
        return receivingOrderItemRepository.save(receiving_order_item);
    }

    @Override
    public Receiving_order_item update(Receiving_order_item receiving_order_item) {
        return receiving_order_item;
    }

    @Override
    public void delete(Receiving_order_item receiving_order_item) {
        receiving_order_item.setDeleted(true);
        receivingOrderItemRepository.save(receiving_order_item);
    }
}
