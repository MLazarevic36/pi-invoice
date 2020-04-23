package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.VAT;

public interface VatInterface {

    VAT findOne(Long id);
    Page<VAT> findAll(Pageable pageable);
    VAT save(VAT vat);
    VAT update(VAT vat);
    void delete(VAT vat);

}
