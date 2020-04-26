package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.BusinessYearDTO;
import org.modelmapper.ModelMapper;
import pi.faktura.model.Business_year;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BusinessYearMapper  {

    @Autowired
    private ModelMapper modelMapper;


    public BusinessYearDTO convertToDto(Business_year business_year) {
        BusinessYearDTO businessYearDTO = modelMapper.map(business_year, BusinessYearDTO.class);
        return businessYearDTO;
    }

    public Set<BusinessYearDTO> convertToDtos(Page<Business_year> business_yearPage) {
        return business_yearPage.stream().map(business_year -> convertToDto(business_year)).collect(Collectors.toSet());
    }

    public Business_year convertToEntity(BusinessYearDTO businessYearDTO) {
        Business_year business_year = modelMapper.map(businessYearDTO, Business_year.class);
        return business_year;
    }

    public Set<Business_year> convertToEntities(Collection<BusinessYearDTO> businessYearDTOS) {
        return businessYearDTOS
                .stream()
                .map(businessYearDTO -> convertToEntity(businessYearDTO))
                .collect(Collectors.toSet());
    }
}
