package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Carrier;

public interface CarrierInterface {

    Carrier findOne(Long id);
    Page<Carrier> findAll(Pageable pageable);
    Carrier save(Carrier carrier);
    Carrier update(Carrier carrier);
    void delete(Carrier carrier);

}
