package pi.faktura.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class PricelistDTO implements Serializable {

    private Long id;
    private Long serial_number;
    private Date expiration_date;
    private Date creation_date;
    private boolean active;
    private CompanyDTO company;
    private Set<PricelistItemDTO> pricelist_itemDTOs = new HashSet<>();
    private boolean deleted;

    public PricelistDTO() {
    }

    public PricelistDTO(Long id, Long serial_number, Date expiration_date, Date creation_date, boolean active, CompanyDTO company, Set<PricelistItemDTO> pricelist_itemDTOs, boolean deleted) {
        this.id = id;
        this.serial_number = serial_number;
        this.expiration_date = expiration_date;
        this.creation_date = creation_date;
        this.active = active;
        this.company = company;
        this.pricelist_itemDTOs = pricelist_itemDTOs;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(Long serial_number) {
        this.serial_number = serial_number;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public Set<PricelistItemDTO> getPricelist_itemDTOs() {
        return pricelist_itemDTOs;
    }

    public void setPricelist_itemDTOs(Set<PricelistItemDTO> pricelist_itemDTOs) {
        this.pricelist_itemDTOs = pricelist_itemDTOs;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
