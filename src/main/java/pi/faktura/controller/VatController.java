package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.VatDTO;
import pi.faktura.mapper.VatMapper;
import pi.faktura.model.VAT;
import pi.faktura.service.VatService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/vat")
public class VatController {

    @Autowired
    private VatService vatService;

    @Autowired
    private VatMapper vatMapper;

    @GetMapping
    public ResponseEntity<Set<VatDTO>> getVat(Pageable pageable) {
        try {
            Page<VAT> vats = vatService.findAll(pageable);
            return new ResponseEntity<>(vatMapper.convertToDtos(vats),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VatDTO> getVat(@PathVariable("id") Long id){
        try {
            VAT vat = vatService.findOne(id);
            return new ResponseEntity<>(vatMapper.convertToDto(vat), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<VatDTO> addVat(@RequestBody VatDTO vatDTO) {
        VAT vat = vatMapper.convertToEntity(vatDTO);
        try {
            vat = vatService.save(vat);
            return new ResponseEntity<>(vatMapper.convertToDto(vat), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<VatDTO> updateVat(@RequestBody VatDTO vatDTO) {
        VAT vat= vatMapper.convertToEntity(vatDTO);
        try {
            vat.setId(vatDTO.getId());
            vat = vatService.save(vat);
            return new ResponseEntity<>(vatMapper.convertToDto(vat), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteVat(@PathVariable("id") Long id) {
        try {
            VAT vat = vatService.findOne(id);
            vat.setDeleted(true);
            vatService.save(vat);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


}
