package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Pricelist;
import pi.faktura.repository.PricelistRepository;
import pi.faktura.service.interfaces.PricelistInterface;

@Service
public class PricelistService implements PricelistInterface {

    @Autowired
    private PricelistRepository pricelistRepository;

    @Override
    public Pricelist findOne(Long id) {
        return pricelistRepository.getOne(id);
    }

    @Override
    public Page<Pricelist> findAll(Pageable pageable) {
        return pricelistRepository.findAll(pageable);
    }

    @Override
    public Pricelist save(Pricelist pricelist) {
        return pricelistRepository.save(pricelist);
    }

    @Override
    public Pricelist update(Pricelist pricelist) {
        return pricelistRepository.save(pricelist);
    }

    @Override
    public void delete(Pricelist pricelist) {

        pricelist.setDeleted(true);
        pricelistRepository.save(pricelist);

    }
}
