package pi.faktura.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Invoice;
import pi.faktura.model.Invoice_status;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class InvoiceDTO implements Serializable {

    private Long id;
    private Long invoice_number;
    private Date invoice_date;
    private Date currency_date;
    private Long base;
    private Long vat_total;
    private Long amount_to_be_paid;
    private Invoice_status invoice_status;
    private ReceivingOrderDTO receiving_order;
    private DispatchNoteDTO dispatch_note;
    private BusinessPartnerDTO business_partner;
    private CompanyDTO company;
    private UserDTO user;
    private boolean deleted;

    public InvoiceDTO(Long id, Long invoice_number, Date invoice_date, Date currency_date, Long base,
                      Long vat_total, Long amount_to_be_paid, Invoice_status invoice_status,
                      ReceivingOrderDTO receiving_order, DispatchNoteDTO dispatch_note,
                      BusinessPartnerDTO business_partner, CompanyDTO company, UserDTO user, boolean deleted) {
        this.id = id;
        this.invoice_number = invoice_number;
        this.invoice_date = invoice_date;
        this.currency_date = currency_date;
        this.base = base;
        this.vat_total = vat_total;
        this.amount_to_be_paid = amount_to_be_paid;
        this.invoice_status = invoice_status;
        this.receiving_order = receiving_order;
        this.dispatch_note = dispatch_note;
        this.business_partner = business_partner;
        this.company = company;
        this.user = user;
        this.deleted = deleted;
    }

    public InvoiceDTO(Invoice i) {
        this(i.getId(), i.getInvoice_number(), i.getInvoice_date(), i.getCurrency_date(), i.getBase(),
                i.getVat_total(), i.getAmount_to_be_paid(), i.getInvoice_status(), new ReceivingOrderDTO(i.getReceiving_order()),
                       new DispatchNoteDTO(i.getDispatch_note()), new BusinessPartnerDTO(i.getBusiness_partner()),
                        new CompanyDTO(i.getCompany()), new UserDTO(i.getUser()), i.isDeleted());
    }
}
