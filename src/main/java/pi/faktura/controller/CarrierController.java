package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.CarrierDTO;
import pi.faktura.mapper.CarrierMapper;
import pi.faktura.model.Carrier;
import pi.faktura.service.CarrierService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/carriers")
public class CarrierController {

    @Autowired
    private CarrierService carrierService;

    @Autowired
    private CarrierMapper carrierMapper;

    @GetMapping
    public ResponseEntity<Set<CarrierDTO>> getCarriers(Pageable pageable) {
        try {
            Page<Carrier> carriers = carrierService.findAll(pageable);
            return new ResponseEntity<>(carrierMapper.convertToDtos(carriers),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarrierDTO> getCarrier(@PathVariable("id") Long id){
        try {
            Carrier carrier = carrierService.findOne(id);
            return new ResponseEntity<>(carrierMapper.convertToDto(carrier), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CarrierDTO> addCarrier(@RequestBody CarrierDTO carrierDTO) {
        Carrier carrier = carrierMapper.convertToEntity(carrierDTO);
        try {
            carrier = carrierService.save(carrier);
            return new ResponseEntity<>(carrierMapper.convertToDto(carrier), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<CarrierDTO> updateCarrier(@RequestBody CarrierDTO carrierDTO) {
        Carrier carrier = carrierMapper.convertToEntity(carrierDTO);
        try {
            carrier.setId(carrierDTO.getId());
            carrier = carrierService.save(carrier);
            return new ResponseEntity<>(carrierMapper.convertToDto(carrier), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCarrier(@PathVariable("id") Long id) {
        try {
            Carrier carrier = carrierService.findOne(id);
            carrier.setDeleted(true);
            carrierService.save(carrier);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
