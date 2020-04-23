package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Receiving_order;
import pi.faktura.repository.ReceivingOrderRepository;
import pi.faktura.service.interfaces.ReceivingOrderInterface;

@Service
public class ReceivingOrderService implements ReceivingOrderInterface {

    @Autowired
    private ReceivingOrderRepository receivingOrderRepository;

    @Override
    public Receiving_order findOne(Long id) {
        return receivingOrderRepository.getOne(id);
    }

    @Override
    public Page<Receiving_order> findAll(Pageable pageable) {
        return receivingOrderRepository.findAll(pageable);
    }

    @Override
    public Receiving_order save(Receiving_order receiving_order) {
        return receivingOrderRepository.save(receiving_order);
    }

    @Override
    public Receiving_order update(Receiving_order receiving_order) {
        return receivingOrderRepository.save(receiving_order);
    }

    @Override
    public void delete(Receiving_order receiving_order) {
        receiving_order.setDeleted(true);
        receivingOrderRepository.save(receiving_order);
    }
}
