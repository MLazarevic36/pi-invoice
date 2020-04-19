package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Pricelist_item;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class PricelistItemDTO implements Serializable {

    private Long id;
    private Long price;
    private GoodsDTO goods;
    private PricelistDTO pricelist;
    private boolean deleted;

    public PricelistItemDTO(Long id, Long price, GoodsDTO goods, PricelistDTO pricelist, boolean deleted) {
        this.id = id;
        this.price = price;
        this.goods = goods;
        this.pricelist = pricelist;
        this.deleted = deleted;
    }

    public PricelistItemDTO(Pricelist_item p) {
        this(p.getId(), p.getPrice(), new GoodsDTO(p.getGoods()), new PricelistDTO(p.getPricelist()), p.isDeleted());
    }
}
