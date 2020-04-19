package pi.faktura.dto;

import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class DispatchNoteDTO implements Serializable {

    private Long id;
    private Long number;
    private Date date;
    private Date delivery_date;
    private CarrierDTO carrierDTO;
    private BusinessPartnerDTO buyerDTO;
    private CompanyDTO companyDTO;
    private InvoiceDTO invoiceDTO;
    private UserDTO userDTO;
    private List<DispatchNoteItemDTO> dispatch_note_itemDTOs;
    private boolean received_goods;
    private boolean deleted;

    public DispatchNoteDTO(Long id, Long number, Date date, Date delivery_date, CarrierDTO carrierDTO, BusinessPartnerDTO buyerDTO, CompanyDTO companyDTO, InvoiceDTO invoiceDTO, UserDTO userDTO, List<DispatchNoteItemDTO> dispatch_note_itemDTOs, boolean received_goods, boolean deleted) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.delivery_date = delivery_date;
        this.carrierDTO = carrierDTO;
        this.buyerDTO = buyerDTO;
        this.companyDTO = companyDTO;
        this.invoiceDTO = invoiceDTO;
        this.userDTO = userDTO;
        this.dispatch_note_itemDTOs = dispatch_note_itemDTOs;
        this.received_goods = received_goods;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public CarrierDTO getCarrierDTO() {
        return carrierDTO;
    }

    public void setCarrierDTO(CarrierDTO carrierDTO) {
        this.carrierDTO = carrierDTO;
    }

    public BusinessPartnerDTO getBuyerDTO() {
        return buyerDTO;
    }

    public void setBuyerDTO(BusinessPartnerDTO buyerDTO) {
        this.buyerDTO = buyerDTO;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public InvoiceDTO getInvoiceDTO() {
        return invoiceDTO;
    }

    public void setInvoiceDTO(InvoiceDTO invoiceDTO) {
        this.invoiceDTO = invoiceDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<DispatchNoteItemDTO> getDispatch_note_itemDTOs() {
        return dispatch_note_itemDTOs;
    }

    public void setDispatch_note_itemDTOs(List<DispatchNoteItemDTO> dispatch_note_itemDTOs) {
        this.dispatch_note_itemDTOs = dispatch_note_itemDTOs;
    }

    public boolean isReceived_goods() {
        return received_goods;
    }

    public void setReceived_goods(boolean received_goods) {
        this.received_goods = received_goods;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
