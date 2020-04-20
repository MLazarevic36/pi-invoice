package pi.faktura.dto;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompanyDTO implements Serializable {

    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Long tax_identification_number;
    private LocationDTO location;
    private Set<PricelistDTO> pricelistsDTOs = new HashSet<>();
    private Set<GoodsGroupDTO> goods_groupsDTOs = new HashSet<>();
    private Set<BusinessPartnerDTO> business_partnersDTOs = new HashSet<>();
    private Set<BusinessYearDTO> business_yearDTOs = new HashSet<>();
    private List<InvoiceDTO> invoiceDTOs;
    private List<DispatchNoteDTO> dispatch_notesDTOs;
    private List<ReceivingOrderDTO> receiving_orderDTOs;
    private Set<UserDTO> userDTOs = new HashSet<>();
    private Boolean deleted;

    public CompanyDTO(Long id, String name, String address, String email, String phone, Long tax_identification_number, LocationDTO location, Set<PricelistDTO> pricelistsDTOs, Set<GoodsGroupDTO> goods_groupsDTOs, Set<BusinessPartnerDTO> business_partnersDTOs, Set<BusinessYearDTO> business_yearDTOs, List<InvoiceDTO> invoiceDTOs, List<DispatchNoteDTO> dispatch_notesDTOs, List<ReceivingOrderDTO> receiving_orderDTOs, Set<UserDTO> userDTOs, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.tax_identification_number = tax_identification_number;
        this.location = location;
        this.pricelistsDTOs = pricelistsDTOs;
        this.goods_groupsDTOs = goods_groupsDTOs;
        this.business_partnersDTOs = business_partnersDTOs;
        this.business_yearDTOs = business_yearDTOs;
        this.invoiceDTOs = invoiceDTOs;
        this.dispatch_notesDTOs = dispatch_notesDTOs;
        this.receiving_orderDTOs = receiving_orderDTOs;
        this.userDTOs = userDTOs;
        this.deleted = deleted;
    }

    public CompanyDTO() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getTax_identification_number() {
        return tax_identification_number;
    }

    public void setTax_identification_number(Long tax_identification_number) {
        this.tax_identification_number = tax_identification_number;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public Set<PricelistDTO> getPricelistsDTOs() {
        return pricelistsDTOs;
    }

    public void setPricelistsDTOs(Set<PricelistDTO> pricelistsDTOs) {
        this.pricelistsDTOs = pricelistsDTOs;
    }

    public Set<GoodsGroupDTO> getGoods_groupsDTOs() {
        return goods_groupsDTOs;
    }

    public void setGoods_groupsDTOs(Set<GoodsGroupDTO> goods_groupsDTOs) {
        this.goods_groupsDTOs = goods_groupsDTOs;
    }

    public Set<BusinessPartnerDTO> getBusiness_partnersDTOs() {
        return business_partnersDTOs;
    }

    public void setBusiness_partnersDTOs(Set<BusinessPartnerDTO> business_partnersDTOs) {
        this.business_partnersDTOs = business_partnersDTOs;
    }

    public Set<BusinessYearDTO> getBusiness_yearDTOs() {
        return business_yearDTOs;
    }

    public void setBusiness_yearDTOs(Set<BusinessYearDTO> business_yearDTOs) {
        this.business_yearDTOs = business_yearDTOs;
    }

    public List<InvoiceDTO> getInvoiceDTOs() {
        return invoiceDTOs;
    }

    public void setInvoiceDTOs(List<InvoiceDTO> invoiceDTOs) {
        this.invoiceDTOs = invoiceDTOs;
    }

    public List<DispatchNoteDTO> getDispatch_notesDTOs() {
        return dispatch_notesDTOs;
    }

    public void setDispatch_notesDTOs(List<DispatchNoteDTO> dispatch_notesDTOs) {
        this.dispatch_notesDTOs = dispatch_notesDTOs;
    }

    public List<ReceivingOrderDTO> getReceiving_orderDTOs() {
        return receiving_orderDTOs;
    }

    public void setReceiving_orderDTOs(List<ReceivingOrderDTO> receiving_orderDTOs) {
        this.receiving_orderDTOs = receiving_orderDTOs;
    }

    public Set<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(Set<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
