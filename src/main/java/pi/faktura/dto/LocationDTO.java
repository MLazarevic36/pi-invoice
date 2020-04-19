package pi.faktura.dto;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
public class LocationDTO implements Serializable {

    private Long id;
    private String city;
    private Long zip_code;
    private Set<CompanyDTO> companyDTOs = new HashSet<>();
    private Set<BusinessPartnerDTO> business_partnerDTOs = new HashSet<>();
    private boolean deleted;

    public LocationDTO(Long id, String city, Long zip_code, Set<CompanyDTO> companyDTOs, Set<BusinessPartnerDTO> business_partnerDTOs, boolean deleted) {
        this.id = id;
        this.city = city;
        this.zip_code = zip_code;
        this.companyDTOs = companyDTOs;
        this.business_partnerDTOs = business_partnerDTOs;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZip_code() {
        return zip_code;
    }

    public void setZip_code(Long zip_code) {
        this.zip_code = zip_code;
    }

    public Set<CompanyDTO> getCompanieDTOs() {
        return companyDTOs;
    }

    public void setCompanieDTOs(Set<CompanyDTO> companyDTOs) {
        this.companyDTOs = companyDTOs;
    }

    public Set<BusinessPartnerDTO> getBusiness_partnerDTOs() {
        return business_partnerDTOs;
    }

    public void setBusiness_partnerDTOs(Set<BusinessPartnerDTO> business_partnerDTOs) {
        this.business_partnerDTOs = business_partnerDTOs;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
