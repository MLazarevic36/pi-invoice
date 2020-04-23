package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.VAT_rate;

public interface VatRateInterface {

    VAT_rate findOne(Long id);
    Page<VAT_rate> findAll(Pageable pageable);
    VAT_rate save(VAT_rate vat_rate);
    VAT_rate update(VAT_rate vat_rate);
    void delete(VAT_rate vat_rate);

}
