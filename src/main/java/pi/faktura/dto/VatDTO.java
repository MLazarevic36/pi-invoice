package pi.faktura.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class VatDTO implements Serializable {

    private Long id;
    private String name;
    private Set<VatRateDTO> ratesDTOs = new HashSet<>();
    private Set<GoodsGroupDTO> groupDTOs = new HashSet<>();
    private boolean deleted;

    public VatDTO() {
    }

    public VatDTO(Long id, String name, Set<VatRateDTO> ratesDTOs, Set<GoodsGroupDTO> groupDTOs, boolean deleted) {
        this.id = id;
        this.name = name;
        this.ratesDTOs = ratesDTOs;
        this.groupDTOs = groupDTOs;
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

    public Set<VatRateDTO> getRatesDTOs() {
        return ratesDTOs;
    }

    public void setRatesDTOs(Set<VatRateDTO> ratesDTOs) {
        this.ratesDTOs = ratesDTOs;
    }

    public Set<GoodsGroupDTO> getGroupDTOs() {
        return groupDTOs;
    }

    public void setGroupDTOs(Set<GoodsGroupDTO> groupDTOs) {
        this.groupDTOs = groupDTOs;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
