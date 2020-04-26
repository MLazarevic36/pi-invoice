package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.DispatchNoteDTO;
import pi.faktura.mapper.DispatchNoteMapper;
import pi.faktura.model.Dispatch_note;
import pi.faktura.service.DispatchNoteService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/dispatch-notes")
public class DispatchNoteController {

    @Autowired
    private DispatchNoteService dispatchNoteService;

    @Autowired
    private DispatchNoteMapper dispatchNoteMapper;

    @GetMapping
    public ResponseEntity<Set<DispatchNoteDTO>> getDispatchNotes(Pageable pageable) {
        try {
            Page<Dispatch_note> dispatch_notes = dispatchNoteService.findAll(pageable);
            return new ResponseEntity<>(dispatchNoteMapper.convertToDtos(dispatch_notes),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DispatchNoteDTO> getDispatchNote(@PathVariable("id") Long id){
        try {
            Dispatch_note dispatch_note = dispatchNoteService.findOne(id);
            return new ResponseEntity<>(dispatchNoteMapper.convertToDto(dispatch_note), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DispatchNoteDTO> addDispatchNote(@RequestBody DispatchNoteDTO dispatchNoteDTO) {
        Dispatch_note dispatch_note = dispatchNoteMapper.convertToEntity(dispatchNoteDTO);
        try {
            dispatch_note = dispatchNoteService.save(dispatch_note);
            return new ResponseEntity<>(dispatchNoteMapper.convertToDto(dispatch_note), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<DispatchNoteDTO> updateDispatchNote(@RequestBody DispatchNoteDTO dispatchNoteDTO) {
        Dispatch_note dispatch_note = dispatchNoteMapper.convertToEntity(dispatchNoteDTO);
        try {
            dispatch_note.setId(dispatchNoteDTO.getId());
            dispatch_note = dispatchNoteService.save(dispatch_note);
            return new ResponseEntity<>(dispatchNoteMapper.convertToDto(dispatch_note), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDispatchNote(@PathVariable("id") Long id) {
        try {
            Dispatch_note dispatch_note = dispatchNoteService.findOne(id);
            dispatch_note.setDeleted(true);
            dispatchNoteService.save(dispatch_note);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
