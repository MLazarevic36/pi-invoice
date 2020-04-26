package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.VatRateDTO;
import pi.faktura.mapper.VatRateMapper;
import pi.faktura.model.VAT_rate;
import pi.faktura.service.VatRateService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/vat-rates")
public class VatRateController {

    @Autowired
    private VatRateService vatRateService;

    @Autowired
    private VatRateMapper vatRateMapper;

    @GetMapping
    public ResponseEntity<Set<VatRateDTO>> getVatRate(Pageable pageable) {
        try {
            Page<VAT_rate> vat_rates = vatRateService.findAll(pageable);
            return new ResponseEntity<>(vatRateMapper.convertToDtos(vat_rates),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VatRateDTO> getVatRate(@PathVariable("id") Long id){
        try {
            VAT_rate vat_rate = vatRateService.findOne(id);
            return new ResponseEntity<>(vatRateMapper.convertToDto(vat_rate), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<VatRateDTO> addVatRate(@RequestBody VatRateDTO vatRateDTO) {
        VAT_rate vat_rate = vatRateMapper.convertToEntity(vatRateDTO);
        try {
            vat_rate = vatRateService.save(vat_rate);
            return new ResponseEntity<>(vatRateMapper.convertToDto(vat_rate), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<VatRateDTO> updateVatRate(@RequestBody VatRateDTO vatRateDTO) {
        VAT_rate vat_rate = vatRateMapper.convertToEntity(vatRateDTO);
        try {
            vat_rate.setId(vatRateDTO.getId());
            vat_rate = vatRateService.save(vat_rate);
            return new ResponseEntity<>(vatRateMapper.convertToDto(vat_rate), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteVatRate(@PathVariable("id") Long id) {
        try {
            VAT_rate vat_rate = vatRateService.findOne(id);
            vat_rate.setDeleted(true);
            vatRateService.save(vat_rate);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
