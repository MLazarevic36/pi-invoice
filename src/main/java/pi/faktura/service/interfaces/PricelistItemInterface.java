package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Pricelist_item;

public interface PricelistItemInterface {

    Pricelist_item findOne(Long id);
    Page<Pricelist_item> findAll(Pageable pageable);
    Pricelist_item save(Pricelist_item pricelist_item);
    Pricelist_item update(Pricelist_item pricelist_item);
    void delete(Pricelist_item pricelist_item);
}
