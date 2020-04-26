package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.CompanyDTO;
import pi.faktura.mapper.CompanyMapper;
import pi.faktura.model.Company;
import pi.faktura.service.CompanyService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @GetMapping
    public ResponseEntity<Set<CompanyDTO>> getCompanies(Pageable pageable) {
        try {
            Page<Company> companies = companyService.findAll(pageable);
            return new ResponseEntity<>(companyMapper.convertToDtos(companies),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable("id") Long id){
        try {
            Company company = companyService.findOne(id);
            return new ResponseEntity<>(companyMapper.convertToDto(company), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyDTO companyDTO) {
        Company company = companyMapper.convertToEntity(companyDTO);
        try {
            company = companyService.save(company);
            return new ResponseEntity<>(companyMapper.convertToDto(company), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO) {
        Company company = companyMapper.convertToEntity(companyDTO);
        try {
            company.setId(companyDTO.getId());
            company = companyService.save(company);
            return new ResponseEntity<>(companyMapper.convertToDto(company), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") Long id) {
        try {
            Company company = companyService.findOne(id);
            company.setDeleted(true);
            companyService.save(company);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
