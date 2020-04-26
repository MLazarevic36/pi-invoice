package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import pi.faktura.dto.CompanyDTO;
import pi.faktura.model.Company;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class CompanyMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CompanyDTO convertToDto(Company company) {
        CompanyDTO companyDTO = modelMapper.map(company, CompanyDTO.class);
        return companyDTO;
    }

    public Set<CompanyDTO> convertToDtos(Page<Company> companyPage) {
        return companyPage.stream().map(company -> convertToDto(company)).collect(Collectors.toSet());
    }

    public Company convertToEntity(CompanyDTO companyDTO) {
        Company company = modelMapper.map(companyDTO, Company.class);
        return company;
    }

    public Set<Company> convertToEntities(Collection<CompanyDTO> companyDTOS) {
        return companyDTOS
                .stream()
                .map(companyDTO -> convertToEntity(companyDTO))
                .collect(Collectors.toSet());
    }



}
