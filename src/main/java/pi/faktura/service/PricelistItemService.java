package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Pricelist_item;
import pi.faktura.repository.PricelistItemRepository;
import pi.faktura.service.interfaces.PricelistItemInterface;

@Service
public class PricelistItemService implements PricelistItemInterface {

    @Autowired
    private PricelistItemRepository pricelistItemRepository;

    @Override
    public Pricelist_item findOne(Long id) {
        return pricelistItemRepository.getOne(id);
    }

    @Override
    public Page<Pricelist_item> findAll(Pageable pageable) {
        return pricelistItemRepository.findAll(pageable);
    }

    @Override
    public Pricelist_item save(Pricelist_item pricelist_item) {
        return pricelistItemRepository.save(pricelist_item);
    }

    @Override
    public Pricelist_item update(Pricelist_item pricelist_item) {
        return pricelistItemRepository.save(pricelist_item);
    }

    @Override
    public void delete(Pricelist_item pricelist_item) {
        pricelist_item.setDeleted(true);
        pricelistItemRepository.save(pricelist_item);
    }
}
