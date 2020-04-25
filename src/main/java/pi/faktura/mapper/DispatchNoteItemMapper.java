package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.DispatchNoteItemDTO;
import pi.faktura.model.Dispatch_note_item;


import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DispatchNoteItemMapper  {

    @Autowired
    private ModelMapper modelMapper;

    private DispatchNoteItemDTO convertToDto(Dispatch_note_item dispatch_note_item) {
        DispatchNoteItemDTO dispatchNoteItemDTO = modelMapper.map(dispatch_note_item, DispatchNoteItemDTO.class);
        return dispatchNoteItemDTO;
    }

    public  Set<DispatchNoteItemDTO> convertToDtos(Page<Dispatch_note_item> dispatch_note_itemsPage) {
        return dispatch_note_itemsPage.stream().map(dispatch_note_item -> convertToDto(dispatch_note_item)).collect(Collectors.toSet());
    }

    private Dispatch_note_item convertToEntity(DispatchNoteItemDTO dispatchNoteItemDTO) {
        Dispatch_note_item dispatch_note_item = modelMapper.map(dispatchNoteItemDTO, Dispatch_note_item.class);
        return dispatch_note_item;
    }

    public Set<Dispatch_note_item> convertToEntities(Collection<DispatchNoteItemDTO> dispatchNoteItemDTOS) {
        return dispatchNoteItemDTOS
                .stream()
                .map(dispatchNoteItemDTO -> convertToEntity(dispatchNoteItemDTO))
                .collect(Collectors.toSet());
    }


}
