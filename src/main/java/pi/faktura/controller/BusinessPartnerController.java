package pi.faktura.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.BusinessPartnerDTO;
import pi.faktura.mapper.BusinessPartnerMapper;
import pi.faktura.model.Business_partner;
import pi.faktura.service.BusinessPartnerService;
import java.util.Set;


@RestController
@RequestMapping(value = "api/business-partners")
public class BusinessPartnerController {

    @Autowired
    private BusinessPartnerService businessPartnerService;

    @Autowired
    private BusinessPartnerMapper businessPartnerMapper;


    @GetMapping
    public ResponseEntity<Set<BusinessPartnerDTO>> getBusinessPartners(Pageable pageable) {
        try {
            Page<Business_partner> business_partners = businessPartnerService.findAll(pageable);
            return new ResponseEntity<>(businessPartnerMapper.convertToDtos(business_partners),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BusinessPartnerDTO> getBusinessPartner(@PathVariable("id") Long id){
        try {
            Business_partner business_partner = businessPartnerService.findOne(id);
            return new ResponseEntity<>(businessPartnerMapper.convertToDto(business_partner), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BusinessPartnerDTO> addBusinessPartner(@RequestBody BusinessPartnerDTO businessPartnerDTO) {
        Business_partner business_partner = businessPartnerMapper.convertToEntity(businessPartnerDTO);
        try {
            business_partner = businessPartnerService.save(business_partner);
            return new ResponseEntity<>(businessPartnerMapper.convertToDto(business_partner), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<BusinessPartnerDTO> updateBusinessPartner(@RequestBody BusinessPartnerDTO businessPartnerDTO) {
        Business_partner business_partner = businessPartnerMapper.convertToEntity(businessPartnerDTO);
        try {
            business_partner.setId(businessPartnerDTO.getId());
            business_partner = businessPartnerService.save(business_partner);
            return new ResponseEntity<>(businessPartnerMapper.convertToDto(business_partner), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBusinessPartner(@PathVariable("id") Long id) {
        try {
            Business_partner business_partner = businessPartnerService.findOne(id);
            business_partner.setDeleted(true);
            businessPartnerService.save(business_partner);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



}
