package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.PricelistItemDTO;
import pi.faktura.mapper.PricelistItemMapper;
import pi.faktura.model.Pricelist_item;
import pi.faktura.service.PricelistItemService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/pricelist-items")
public class PricelistItemController {

    @Autowired
    private PricelistItemService pricelistItemService;

    @Autowired
    private PricelistItemMapper pricelistItemMapper;

    @GetMapping
    public ResponseEntity<Set<PricelistItemDTO>> getPricelistItems(Pageable pageable) {
        try {
            Page<Pricelist_item> pricelist_items = pricelistItemService.findAll(pageable);
            return new ResponseEntity<>(pricelistItemMapper.convertToDtos(pricelist_items),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PricelistItemDTO> getPricelistItem(@PathVariable("id") Long id){
        try {
            Pricelist_item  pricelist_item= pricelistItemService.findOne(id);
            return new ResponseEntity<>(pricelistItemMapper.convertToDto(pricelist_item), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PricelistItemDTO> addPricelistItem(@RequestBody PricelistItemDTO pricelistItemDTO) {
        Pricelist_item pricelist_item = pricelistItemMapper.convertToEntity(pricelistItemDTO);
        try {
            pricelist_item = pricelistItemService.save(pricelist_item);
            return new ResponseEntity<>(pricelistItemMapper.convertToDto(pricelist_item), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<PricelistItemDTO> updatePricelistItem(@RequestBody PricelistItemDTO pricelistItemDTO) {
        Pricelist_item pricelist_item = pricelistItemMapper.convertToEntity(pricelistItemDTO);
        try {
            pricelist_item.setId(pricelistItemDTO.getId());
            pricelist_item = pricelistItemService.save(pricelist_item);
            return new ResponseEntity<>(pricelistItemMapper.convertToDto(pricelist_item), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePricelistItem(@PathVariable("id") Long id) {
        try {
            Pricelist_item pricelist_item = pricelistItemService.findOne(id);
            pricelist_item.setDeleted(true);
            pricelistItemService.save(pricelist_item);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
