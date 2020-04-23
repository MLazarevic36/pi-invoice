package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Carrier;
import pi.faktura.repository.CarrierRepository;
import pi.faktura.service.interfaces.CarrierInterface;

@Service
public class CarrierService implements CarrierInterface {

    @Autowired
    private CarrierRepository carrierRepository;

    @Override
    public Carrier findOne(Long id) {
        return carrierRepository.getOne(id);
    }

    @Override
    public Page<Carrier> findAll(Pageable pageable) {
        return carrierRepository.findAll(pageable);
    }

    @Override
    public Carrier save(Carrier carrier) {
        return carrierRepository.save(carrier);
    }

    @Override
    public Carrier update(Carrier carrier) {
        return carrierRepository.save(carrier);
    }

    @Override
    public void delete(Carrier carrier) {
        carrier.setDeleted(true);
        carrierRepository.save(carrier);
    }
}
