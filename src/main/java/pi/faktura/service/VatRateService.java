package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.VAT_rate;
import pi.faktura.repository.VATRateRepository;
import pi.faktura.service.interfaces.VatRateInterface;

@Service
public class VatRateService implements VatRateInterface {

    @Autowired
    private VATRateRepository vatRateRepository;

    @Override
    public VAT_rate findOne(Long id) {
        return vatRateRepository.getOne(id);
    }

    @Override
    public Page<VAT_rate> findAll(Pageable pageable) {
        return vatRateRepository.findAll(pageable);
    }

    @Override
    public VAT_rate save(VAT_rate vat_rate) {
        return vatRateRepository.save(vat_rate);
    }

    @Override
    public VAT_rate update(VAT_rate vat_rate) {
        return vatRateRepository.save(vat_rate);
    }

    @Override
    public void delete(VAT_rate vat_rate) {
        vat_rate.setDeleted(true);
        vatRateRepository.save(vat_rate);
    }
}
