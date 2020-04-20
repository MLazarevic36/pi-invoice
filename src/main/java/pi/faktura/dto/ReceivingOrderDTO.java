package pi.faktura.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ReceivingOrderDTO implements Serializable {

    private Long id;
    private Long number;
    private Date creation_date;
    private Date delivery_date;
    private CompanyDTO company;
    private InvoiceDTO invoice;
    private BusinessPartnerDTO buyer;
    private UserDTO user;
    private List<ReceivingOrderItemDTO> receiving_order_itemDTOs;
    private boolean active;
    private boolean deleted;

    public ReceivingOrderDTO() {
    }

    public ReceivingOrderDTO(Long id, Long number, Date creation_date, Date delivery_date, CompanyDTO company, InvoiceDTO invoice, BusinessPartnerDTO buyer, UserDTO user, List<ReceivingOrderItemDTO> receiving_order_itemDTOs, boolean active, boolean deleted) {
        this.id = id;
        this.number = number;
        this.creation_date = creation_date;
        this.delivery_date = delivery_date;
        this.company = company;
        this.invoice = invoice;
        this.buyer = buyer;
        this.user = user;
        this.receiving_order_itemDTOs = receiving_order_itemDTOs;
        this.active = active;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDTO invoice) {
        this.invoice = invoice;
    }

    public BusinessPartnerDTO getBuyer() {
        return buyer;
    }

    public void setBuyer(BusinessPartnerDTO buyer) {
        this.buyer = buyer;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<ReceivingOrderItemDTO> getReceiving_order_itemDTOs() {
        return receiving_order_itemDTOs;
    }

    public void setReceiving_order_itemDTOs(List<ReceivingOrderItemDTO> receiving_order_itemDTOs) {
        this.receiving_order_itemDTOs = receiving_order_itemDTOs;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
