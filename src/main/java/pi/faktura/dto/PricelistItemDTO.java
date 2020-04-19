package pi.faktura.dto;

import lombok.NoArgsConstructor;


import java.io.Serializable;


@NoArgsConstructor
public class PricelistItemDTO implements Serializable {

    private Long id;
    private Long price;
    private GoodsDTO goodsDTO;
    private PricelistDTO pricelistDTO;
    private boolean deleted;

    public PricelistItemDTO(Long id, Long price, GoodsDTO goodsDTO, PricelistDTO pricelistDTO, boolean deleted) {
        this.id = id;
        this.price = price;
        this.goodsDTO = goodsDTO;
        this.pricelistDTO = pricelistDTO;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public GoodsDTO getGoodsDTO() {
        return goodsDTO;
    }

    public void setGoodsDTO(GoodsDTO goodsDTO) {
        this.goodsDTO = goodsDTO;
    }

    public PricelistDTO getPricelistDTO() {
        return pricelistDTO;
    }

    public void setPricelistDTO(PricelistDTO pricelistDTO) {
        this.pricelistDTO = pricelistDTO;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
