package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.PricelistDTO;
import pi.faktura.mapper.PricelistMapper;
import pi.faktura.model.Pricelist;
import pi.faktura.service.PricelistService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/pricelists")
public class PricelistController {

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    private PricelistMapper pricelistMapper;

    @GetMapping
    public ResponseEntity<Set<PricelistDTO>> getPricelistItems(Pageable pageable) {
        try {
            Page<Pricelist> pricelists = pricelistService.findAll(pageable);
            return new ResponseEntity<>(pricelistMapper.convertToDtos(pricelists),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PricelistDTO> getPricelist(@PathVariable("id") Long id){
        try {
            Pricelist  pricelist = pricelistService.findOne(id);
            return new ResponseEntity<>(pricelistMapper.convertToDto(pricelist), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PricelistDTO> addPricelist(@RequestBody PricelistDTO pricelistDTO) {
        Pricelist pricelist = pricelistMapper.convertToEntity(pricelistDTO);
        try {
            pricelist = pricelistService.save(pricelist);
            return new ResponseEntity<>(pricelistMapper.convertToDto(pricelist), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<PricelistDTO> updatePricelist(@RequestBody PricelistDTO pricelistDTO) {
        Pricelist pricelist = pricelistMapper.convertToEntity(pricelistDTO);
        try {
            pricelist.setId(pricelistDTO.getId());
            pricelist = pricelistService.save(pricelist);
            return new ResponseEntity<>(pricelistMapper.convertToDto(pricelist), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePricelist(@PathVariable("id") Long id) {
        try {
            Pricelist pricelist = pricelistService.findOne(id);
            pricelist.setDeleted(true);
            pricelistService.save(pricelist);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}


