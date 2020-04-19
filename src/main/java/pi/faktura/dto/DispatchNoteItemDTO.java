package pi.faktura.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Dispatch_note_item;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class DispatchNoteItemDTO implements Serializable {

    private Long id;
    private Long number;
    private String name;
    private Long price;
    private Long delivered_quantity;
    private String note;
    private String meausure_of_unit;
    private GoodsDTO goods;
    private DispatchNoteDTO dispatch_note;
    private boolean deleted;

    public DispatchNoteItemDTO(Long id, Long number, String name, Long price, Long delivered_quantity, String note, String meausure_of_unit, GoodsDTO goods, DispatchNoteDTO dispatch_note, boolean deleted) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.price = price;
        this.delivered_quantity = delivered_quantity;
        this.note = note;
        this.meausure_of_unit = meausure_of_unit;
        this.goods = goods;
        this.dispatch_note = dispatch_note;
        this.deleted = deleted;
    }

    public DispatchNoteItemDTO(Dispatch_note_item d) {
        this(d.getId(), d.getNumber(), d.getName(), d.getPrice(), d.getDelivered_quantity(),
                d.getNote(), d.getMeasure_of_unit(), new GoodsDTO(d.getGoods()),
                new DispatchNoteDTO(d.getDispatch_note()), d.isDeleted());
    }
}
