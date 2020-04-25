package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.ReceivingOrderDTO;
import pi.faktura.model.Receiving_order;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ReceivingOrderMapper {

    @Autowired
    private ModelMapper modelMapper;


    private ReceivingOrderDTO convertToDto(Receiving_order receiving_order) {
        ReceivingOrderDTO receivingOrderDTO = modelMapper.map(receiving_order, ReceivingOrderDTO.class);
        return receivingOrderDTO;
    }

    public  Set<ReceivingOrderDTO> convertToDtos(Page<Receiving_order> receivingOrderPage) {
        return receivingOrderPage.stream().map(receivingOrder -> convertToDto(receivingOrder)).collect(Collectors.toSet());
    }

    private Receiving_order convertToEntity(ReceivingOrderDTO receivingOrderDTO) {
        Receiving_order receiving_order = modelMapper.map(receivingOrderDTO, Receiving_order.class);
        return receiving_order;
    }

    public Set<Receiving_order> convertToEntities(Collection<ReceivingOrderDTO> receivingOrderDTOS) {
        return receivingOrderDTOS
                .stream()
                .map(receivingOrderDTO -> convertToEntity(receivingOrderDTO))
                .collect(Collectors.toSet());
    }
}
