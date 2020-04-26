package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.DispatchNoteItemDTO;
import pi.faktura.mapper.DispatchNoteItemMapper;
import pi.faktura.model.Dispatch_note_item;
import pi.faktura.service.DispatchNoteItemService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/dispatch-note-items")
public class DispatchNoteItemController {

    @Autowired
    private DispatchNoteItemService dispatchNoteItemService;

    @Autowired
    private DispatchNoteItemMapper dispatchNoteItemMapper;

    @GetMapping
    public ResponseEntity<Set<DispatchNoteItemDTO>> getDispatchNoteItems(Pageable pageable) {
        try {
            Page<Dispatch_note_item> dispatch_note_items = dispatchNoteItemService.findAll(pageable);
            return new ResponseEntity<>(dispatchNoteItemMapper.convertToDtos(dispatch_note_items),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DispatchNoteItemDTO> getDispatchNoteItem(@PathVariable("id") Long id){
        try {
            Dispatch_note_item dispatch_note_item = dispatchNoteItemService.findOne(id);
            return new ResponseEntity<>(dispatchNoteItemMapper.convertToDto(dispatch_note_item), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DispatchNoteItemDTO> addDispatchNoteItem(@RequestBody DispatchNoteItemDTO dispatchNoteItemDTO) {
        Dispatch_note_item dispatch_note_item = dispatchNoteItemMapper.convertToEntity(dispatchNoteItemDTO);
        try {
            dispatch_note_item = dispatchNoteItemService.save(dispatch_note_item);
            return new ResponseEntity<>(dispatchNoteItemMapper.convertToDto(dispatch_note_item), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<DispatchNoteItemDTO> updateDispatchNoteItem(@RequestBody DispatchNoteItemDTO dispatchNoteItemDTO) {
        Dispatch_note_item dispatch_note_item = dispatchNoteItemMapper.convertToEntity(dispatchNoteItemDTO);
        try {
            dispatch_note_item.setId(dispatchNoteItemDTO.getId());
            dispatch_note_item = dispatchNoteItemService.save(dispatch_note_item);
            return new ResponseEntity<>(dispatchNoteItemMapper.convertToDto(dispatch_note_item), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDispatchNoteItem(@PathVariable("id") Long id) {
        try {
            Dispatch_note_item dispatch_note_item = dispatchNoteItemService.findOne(id);
            dispatch_note_item.setDeleted(true);
            dispatchNoteItemService.save(dispatch_note_item);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
