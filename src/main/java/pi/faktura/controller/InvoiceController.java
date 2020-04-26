package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.InvoiceDTO;
import pi.faktura.mapper.InvoiceMapper;
import pi.faktura.model.Invoice;
import pi.faktura.service.InvoiceService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @GetMapping
    public ResponseEntity<Set<InvoiceDTO>> getInvoices(Pageable pageable) {
        try {
            Page<Invoice> invoices = invoiceService.findAll(pageable);
            return new ResponseEntity<>(invoiceMapper.convertToDtos(invoices),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable("id") Long id){
        try {
            Invoice invoice = invoiceService.findOne(id);
            return new ResponseEntity<>(invoiceMapper.convertToDto(invoice), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<InvoiceDTO> addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceMapper.convertToEntity(invoiceDTO);
        try {
            invoice = invoiceService.save(invoice);
            return new ResponseEntity<>(invoiceMapper.convertToDto(invoice), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<InvoiceDTO> updateInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceMapper.convertToEntity(invoiceDTO);
        try {
            invoice.setId(invoiceDTO.getId());
            invoice = invoiceService.save(invoice);
            return new ResponseEntity<>(invoiceMapper.convertToDto(invoice), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable("id") Long id) {
        try {
            Invoice invoice = invoiceService.findOne(id);
            invoice.setDeleted(true);
            invoiceService.save(invoice);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


}
