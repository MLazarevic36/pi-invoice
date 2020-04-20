package pi.faktura.dto;


import pi.faktura.model.Business_partner_type;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusinessPartnerDTO implements Serializable {

    private Long id;
    private String name;
    private Date creation_date;
    private String address;
    private Long tax_id;
    private LocationDTO location;
    private CompanyDTO company;
    private Business_partner_type business_partner_type;
    private Set<DispatchNoteDTO> dispatch_notesDTO = new HashSet<>();
    private List<ReceivingOrderDTO> receiving_orders;
    private List<InvoiceDTO> invoices;
    private Boolean deleted;

    public BusinessPartnerDTO() {
    }

    public BusinessPartnerDTO(Long id, String name, Date creation_date, String address, Long tax_id, LocationDTO location, CompanyDTO company, Business_partner_type business_partner_type, Set<DispatchNoteDTO> dispatch_notesDTO, List<ReceivingOrderDTO> receiving_orders, List<InvoiceDTO> invoices, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.creation_date = creation_date;
        this.address = address;
        this.tax_id = tax_id;
        this.location = location;
        this.company = company;
        this.business_partner_type = business_partner_type;
        this.dispatch_notesDTO = dispatch_notesDTO;
        this.receiving_orders = receiving_orders;
        this.invoices = invoices;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTax_id() {
        return tax_id;
    }

    public void setTax_id(Long tax_id) {
        this.tax_id = tax_id;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public Business_partner_type getBusiness_partner_type() {
        return business_partner_type;
    }

    public void setBusiness_partner_type(Business_partner_type business_partner_type) {
        this.business_partner_type = business_partner_type;
    }

    public Set<DispatchNoteDTO> getDispatch_notes() {
        return dispatch_notesDTO;
    }

    public void setDispatch_notes(Set<DispatchNoteDTO> dispatch_notes) {
        this.dispatch_notesDTO = dispatch_notes;
    }

    public List<ReceivingOrderDTO> getReceiving_orders() {
        return receiving_orders;
    }

    public void setReceiving_orders(List<ReceivingOrderDTO> receiving_orders) {
        this.receiving_orders = receiving_orders;
    }

    public List<InvoiceDTO> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceDTO> invoices) {
        this.invoices = invoices;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
