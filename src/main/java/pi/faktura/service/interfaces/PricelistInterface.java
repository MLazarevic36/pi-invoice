package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Pricelist;

public interface PricelistInterface {

    Pricelist findOne(Long id);
    Page<Pricelist> findAll(Pageable pageable);
    Pricelist save(Pricelist pricelist);
    Pricelist update(Pricelist pricelist);
    void delete(Pricelist pricelist);

}
