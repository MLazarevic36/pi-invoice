package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.PricelistItemDTO;
import pi.faktura.dto.ReceivingOrderItemDTO;
import pi.faktura.mapper.ReceivingOrderItemMapper;
import pi.faktura.model.Receiving_order_item;
import pi.faktura.service.ReceivingOrderItemService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/receiving-order-items")
public class ReceivingOrderItemController {

    @Autowired
    private ReceivingOrderItemService receivingOrderItemService;

    @Autowired
    private ReceivingOrderItemMapper receivingOrderItemMapper;

    @GetMapping
    public ResponseEntity<Set<ReceivingOrderItemDTO>> getReceivingOrderItems(Pageable pageable) {
        try {
            Page<Receiving_order_item> receiving_order_items = receivingOrderItemService.findAll(pageable);
            return new ResponseEntity<>(receivingOrderItemMapper.convertToDtos(receiving_order_items),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReceivingOrderItemDTO> getReceivingOrderItem(@PathVariable("id") Long id){
        try {
            Receiving_order_item  receiving_order_item = receivingOrderItemService.findOne(id);
            return new ResponseEntity<>(receivingOrderItemMapper.convertToDto(receiving_order_item), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ReceivingOrderItemDTO> addReceivingOrderItem(@RequestBody ReceivingOrderItemDTO receivingOrderItemDTO) {
        Receiving_order_item receiving_order_item = receivingOrderItemMapper.convertToEntity(receivingOrderItemDTO);
        try {
            receiving_order_item = receivingOrderItemService.save(receiving_order_item);
            return new ResponseEntity<>(receivingOrderItemMapper.convertToDto(receiving_order_item), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<ReceivingOrderItemDTO> updateReceivingOrderItem(@RequestBody ReceivingOrderItemDTO receivingOrderItemDTO) {
        Receiving_order_item receiving_order_item = receivingOrderItemMapper.convertToEntity(receivingOrderItemDTO);
        try {
            receiving_order_item.setId(receivingOrderItemDTO.getId());
            receiving_order_item = receivingOrderItemService.save(receiving_order_item);
            return new ResponseEntity<>(receivingOrderItemMapper.convertToDto(receiving_order_item), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteReceivingOrderItem(@PathVariable("id") Long id) {
        try {
            Receiving_order_item receiving_order_item = receivingOrderItemService.findOne(id);
            receiving_order_item.setDeleted(true);
            receivingOrderItemService.save(receiving_order_item);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

