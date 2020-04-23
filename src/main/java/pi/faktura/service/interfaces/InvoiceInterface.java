package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Invoice;

public interface InvoiceInterface {

    Invoice findOne(Long id);
    Page<Invoice> findAll(Pageable pageable);
    Invoice save(Invoice invoice);
    Invoice update(Invoice invoice);
    void delete(Invoice invoice);
}
