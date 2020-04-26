package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.InvoiceItemDTO;
import pi.faktura.model.Invoice_item;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InvoiceItemMapper  {

    @Autowired
    private ModelMapper modelMapper;


    public InvoiceItemDTO convertToDto(Invoice_item invoice_item) {
        InvoiceItemDTO invoiceItemDTO = modelMapper.map(invoice_item, InvoiceItemDTO.class);
        return invoiceItemDTO;
    }

    public  Set<InvoiceItemDTO> convertToDtos(Page<Invoice_item> invoice_itemsPage) {
        return invoice_itemsPage.stream().map(invoice_item -> convertToDto(invoice_item)).collect(Collectors.toSet());
    }

    public Invoice_item convertToEntity(InvoiceItemDTO invoiceItemDTO) {
        Invoice_item invoice_item = modelMapper.map(invoiceItemDTO, Invoice_item.class);
        return invoice_item;
    }

    public Set<Invoice_item> convertToEntities(Collection<InvoiceItemDTO> invoiceItemDTOS) {
        return invoiceItemDTOS
                .stream()
                .map(invoiceItemDTO -> convertToEntity(invoiceItemDTO))
                .collect(Collectors.toSet());
    }
}
