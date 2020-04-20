package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.BusinessPartnerDTO;
import pi.faktura.model.Business_partner;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BusinessPartnerMapper implements Mapper<Business_partner, BusinessPartnerDTO> {

    @Autowired
    LocationMapper locationMapper;

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    DispatchNoteMapper dispatchNoteMapper;

    @Autowired
    ReceivingOrderMapper receivingOrderMapper;

    @Autowired
    InvoiceMapper invoiceMapper;

    @Override
    public BusinessPartnerDTO toDTO(Business_partner entity) {

        BusinessPartnerDTO businessPartnerDTO = new BusinessPartnerDTO();
        businessPartnerDTO.setId(entity.getId());
        businessPartnerDTO.setName(entity.getName());
        businessPartnerDTO.setCreation_date(entity.getCreation_date());
        businessPartnerDTO.setAddress(entity.getAddress());
        businessPartnerDTO.setTax_id(entity.getTax_id());
        businessPartnerDTO.setLocation(locationMapper.toDTO(entity.getLocation()));
        businessPartnerDTO.setCompany(companyMapper.toDTO(entity.getCompany()));
        businessPartnerDTO.setBusiness_partner_type(entity.getBusiness_partner_type());
        businessPartnerDTO.setDispatch_notes(dispatchNoteMapper.toDTO(entity.getDispatch_notes()));
        businessPartnerDTO.setReceiving_orders(receivingOrderMapper.toDTOList(entity.getReceiving_orders()));
        businessPartnerDTO.setInvoices(invoiceMapper.toDTOList(entity.getInvoices()));
        businessPartnerDTO.setDeleted(entity.getDeleted());

        return businessPartnerDTO;
    }

    @Override
    public Business_partner toEntity(BusinessPartnerDTO businessPartnerDTO) {

        Business_partner business_partner = new Business_partner();

        business_partner.setName(businessPartnerDTO.getName());
        business_partner.setCreation_date(businessPartnerDTO.getCreation_date());
        business_partner.setAddress(businessPartnerDTO.getAddress());
        business_partner.setTax_id(businessPartnerDTO.getTax_id());
        business_partner.setLocation(locationMapper.toEntity(businessPartnerDTO.getLocation()));
        business_partner.setCompany(companyMapper.toEntity(businessPartnerDTO.getCompany()));
        business_partner.setDispatch_notes(dispatchNoteMapper.toEntity(businessPartnerDTO.getDispatch_notes()));
        business_partner.setReceiving_orders(receivingOrderMapper.toEntityList(businessPartnerDTO.getReceiving_orders()));
        business_partner.setInvoices(invoiceMapper.toEntityList(businessPartnerDTO.getInvoices()));
        business_partner.setDeleted(businessPartnerDTO.getDeleted());

        return business_partner;
    }

    public Business_partner toEntityWithId(BusinessPartnerDTO businessPartnerDTO) {

        Business_partner business_partner = new Business_partner();

        business_partner.setId(businessPartnerDTO.getId());
        business_partner.setName(businessPartnerDTO.getName());
        business_partner.setCreation_date(businessPartnerDTO.getCreation_date());
        business_partner.setAddress(businessPartnerDTO.getAddress());
        business_partner.setTax_id(businessPartnerDTO.getTax_id());
        business_partner.setLocation(locationMapper.toEntity(businessPartnerDTO.getLocation()));
        business_partner.setCompany(companyMapper.toEntity(businessPartnerDTO.getCompany()));
        business_partner.setDispatch_notes(dispatchNoteMapper.toEntity(businessPartnerDTO.getDispatch_notes()));
        business_partner.setReceiving_orders(receivingOrderMapper.toEntityList(businessPartnerDTO.getReceiving_orders()));
        business_partner.setInvoices(invoiceMapper.toEntityList(businessPartnerDTO.getInvoices()));
        business_partner.setDeleted(businessPartnerDTO.getDeleted());

        return business_partner;
    }

    @Override
    public Set<BusinessPartnerDTO> toDTO(Collection<Business_partner> entities) {
        return entities
                .stream()
                .map(business_partner -> toDTO(business_partner))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Business_partner> toEntity(Collection<BusinessPartnerDTO> businessPartnerDTOS) {
        return businessPartnerDTOS
                .stream()
                .map(businessPartnerDTO -> toEntity(businessPartnerDTO))
                .collect(Collectors.toSet());
    }
}
