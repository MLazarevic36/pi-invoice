package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.BusinessPartnerDTO;
import pi.faktura.model.Business_partner;

import java.text.ParseException;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BusinessPartnerMapper  {

    @Autowired
    private ModelMapper modelMapper;


    public BusinessPartnerDTO convertToDto(Business_partner business_partner) {
        BusinessPartnerDTO businessPartnerDTO = modelMapper.map(business_partner, BusinessPartnerDTO.class);
        return businessPartnerDTO;
    }

    public  Set<BusinessPartnerDTO> convertToDtos(Page<Business_partner> business_partnerPage) {
        return business_partnerPage.stream().map(business_partner -> convertToDto(business_partner)).collect(Collectors.toSet());
    }

    public Business_partner convertToEntity(BusinessPartnerDTO businessPartnerDTO) {
        Business_partner business_partner = modelMapper.map(businessPartnerDTO, Business_partner.class);
        return business_partner;
    }

    public Set<Business_partner> convertToEntities(Collection<BusinessPartnerDTO> businessPartnerDTOS) {
        return businessPartnerDTOS
                .stream()
                .map(businessPartnerDTO -> convertToEntity(businessPartnerDTO))
                .collect(Collectors.toSet());
    }


}
