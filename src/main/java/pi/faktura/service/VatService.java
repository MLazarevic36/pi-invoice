package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.VAT;
import pi.faktura.repository.VATRepository;
import pi.faktura.service.interfaces.VatInterface;

@Service
public class VatService implements VatInterface {

    @Autowired
    private VATRepository vatRepository;

    @Override
    public VAT findOne(Long id) {
        return vatRepository.getOne(id);
    }

    @Override
    public Page<VAT> findAll(Pageable pageable) {
        return vatRepository.findAll(pageable);
    }

    @Override
    public VAT save(VAT vat) {
        return vatRepository.save(vat);
    }

    @Override
    public VAT update(VAT vat) {
        return vatRepository.save(vat);
    }

    @Override
    public void delete(VAT vat) {
        vat.setDeleted(true);
        vatRepository.save(vat);
    }
}
