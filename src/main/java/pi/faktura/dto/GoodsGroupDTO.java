package pi.faktura.dto;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
public class GoodsGroupDTO implements Serializable {

    private Long id;
    private String name;
    private Date creation_date;
    private VatDTO vat;
    private CompanyDTO companyDTO;
    private Set<GoodsDTO> goodsDTOs = new HashSet<>();
    private boolean deleted;

    public GoodsGroupDTO(Long id, String name, Date creation_date, VatDTO vat, CompanyDTO companyDTO, Set<GoodsDTO> goodsDTOs, boolean deleted) {
        this.id = id;
        this.name = name;
        this.creation_date = creation_date;
        this.vat = vat;
        this.companyDTO = companyDTO;
        this.goodsDTOs = goodsDTOs;
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

    public VatDTO getVat() {
        return vat;
    }

    public void setVat(VatDTO vat) {
        this.vat = vat;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public Set<GoodsDTO> getGoodsDTOs() {
        return goodsDTOs;
    }

    public void setGoodsDTOs(Set<GoodsDTO> goodsDTOs) {
        this.goodsDTOs = goodsDTOs;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
