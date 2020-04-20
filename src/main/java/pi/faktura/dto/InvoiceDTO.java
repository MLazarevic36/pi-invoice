package pi.faktura.dto;

import pi.faktura.model.Invoice_status;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class InvoiceDTO implements Serializable {

    private Long id;
    private Long invoice_number;
    private Date invoice_date;
    private Date currency_date;
    private Long base;
    private Long vat_total;
    private Long amount_to_be_paid;
    private Invoice_status invoice_status;
    private ReceivingOrderDTO receiving_orderDTO;
    private DispatchNoteDTO dispatch_noteDTO;
    private BusinessPartnerDTO business_partnerDTO;
    private CompanyDTO companyDTO;
    private UserDTO userDTO;
    private List<InvoiceItemDTO> invoice_itemDTOs;
    private boolean deleted;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Long id, Long invoice_number, Date invoice_date, Date currency_date, Long base, Long vat_total, Long amount_to_be_paid, Invoice_status invoice_status, ReceivingOrderDTO receiving_orderDTO, DispatchNoteDTO dispatch_noteDTO, BusinessPartnerDTO business_partnerDTO, CompanyDTO companyDTO, UserDTO userDTO, List<InvoiceItemDTO> invoice_itemDTOs, boolean deleted) {
        this.id = id;
        this.invoice_number = invoice_number;
        this.invoice_date = invoice_date;
        this.currency_date = currency_date;
        this.base = base;
        this.vat_total = vat_total;
        this.amount_to_be_paid = amount_to_be_paid;
        this.invoice_status = invoice_status;
        this.receiving_orderDTO = receiving_orderDTO;
        this.dispatch_noteDTO = dispatch_noteDTO;
        this.business_partnerDTO = business_partnerDTO;
        this.companyDTO = companyDTO;
        this.userDTO = userDTO;
        this.invoice_itemDTOs = invoice_itemDTOs;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(Long invoice_number) {
        this.invoice_number = invoice_number;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    public Date getCurrency_date() {
        return currency_date;
    }

    public void setCurrency_date(Date currency_date) {
        this.currency_date = currency_date;
    }

    public Long getBase() {
        return base;
    }

    public void setBase(Long base) {
        this.base = base;
    }

    public Long getVat_total() {
        return vat_total;
    }

    public void setVat_total(Long vat_total) {
        this.vat_total = vat_total;
    }

    public Long getAmount_to_be_paid() {
        return amount_to_be_paid;
    }

    public void setAmount_to_be_paid(Long amount_to_be_paid) {
        this.amount_to_be_paid = amount_to_be_paid;
    }

    public Invoice_status getInvoice_status() {
        return invoice_status;
    }

    public void setInvoice_status(Invoice_status invoice_status) {
        this.invoice_status = invoice_status;
    }

    public ReceivingOrderDTO getReceiving_orderDTO() {
        return receiving_orderDTO;
    }

    public void setReceiving_orderDTO(ReceivingOrderDTO receiving_orderDTO) {
        this.receiving_orderDTO = receiving_orderDTO;
    }

    public DispatchNoteDTO getDispatch_noteDTO() {
        return dispatch_noteDTO;
    }

    public void setDispatch_noteDTO(DispatchNoteDTO dispatch_noteDTO) {
        this.dispatch_noteDTO = dispatch_noteDTO;
    }

    public BusinessPartnerDTO getBusiness_partnerDTO() {
        return business_partnerDTO;
    }

    public void setBusiness_partnerDTO(BusinessPartnerDTO business_partnerDTO) {
        this.business_partnerDTO = business_partnerDTO;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<InvoiceItemDTO> getInvoice_itemDTOs() {
        return invoice_itemDTOs;
    }

    public void setInvoice_itemDTOs(List<InvoiceItemDTO> invoice_itemDTOs) {
        this.invoice_itemDTOs = invoice_itemDTOs;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
