package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Invoice;
import pi.faktura.repository.InvoiceRepository;
import pi.faktura.service.interfaces.InvoiceInterface;

@Service
public class InvoiceService implements InvoiceInterface {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice findOne(Long id) {
        return invoiceRepository.getOne(id);
    }

    @Override
    public Page<Invoice> findAll(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void delete(Invoice invoice) {

        invoice.setDeleted(true);
        invoiceRepository.save(invoice);

    }
}
