package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.InvoiceItemDTO;
import pi.faktura.mapper.InvoiceItemMapper;
import pi.faktura.model.Invoice_item;
import pi.faktura.service.InvoiceItemService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/invoice-item")
public class InvoiceItemController {

    @Autowired
    private InvoiceItemService invoiceItemService;

    @Autowired
    private InvoiceItemMapper invoiceItemMapper;

    @GetMapping
    public ResponseEntity<Set<InvoiceItemDTO>> getInvoiceItems(Pageable pageable) {
        try {
            Page<Invoice_item> invoice_items = invoiceItemService.findAll(pageable);
            return new ResponseEntity<>(invoiceItemMapper.convertToDtos(invoice_items),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<InvoiceItemDTO> getInvoiceItem(@PathVariable("id") Long id){
        try {
            Invoice_item invoice_item = invoiceItemService.findOne(id);
            return new ResponseEntity<>(invoiceItemMapper.convertToDto(invoice_item), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<InvoiceItemDTO> addInvoiceItem(@RequestBody InvoiceItemDTO invoiceItemDTO) {
        Invoice_item invoice_item = invoiceItemMapper.convertToEntity(invoiceItemDTO);
        try {
            invoice_item = invoiceItemService.save(invoice_item);
            return new ResponseEntity<>(invoiceItemMapper.convertToDto(invoice_item), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<InvoiceItemDTO> updateInvoiceItem(@RequestBody InvoiceItemDTO invoiceItemDTO) {
        Invoice_item invoice_item = invoiceItemMapper.convertToEntity(invoiceItemDTO);
        try {
            invoice_item.setId(invoiceItemDTO.getId());
            invoice_item = invoiceItemService.save(invoice_item);
            return new ResponseEntity<>(invoiceItemMapper.convertToDto(invoice_item), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteInvoiceItem(@PathVariable("id") Long id) {
        try {
            Invoice_item invoice_item = invoiceItemService.findOne(id);
            invoice_item.setDeleted(true);
            invoiceItemService.save(invoice_item);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
