package pi.faktura.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.CarrierDTO;
import pi.faktura.model.Carrier;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class CarrierMapper {

    @Autowired
    private ModelMapper modelMapper;


    public CarrierDTO convertToDto(Carrier carrier) {
        CarrierDTO carrierDTO = modelMapper.map(carrier, CarrierDTO.class);
        return carrierDTO;
    }

    public  Set<CarrierDTO> convertToDtos(Page<Carrier> carrierPage) {
        return carrierPage.stream().map(carrier -> convertToDto(carrier)).collect(Collectors.toSet());
    }

    public Carrier convertToEntity(CarrierDTO carrierDTO) {
        Carrier carrier = modelMapper.map(carrierDTO, Carrier.class);
        return carrier;
    }

    public Set<Carrier> convertToEntities(Collection<CarrierDTO> carrierDTOS) {
        return carrierDTOS
                .stream()
                .map(carrierDTO -> convertToEntity(carrierDTO))
                .collect(Collectors.toSet());
    }

}
