package pi.faktura.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pi.faktura.dto.BusinessPartnerDTO;
import pi.faktura.mapper.BusinessPartnerMapper;
import pi.faktura.model.Business_partner;
import pi.faktura.service.BusinessPartnerService;
import java.util.Set;


@RestController
@RequestMapping(value = "api/business_partners")
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



}
