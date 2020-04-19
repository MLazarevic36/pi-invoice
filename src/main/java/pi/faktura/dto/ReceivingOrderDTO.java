package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Receiving_order;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReceivingOrderDTO implements Serializable {

    private Long id;
    private Long number;
    private Date creation_date;
    private Date delivery_date;
    private CompanyDTO company;
    private InvoiceDTO invoice;
    private BusinessPartnerDTO buyer;
    private UserDTO user;
    private boolean active;
    private boolean deleted;

    public ReceivingOrderDTO(Long id, Long number, Date creation_date, Date delivery_date, CompanyDTO company,
                             InvoiceDTO invoice, BusinessPartnerDTO buyer, UserDTO user, boolean active,
                             boolean deleted) {
        this.id = id;
        this.number = number;
        this.creation_date = creation_date;
        this.delivery_date = delivery_date;
        this.company = company;
        this.invoice = invoice;
        this.buyer = buyer;
        this.user = user;
        this.active = active;
        this.deleted = deleted;
    }

    public ReceivingOrderDTO(Receiving_order r) {
        this(r.getId(), r.getNumber(), r.getCreation_date(), r.getDelivery_date(), new CompanyDTO(r.getCompany()),
                new InvoiceDTO(r.getInvoice()), new BusinessPartnerDTO(r.getBuyer()), new UserDTO(r.getUser()),
                r.isActive(), r.isDeleted());
    }
}
