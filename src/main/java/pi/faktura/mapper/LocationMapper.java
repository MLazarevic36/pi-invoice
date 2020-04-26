package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.LocationDTO;
import pi.faktura.model.Location;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LocationMapper {

    @Autowired
    private ModelMapper modelMapper;


    public LocationDTO convertToDto(Location location) {
        LocationDTO locationDTO = modelMapper.map(location, LocationDTO.class);
        return locationDTO;
    }

    public  Set<LocationDTO> convertToDtos(Page<Location> locationPage) {
        return locationPage.stream().map(location -> convertToDto(location)).collect(Collectors.toSet());
    }

    public Location convertToEntity(LocationDTO locationDTO) {
        Location location = modelMapper.map(locationDTO, Location.class);
        return location;
    }

    public Set<Location> convertToEntities(Collection<LocationDTO> locationDTOS) {
        return locationDTOS
                .stream()
                .map(locationDTO -> convertToEntity(locationDTO))
                .collect(Collectors.toSet());
    }
}
