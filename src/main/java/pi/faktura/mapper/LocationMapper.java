package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.LocationDTO;
import pi.faktura.model.Location;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LocationMapper implements Mapper<Location, LocationDTO> {

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    BusinessPartnerMapper businessPartnerMapper;

    @Override
    public LocationDTO toDTO(Location entity) {

        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(entity.getId());
        locationDTO.setCity(entity.getCity());
        locationDTO.setZip_code(entity.getZip_code());
        locationDTO.setCompanieDTOs(companyMapper.toDTO(entity.getCompanies()));
        locationDTO.setBusiness_partnerDTOs(businessPartnerMapper.toDTO(entity.getBusiness_partners()));
        locationDTO.setDeleted(entity.isDeleted());

        return locationDTO;
    }

    @Override
    public Location toEntity(LocationDTO locationDTO) {

        Location location = new Location();
        location.setCity(locationDTO.getCity());
        location.setZip_code(locationDTO.getZip_code());
        location.setCompanies(companyMapper.toEntity(locationDTO.getCompanieDTOs()));
        location.setBusiness_partners(businessPartnerMapper.toEntity(locationDTO.getBusiness_partnerDTOs()));
        location.setDeleted(locationDTO.isDeleted());

        return location;
    }

    @Override
    public Set<LocationDTO> toDTO(Collection<Location> entities) {
        return entities
                .stream()
                .map(location -> toDTO(location))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Location> toEntity(Collection<LocationDTO> locationDTOS) {
        return locationDTOS
                .stream()
                .map(locationDTO -> toEntity(locationDTO))
                .collect(Collectors.toSet());
    }
}
