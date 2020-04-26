package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.ReceivingOrderDTO;
import pi.faktura.mapper.ReceivingOrderMapper;
import pi.faktura.model.Receiving_order;
import pi.faktura.service.ReceivingOrderService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/receiving-orders")
public class ReceivingOrderController {

    @Autowired
    private ReceivingOrderService receivingOrderService;

    @Autowired
    private ReceivingOrderMapper receivingOrderMapper;

    @GetMapping
    public ResponseEntity<Set<ReceivingOrderDTO>> getReceivingOrder(Pageable pageable) {
        try {
            Page<Receiving_order> receiving_orders = receivingOrderService.findAll(pageable);
            return new ResponseEntity<>(receivingOrderMapper.convertToDtos(receiving_orders),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReceivingOrderDTO> getReceivingOrder(@PathVariable("id") Long id){
        try {
            Receiving_order  receiving_order = receivingOrderService.findOne(id);
            return new ResponseEntity<>(receivingOrderMapper.convertToDto(receiving_order), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ReceivingOrderDTO> addReceivingOrder(@RequestBody ReceivingOrderDTO receivingOrderDTO) {
        Receiving_order receiving_order = receivingOrderMapper.convertToEntity(receivingOrderDTO);
        try {
            receiving_order = receivingOrderService.save(receiving_order);
            return new ResponseEntity<>(receivingOrderMapper.convertToDto(receiving_order), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<ReceivingOrderDTO> updateReceivingOrder(@RequestBody ReceivingOrderDTO receivingOrderDTO) {
        Receiving_order receiving_order = receivingOrderMapper.convertToEntity(receivingOrderDTO);
        try {
            receiving_order.setId(receivingOrderDTO.getId());
            receiving_order = receivingOrderService.save(receiving_order);
            return new ResponseEntity<>(receivingOrderMapper.convertToDto(receiving_order), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteReceivingOrder(@PathVariable("id") Long id) {
        try {
            Receiving_order receiving_order = receivingOrderService.findOne(id);
            receiving_order.setDeleted(true);
            receivingOrderService.save(receiving_order);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

