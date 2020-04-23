package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Invoice_item;

public interface InvoiceItemInterface {

    Invoice_item findOne(Long id);
    Page<Invoice_item> findAll(Pageable pageable);
    Invoice_item save(Invoice_item invoice_item);
    Invoice_item update(Invoice_item invoice_item);
    void delete(Invoice_item invoice_item);

}
