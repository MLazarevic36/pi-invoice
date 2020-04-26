package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.DispatchNoteDTO;
import pi.faktura.model.Dispatch_note;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DispatchNoteMapper {

    @Autowired
    private ModelMapper modelMapper;

    public DispatchNoteDTO convertToDto(Dispatch_note dispatch_note) {
        DispatchNoteDTO dispatchNoteDTO = modelMapper.map(dispatch_note, DispatchNoteDTO.class);
        return dispatchNoteDTO;
    }

    public  Set<DispatchNoteDTO> convertToDtos(Page<Dispatch_note> dispatch_notePage) {
        return dispatch_notePage.stream().map(dispatch_note -> convertToDto(dispatch_note)).collect(Collectors.toSet());
    }

    public Dispatch_note convertToEntity(DispatchNoteDTO dispatchNoteDTO) {
        Dispatch_note dispatch_note = modelMapper.map(dispatchNoteDTO, Dispatch_note.class);
        return dispatch_note;
    }

    public Set<Dispatch_note> convertToEntities(Collection<DispatchNoteDTO> dispatchNoteDTOS) {
        return dispatchNoteDTOS
                .stream()
                .map(dispatchNoteDTO -> convertToEntity(dispatchNoteDTO))
                .collect(Collectors.toSet());
    }
}
