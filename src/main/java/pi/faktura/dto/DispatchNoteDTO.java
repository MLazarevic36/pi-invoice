package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Dispatch_note;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DispatchNoteDTO implements Serializable {

    private Long id;
    private Long number;
    private Date date;
    private Date delivery_date;
    private CarrierDTO carrier;
    private BusinessPartnerDTO buyer;
    private CompanyDTO company;
    private InvoiceDTO invoice;
    private UserDTO user;
    private boolean received_goods;
    private boolean deleted;

    public DispatchNoteDTO(Long id, Long number, Date date, Date delivery_date, CarrierDTO carrier, BusinessPartnerDTO buyer, CompanyDTO company, InvoiceDTO invoice, UserDTO user, boolean received_goods, boolean deleted) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.delivery_date = delivery_date;
        this.carrier = carrier;
        this.buyer = buyer;
        this.company = company;
        this.invoice = invoice;
        this.user = user;
        this.received_goods = received_goods;
        this.deleted = deleted;
    }

    public DispatchNoteDTO(Dispatch_note d) {
        this(d.getId(), d.getNumber(), d.getDate(), d.getDelivery_date(), new CarrierDTO(d.getCarrier()),
                new BusinessPartnerDTO(d.getBuyer()), new CompanyDTO(d.getCompany()), new InvoiceDTO(d.getInvoice()),
                new UserDTO(d.getUser()), d.isReceived_goods(), d.isDeleted());
    }
}
