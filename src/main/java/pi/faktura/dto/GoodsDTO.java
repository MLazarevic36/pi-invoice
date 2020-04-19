package pi.faktura.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Goods;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class GoodsDTO implements Serializable {

    private Long id;
    private String name;
    private String unit_of_measure;
    private GoodsGroupDTO goods_group;
    private boolean deleted;

    public GoodsDTO(Long id, String name, String unit_of_measure, GoodsGroupDTO goods_group, boolean deleted) {
        this.id = id;
        this.name = name;
        this.unit_of_measure = unit_of_measure;
        this.goods_group = goods_group;
        this.deleted = deleted;
    }

    public GoodsDTO(Goods g) {
        this(g.getId(), g.getName(), g.getUnit_of_measure(), new GoodsGroupDTO(g.getGroup()), g.isDeleted());
    }
}
