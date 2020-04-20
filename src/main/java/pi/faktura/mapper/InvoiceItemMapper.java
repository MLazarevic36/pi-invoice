package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.InvoiceItemDTO;
import pi.faktura.model.Invoice_item;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InvoiceItemMapper implements Mapper<Invoice_item, InvoiceItemDTO> {

    @Autowired
    InvoiceMapper invoiceMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public InvoiceItemDTO toDTO(Invoice_item entity) {

        InvoiceItemDTO invoiceItemDTO = new InvoiceItemDTO();

        invoiceItemDTO.setId(entity.getId());
        invoiceItemDTO.setQuantity(entity.getQuantity());
        invoiceItemDTO.setUnit_price(entity.getUnit_price());
        invoiceItemDTO.setRebate(entity.getRebate());
        invoiceItemDTO.setBase_for_vat(entity.getBase_for_vat());
        invoiceItemDTO.setVat_percent(entity.getVat_percent());
        invoiceItemDTO.setVat_amount(entity.getVat_amount());
        invoiceItemDTO.setItem_amount(entity.getItem_amount());
        invoiceItemDTO.setUnit_of_measure(entity.getUnit_of_measure());
        invoiceItemDTO.setInvoice(invoiceMapper.toDTO(entity.getInvoice()));
        invoiceItemDTO.setGoods(goodsMapper.toDTO(entity.getGoods()));
        invoiceItemDTO.setDeleted(entity.isDeleted());

        return invoiceItemDTO;
    }

    @Override
    public Invoice_item toEntity(InvoiceItemDTO invoiceItemDTO) {

        Invoice_item invoice_item = new Invoice_item();

        invoice_item.setQuantity(invoiceItemDTO.getQuantity());
        invoice_item.setUnit_price(invoiceItemDTO.getUnit_price());
        invoice_item.setRebate(invoiceItemDTO.getRebate());
        invoice_item.setBase_for_vat(invoiceItemDTO.getBase_for_vat());
        invoice_item.setVat_percent(invoiceItemDTO.getVat_percent());
        invoice_item.setVat_amount(invoiceItemDTO.getVat_amount());
        invoice_item.setItem_amount(invoiceItemDTO.getItem_amount());
        invoice_item.setUnit_of_measure(invoiceItemDTO.getUnit_of_measure());
        invoice_item.setInvoice(invoiceMapper.toEntity(invoiceItemDTO.getInvoice()));
        invoice_item.setGoods(goodsMapper.toEntity(invoiceItemDTO.getGoods()));
        invoice_item.setDeleted(invoiceItemDTO.isDeleted());

        return invoice_item;
    }

    public Invoice_item toEntityWithId(InvoiceItemDTO invoiceItemDTO) {

        Invoice_item invoice_item = new Invoice_item();

        invoice_item.setId(invoiceItemDTO.getId());
        invoice_item.setQuantity(invoiceItemDTO.getQuantity());
        invoice_item.setUnit_price(invoiceItemDTO.getUnit_price());
        invoice_item.setRebate(invoiceItemDTO.getRebate());
        invoice_item.setBase_for_vat(invoiceItemDTO.getBase_for_vat());
        invoice_item.setVat_percent(invoiceItemDTO.getVat_percent());
        invoice_item.setVat_amount(invoiceItemDTO.getVat_amount());
        invoice_item.setItem_amount(invoiceItemDTO.getItem_amount());
        invoice_item.setUnit_of_measure(invoiceItemDTO.getUnit_of_measure());
        invoice_item.setInvoice(invoiceMapper.toEntity(invoiceItemDTO.getInvoice()));
        invoice_item.setGoods(goodsMapper.toEntity(invoiceItemDTO.getGoods()));
        invoice_item.setDeleted(invoiceItemDTO.isDeleted());

        return invoice_item;
    }

    @Override
    public Set<InvoiceItemDTO> toDTO(Collection<Invoice_item> entities) {
        return entities
                .stream()
                .map(invoice_item -> toDTO(invoice_item))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Invoice_item> toEntity(Collection<InvoiceItemDTO> invoiceItemDTOS) {
        return invoiceItemDTOS
                .stream()
                .map(invoiceItemDTO -> toEntity(invoiceItemDTO))
                .collect(Collectors.toSet());
    }

    public List<InvoiceItemDTO> toDTOList(Collection<Invoice_item> entities) {
        return null;
    }

    public List<Invoice_item> toEntityList(Collection<InvoiceItemDTO> invoiceItemDTOS) {
        return null;
    }
}
