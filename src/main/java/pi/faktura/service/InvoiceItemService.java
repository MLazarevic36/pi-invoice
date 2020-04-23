package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Invoice_item;
import pi.faktura.repository.InvoiceItemRepository;
import pi.faktura.service.interfaces.InvoiceItemInterface;

@Service
public class InvoiceItemService implements InvoiceItemInterface {

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Override
    public Invoice_item findOne(Long id) {
        return invoiceItemRepository.getOne(id);
    }

    @Override
    public Page<Invoice_item> findAll(Pageable pageable) {
        return invoiceItemRepository.findAll(pageable);
    }

    @Override
    public Invoice_item save(Invoice_item invoice_item) {
        return invoiceItemRepository.save(invoice_item);
    }

    @Override
    public Invoice_item update(Invoice_item invoice_item) {
        return invoiceItemRepository.save(invoice_item);
    }

    @Override
    public void delete(Invoice_item invoice_item) {
        invoice_item.setDeleted(true);
        invoiceItemRepository.save(invoice_item);
    }
}
