package pi.faktura.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GoodsDTO implements Serializable {

    private Long id;
    private String name;
    private String unit_of_measure;
    private GoodsGroupDTO goods_groupDTO;
    private Set<PricelistItemDTO> pricelist_itemDTOs = new HashSet<>();
    private List<InvoiceItemDTO> invoice_itemDTOs;
    private boolean deleted;

    public GoodsDTO() {
    }

    public GoodsDTO(Long id, String name, String unit_of_measure, GoodsGroupDTO goods_groupDTO, Set<PricelistItemDTO> pricelist_itemDTOs, List<InvoiceItemDTO> invoice_itemDTOs, boolean deleted) {
        this.id = id;
        this.name = name;
        this.unit_of_measure = unit_of_measure;
        this.goods_groupDTO = goods_groupDTO;
        this.pricelist_itemDTOs = pricelist_itemDTOs;
        this.invoice_itemDTOs = invoice_itemDTOs;
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

    public String getUnit_of_measure() {
        return unit_of_measure;
    }

    public void setUnit_of_measure(String unit_of_measure) {
        this.unit_of_measure = unit_of_measure;
    }

    public GoodsGroupDTO getGoods_groupDTO() {
        return goods_groupDTO;
    }

    public void setGoods_groupDTO(GoodsGroupDTO goods_groupDTO) {
        this.goods_groupDTO = goods_groupDTO;
    }

    public Set<PricelistItemDTO> getPricelist_itemDTOs() {
        return pricelist_itemDTOs;
    }

    public void setPricelist_itemDTOs(Set<PricelistItemDTO> pricelist_itemDTOs) {
        this.pricelist_itemDTOs = pricelist_itemDTOs;
    }

    public List<InvoiceItemDTO> getInvoice_itemDTOs() {
        return invoice_itemDTOs;
    }

    public void setInvoice_itemDTOs(List<InvoiceItemDTO> invoice_itemDTOs) {
        this.invoice_itemDTOs = invoice_itemDTOs;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
