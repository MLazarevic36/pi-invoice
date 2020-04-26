package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.InvoiceDTO;
import pi.faktura.model.Invoice;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InvoiceMapper  {

    @Autowired
    private ModelMapper modelMapper;


    public InvoiceDTO convertToDto(Invoice invoice) {
        InvoiceDTO invoiceDTO = modelMapper.map(invoice, InvoiceDTO.class);
        return invoiceDTO;
    }

    public  Set<InvoiceDTO> convertToDtos(Page<Invoice> invoicePage) {
        return invoicePage.stream().map(invoice -> convertToDto(invoice)).collect(Collectors.toSet());
    }

    public Invoice convertToEntity(InvoiceDTO invoiceDTO) {
        Invoice invoice = modelMapper.map(invoiceDTO, Invoice.class);
        return invoice;
    }

    public Set<Invoice> convertToEntities(Collection<InvoiceDTO> invoiceDTOS) {
        return invoiceDTOS
                .stream()
                .map(invoiceDTO -> convertToEntity(invoiceDTO))
                .collect(Collectors.toSet());
    }
}
