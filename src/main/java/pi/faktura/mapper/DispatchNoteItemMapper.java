package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.DispatchNoteItemDTO;
import pi.faktura.model.Dispatch_note_item;


import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DispatchNoteItemMapper implements Mapper<Dispatch_note_item, DispatchNoteItemDTO> {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    DispatchNoteMapper dispatchNoteMapper;

    @Override
    public DispatchNoteItemDTO toDTO(Dispatch_note_item entity) {

        DispatchNoteItemDTO dispatchNoteItemDTO = new DispatchNoteItemDTO();

        dispatchNoteItemDTO.setId(entity.getId());
        dispatchNoteItemDTO.setNumber(entity.getNumber());
        dispatchNoteItemDTO.setName(entity.getName());
        dispatchNoteItemDTO.setPrice(entity.getPrice());
        dispatchNoteItemDTO.setDelivered_quantity(entity.getDelivered_quantity());
        dispatchNoteItemDTO.setNote(entity.getNote());
        dispatchNoteItemDTO.setMeasure_of_unit(entity.getMeasure_of_unit());
        dispatchNoteItemDTO.setGoodsDTO(goodsMapper.toDTO(entity.getGoods()));
        dispatchNoteItemDTO.setDispatch_noteDTO(dispatchNoteMapper.toDTO(entity.getDispatch_note()));
        dispatchNoteItemDTO.setDeleted(entity.isDeleted());


        return dispatchNoteItemDTO;
    }

    @Override
    public Dispatch_note_item toEntity(DispatchNoteItemDTO dispatchNoteItemDTO) {

        Dispatch_note_item dispatch_note_item = new Dispatch_note_item();
        dispatch_note_item.setNumber(dispatchNoteItemDTO.getNumber());
        dispatch_note_item.setName(dispatchNoteItemDTO.getName());
        dispatch_note_item.setPrice(dispatchNoteItemDTO.getPrice());
        dispatch_note_item.setDelivered_quantity(dispatchNoteItemDTO.getDelivered_quantity());
        dispatch_note_item.setNote(dispatchNoteItemDTO.getNote());
        dispatch_note_item.setMeasure_of_unit(dispatchNoteItemDTO.getMeasure_of_unit());
        dispatch_note_item.setGoods(goodsMapper.toEntity(dispatchNoteItemDTO.getGoodsDTO()));
        dispatch_note_item.setDispatch_note(dispatchNoteMapper.toEntity(dispatchNoteItemDTO.getDispatch_noteDTO()));
        dispatch_note_item.setDeleted(dispatchNoteItemDTO.isDeleted());

        return dispatch_note_item;
    }

    public Dispatch_note_item toEntityWithId(DispatchNoteItemDTO dispatchNoteItemDTO) {

        Dispatch_note_item dispatch_note_item = new Dispatch_note_item();

        dispatch_note_item.setId(dispatchNoteItemDTO.getId());
        dispatch_note_item.setNumber(dispatchNoteItemDTO.getNumber());
        dispatch_note_item.setName(dispatchNoteItemDTO.getName());
        dispatch_note_item.setPrice(dispatchNoteItemDTO.getPrice());
        dispatch_note_item.setDelivered_quantity(dispatchNoteItemDTO.getDelivered_quantity());
        dispatch_note_item.setNote(dispatchNoteItemDTO.getNote());
        dispatch_note_item.setMeasure_of_unit(dispatchNoteItemDTO.getMeasure_of_unit());
        dispatch_note_item.setGoods(goodsMapper.toEntity(dispatchNoteItemDTO.getGoodsDTO()));
        dispatch_note_item.setDispatch_note(dispatchNoteMapper.toEntity(dispatchNoteItemDTO.getDispatch_noteDTO()));
        dispatch_note_item.setDeleted(dispatchNoteItemDTO.isDeleted());


        return dispatch_note_item;
    }

    @Override
    public Set<DispatchNoteItemDTO> toDTO(Collection<Dispatch_note_item> entities) {
        return entities
                .stream()
                .map(dispatch_note_item -> toDTO(dispatch_note_item))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Dispatch_note_item> toEntity(Collection<DispatchNoteItemDTO> dispatchNoteItemDTOS) {

        return dispatchNoteItemDTOS
                .stream()
                .map(dispatchNoteItemDTO -> toEntity(dispatchNoteItemDTO))
                .collect(Collectors.toSet());
    }

    public List<DispatchNoteItemDTO> toDTOList(Collection<Dispatch_note_item> entities) {
        return null;
    }

    public List<Dispatch_note_item> toEntityList(Collection<DispatchNoteItemDTO> entities) {
        return null;
    }
}
