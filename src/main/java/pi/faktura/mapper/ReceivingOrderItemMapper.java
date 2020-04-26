package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.ReceivingOrderItemDTO;
import pi.faktura.model.Receiving_order_item;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ReceivingOrderItemMapper  {

    @Autowired
    private ModelMapper modelMapper;


    public ReceivingOrderItemDTO convertToDto(Receiving_order_item receiving_order_item) {
        ReceivingOrderItemDTO receivingOrderItemDTO = modelMapper.map(receiving_order_item, ReceivingOrderItemDTO.class);
        return receivingOrderItemDTO;
    }

    public  Set<ReceivingOrderItemDTO> convertToDtos(Page<Receiving_order_item> receivingOrderItemPage) {
        return receivingOrderItemPage.stream().map(receivingOrderItem -> convertToDto(receivingOrderItem)).collect(Collectors.toSet());
    }

    public Receiving_order_item convertToEntity(ReceivingOrderItemDTO receivingOrderItemDTO) {
        Receiving_order_item receiving_order_item = modelMapper.map(receivingOrderItemDTO, Receiving_order_item.class);
        return receiving_order_item;
    }

    public Set<Receiving_order_item> convertToEntities(Collection<ReceivingOrderItemDTO> receivingOrderItemDTOS) {
        return receivingOrderItemDTOS
                .stream()
                .map(receivingOrderItemDTO -> convertToEntity(receivingOrderItemDTO))
                .collect(Collectors.toSet());
    }

}
