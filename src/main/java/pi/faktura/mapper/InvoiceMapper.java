package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.InvoiceDTO;
import pi.faktura.model.Invoice;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InvoiceMapper implements Mapper<Invoice, InvoiceDTO> {

    @Autowired
    ReceivingOrderMapper receivingOrderMapper;

    @Autowired
    DispatchNoteMapper dispatchNoteMapper;

    @Autowired
    BusinessPartnerMapper businessPartnerMapper;

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    InvoiceItemMapper invoiceItemMapper;

    @Override
    public InvoiceDTO toDTO(Invoice entity) {

        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(entity.getId());
        invoiceDTO.setInvoice_number(entity.getInvoice_number());
        invoiceDTO.setInvoice_date(entity.getInvoice_date());
        invoiceDTO.setCurrency_date(entity.getCurrency_date());
        invoiceDTO.setBase(entity.getBase());
        invoiceDTO.setVat_total(entity.getVat_total());
        invoiceDTO.setAmount_to_be_paid(entity.getAmount_to_be_paid());
        invoiceDTO.setInvoice_status(entity.getInvoice_status());
        invoiceDTO.setReceiving_orderDTO(receivingOrderMapper.toDTO(entity.getReceiving_order()));
        invoiceDTO.setDispatch_noteDTO(dispatchNoteMapper.toDTO(entity.getDispatch_note()));
        invoiceDTO.setBusiness_partnerDTO(businessPartnerMapper.toDTO(entity.getBusiness_partner()));
        invoiceDTO.setCompanyDTO(companyMapper.toDTO(entity.getCompany()));
        invoiceDTO.setUserDTO(userMapper.toDTO(entity.getUser()));
        invoiceDTO.setDeleted(entity.isDeleted());

        return invoiceDTO;
    }

    @Override
    public Invoice toEntity(InvoiceDTO invoiceDTO) {

        Invoice invoice = new Invoice();
        invoice.setInvoice_number(invoiceDTO.getInvoice_number());
        invoice.setInvoice_date(invoiceDTO.getInvoice_date());
        invoice.setCurrency_date(invoiceDTO.getCurrency_date());
        invoice.setBase(invoiceDTO.getBase());
        invoice.setVat_total(invoiceDTO.getVat_total());
        invoice.setAmount_to_be_paid(invoiceDTO.getAmount_to_be_paid());
        invoice.setInvoice_status(invoiceDTO.getInvoice_status());
        invoice.setReceiving_order(receivingOrderMapper.toEntity(invoiceDTO.getReceiving_orderDTO()));
        invoice.setDispatch_note(dispatchNoteMapper.toEntity(invoiceDTO.getDispatch_noteDTO()));
        invoice.setBusiness_partner(businessPartnerMapper.toEntity(invoiceDTO.getBusiness_partnerDTO()));
        invoice.setCompany(companyMapper.toEntity(invoiceDTO.getCompanyDTO()));
        invoice.setUser(userMapper.toEntity(invoiceDTO.getUserDTO()));
        invoice.setDeleted(invoiceDTO.isDeleted());

        return invoice;
    }


    public Invoice toEntityWithId(InvoiceDTO invoiceDTO) {

        Invoice invoice = new Invoice();
        invoice.setId(invoiceDTO.getId());
        invoice.setInvoice_number(invoiceDTO.getInvoice_number());
        invoice.setInvoice_date(invoiceDTO.getInvoice_date());
        invoice.setCurrency_date(invoiceDTO.getCurrency_date());
        invoice.setBase(invoiceDTO.getBase());
        invoice.setVat_total(invoiceDTO.getVat_total());
        invoice.setAmount_to_be_paid(invoiceDTO.getAmount_to_be_paid());
        invoice.setInvoice_status(invoiceDTO.getInvoice_status());
        invoice.setReceiving_order(receivingOrderMapper.toEntity(invoiceDTO.getReceiving_orderDTO()));
        invoice.setDispatch_note(dispatchNoteMapper.toEntity(invoiceDTO.getDispatch_noteDTO()));
        invoice.setBusiness_partner(businessPartnerMapper.toEntity(invoiceDTO.getBusiness_partnerDTO()));
        invoice.setCompany(companyMapper.toEntity(invoiceDTO.getCompanyDTO()));
        invoice.setUser(userMapper.toEntity(invoiceDTO.getUserDTO()));
        invoice.setDeleted(invoiceDTO.isDeleted());

        return invoice;
    }


    @Override
    public Set<InvoiceDTO> toDTO(Collection<Invoice> entities) {
        return entities
                .stream()
                .map(invoice -> toDTO(invoice))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Invoice> toEntity(Collection<InvoiceDTO> invoiceDTOS) {
        return invoiceDTOS
                .stream()
                .map(invoiceDTO -> toEntity(invoiceDTO))
                .collect(Collectors.toSet());
    }

    public List<InvoiceDTO> toDTOList(Collection<Invoice> entities) {
        return null;
    }

    public List<Invoice> toEntityList(Collection<InvoiceDTO> invoiceDTOS) {
        return null;
    }
}
