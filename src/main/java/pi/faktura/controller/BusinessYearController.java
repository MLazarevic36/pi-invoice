package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.BusinessYearDTO;
import pi.faktura.mapper.BusinessYearMapper;
import pi.faktura.model.Business_year;
import pi.faktura.service.BusinessYearService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/business-years")
public class BusinessYearController {

    @Autowired
    private BusinessYearService businessYearService;

    @Autowired
    private BusinessYearMapper businessYearMapper;

    @GetMapping
    public ResponseEntity<Set<BusinessYearDTO>> getBusinessYears(Pageable pageable) {
        try {
            Page<Business_year> business_years = businessYearService.findAll(pageable);
            return new ResponseEntity<>(businessYearMapper.convertToDtos(business_years),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BusinessYearDTO> getBusinessYear(@PathVariable("id") Long id){
        try {
            Business_year business_year = businessYearService.findOne(id);
            return new ResponseEntity<>(businessYearMapper.convertToDto(business_year), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BusinessYearDTO> addBusinessYear(@RequestBody BusinessYearDTO businessYearDTO) {
        Business_year business_year = businessYearMapper.convertToEntity(businessYearDTO);
        try {
            business_year = businessYearService.save(business_year);
            return new ResponseEntity<>(businessYearMapper.convertToDto(business_year), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<BusinessYearDTO> updateBusinessYear(@RequestBody BusinessYearDTO businessYearDTO) {
        Business_year business_year = businessYearMapper.convertToEntity(businessYearDTO);
        try {
            business_year.setId(businessYearDTO.getId());
            business_year = businessYearService.save(business_year);
            return new ResponseEntity<>(businessYearMapper.convertToDto(business_year), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBusinessYear(@PathVariable("id") Long id) {
        try {
            Business_year business_year = businessYearService.findOne(id);
            business_year.setFinished(true);
            businessYearService.save(business_year);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
