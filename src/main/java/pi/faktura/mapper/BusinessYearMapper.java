package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.BusinessYearDTO;
import pi.faktura.model.Business_year;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BusinessYearMapper implements Mapper<Business_year, BusinessYearDTO> {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public BusinessYearDTO toDTO(Business_year entity) {

        BusinessYearDTO businessYearDTO = new BusinessYearDTO();

        businessYearDTO.setId(entity.getId());
        businessYearDTO.setYear(entity.getYear());
        businessYearDTO.setStart_date(entity.getStart_date());
        businessYearDTO.setEnd_date(entity.getEnd_date());
        businessYearDTO.setCompany(companyMapper.toDTO(entity.getCompany()));
        businessYearDTO.setFinished(entity.getFinished());

        return businessYearDTO;
    }

    @Override
    public Business_year toEntity(BusinessYearDTO businessYearDTO) {

        Business_year business_year = new Business_year();

        business_year.setYear(businessYearDTO.getYear());
        business_year.setStart_date(businessYearDTO.getStart_date());
        business_year.setEnd_date(businessYearDTO.getEnd_date());
        business_year.setCompany(companyMapper.toEntity(businessYearDTO.getCompany()));
        business_year.setFinished(businessYearDTO.getFinished());

        return business_year;
    }

    public Business_year toEntityWithId(BusinessYearDTO businessYearDTO) {

        Business_year business_year = new Business_year();

        business_year.setId(businessYearDTO.getId());
        business_year.setYear(businessYearDTO.getYear());
        business_year.setStart_date(businessYearDTO.getStart_date());
        business_year.setEnd_date(businessYearDTO.getEnd_date());
        business_year.setCompany(companyMapper.toEntity(businessYearDTO.getCompany()));
        business_year.setFinished(businessYearDTO.getFinished());

        return business_year;
    }

    @Override
    public Set<BusinessYearDTO> toDTO(Collection<Business_year> entities) {
        return entities
                .stream()
                .map(business_year -> toDTO(business_year))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Business_year> toEntity(Collection<BusinessYearDTO> businessYearDTOS) {
        return businessYearDTOS
                .stream()
                .map(businessYearDTO -> toEntity(businessYearDTO))
                .collect(Collectors.toSet());
    }
}
