package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.ReceivingOrderItemDTO;
import pi.faktura.model.Receiving_order_item;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ReceivingOrderItemMapper implements Mapper<Receiving_order_item, ReceivingOrderItemDTO> {

    @Autowired
    ReceivingOrderMapper receivingOrderMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public ReceivingOrderItemDTO toDTO(Receiving_order_item entity) {

        ReceivingOrderItemDTO receivingOrderItemDTO = new ReceivingOrderItemDTO();

        receivingOrderItemDTO.setId(entity.getId());
        receivingOrderItemDTO.setName(entity.getName());
        receivingOrderItemDTO.setQuantity(entity.getQuantity());
        receivingOrderItemDTO.setUnit_of_measure(entity.getUnit_of_measure());
        receivingOrderItemDTO.setReceiving_order(receivingOrderMapper.toDTO(entity.getReceiving_order()));
        receivingOrderItemDTO.setGoods(goodsMapper.toDTO(entity.getGoods()));
        receivingOrderItemDTO.setDeleted(entity.isDeleted());

        return receivingOrderItemDTO;
    }

    @Override
    public Receiving_order_item toEntity(ReceivingOrderItemDTO receivingOrderItemDTO) {

        Receiving_order_item receiving_order_item = new Receiving_order_item();

        receiving_order_item.setName(receivingOrderItemDTO.getName());
        receiving_order_item.setQuantity(receivingOrderItemDTO.getQuantity());
        receiving_order_item.setUnit_of_measure(receivingOrderItemDTO.getUnit_of_measure());
        receiving_order_item.setReceiving_order(receivingOrderMapper.toEntity(receivingOrderItemDTO.getReceiving_order()));
        receiving_order_item.setGoods(goodsMapper.toEntity(receivingOrderItemDTO.getGoods()));
        receiving_order_item.setDeleted(receivingOrderItemDTO.isDeleted());

        return receiving_order_item;
    }

    public Receiving_order_item toEntityWithId(ReceivingOrderItemDTO receivingOrderItemDTO) {

        Receiving_order_item receiving_order_item = new Receiving_order_item();

        receiving_order_item.setId(receivingOrderItemDTO.getId());
        receiving_order_item.setName(receivingOrderItemDTO.getName());
        receiving_order_item.setQuantity(receivingOrderItemDTO.getQuantity());
        receiving_order_item.setUnit_of_measure(receivingOrderItemDTO.getUnit_of_measure());
        receiving_order_item.setReceiving_order(receivingOrderMapper.toEntity(receivingOrderItemDTO.getReceiving_order()));
        receiving_order_item.setGoods(goodsMapper.toEntity(receivingOrderItemDTO.getGoods()));
        receiving_order_item.setDeleted(receivingOrderItemDTO.isDeleted());

        return receiving_order_item;
    }

    @Override
    public Set<ReceivingOrderItemDTO> toDTO(Collection<Receiving_order_item> entities) {
        return entities
                .stream()
                .map(receiving_order_item -> toDTO(receiving_order_item))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Receiving_order_item> toEntity(Collection<ReceivingOrderItemDTO> receivingOrderItemDTOS) {
        return receivingOrderItemDTOS
                .stream()
                .map(receivingOrderItemDTO -> toEntity(receivingOrderItemDTO))
                .collect(Collectors.toSet());
    }

    public List<ReceivingOrderItemDTO> toDTOList(Collection<Receiving_order_item> entities) {
        return null;
    }

    public List<Receiving_order_item> toEntityList(Collection<ReceivingOrderItemDTO> receivingOrderItemDTOS) {
        return null;
    }
}
