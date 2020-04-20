package pi.faktura.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.CarrierDTO;
import pi.faktura.model.Carrier;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class CarrierMapper implements Mapper<Carrier, CarrierDTO>  {

    @Autowired
    DispatchNoteMapper dispatchNoteMapper;

    @Override
    public CarrierDTO toDTO(Carrier entity) {

        CarrierDTO carrierDTO = new CarrierDTO();

        carrierDTO.setId(entity.getId());
        carrierDTO.setName(entity.getName());
        carrierDTO.setDispatch_notes(dispatchNoteMapper.toDTO(entity.getDispatch_notes()));
        carrierDTO.setDeleted(entity.getDeleted());

        return  carrierDTO;
    }

    @Override
    public Carrier toEntity(CarrierDTO carrierDTO) {

        Carrier carrier = new Carrier();

        carrier.setName(carrierDTO.getName());
        carrier.setDispatch_notes(dispatchNoteMapper.toEntity(carrierDTO.getDispatch_notes()));
        carrier.setDeleted(carrierDTO.getDeleted());

        return carrier;
    }

    public Carrier toEntityWithId(CarrierDTO carrierDTO) {

        Carrier carrier = new Carrier();

        carrier.setId(carrierDTO.getId());
        carrier.setName(carrierDTO.getName());
        carrier.setDispatch_notes(dispatchNoteMapper.toEntity(carrierDTO.getDispatch_notes()));
        carrier.setDeleted(carrierDTO.getDeleted());

        return carrier;
    }

    @Override
    public Set<CarrierDTO> toDTO(Collection<Carrier> entities) {
        return entities
                .stream()
                .map(carrier -> toDTO(carrier))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Carrier> toEntity(Collection<CarrierDTO> carrierDTOS) {
        return carrierDTOS
                .stream()
                .map(carrierDTO -> toEntity(carrierDTO))
                .collect(Collectors.toSet());
    }


}
