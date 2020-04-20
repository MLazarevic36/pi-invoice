package pi.faktura.dto;


import java.io.Serializable;

public class DispatchNoteItemDTO implements Serializable {

    private Long id;
    private Long number;
    private String name;
    private Long price;
    private Long delivered_quantity;
    private String note;
    private String measure_of_unit;
    private GoodsDTO goodsDTO;
    private DispatchNoteDTO dispatch_noteDTO;
    private boolean deleted;

    public DispatchNoteItemDTO() {
    }

    public DispatchNoteItemDTO(Long id, Long number, String name, Long price, Long delivered_quantity, String note, String measure_of_unit, GoodsDTO goodsDTO, DispatchNoteDTO dispatch_noteDTO, boolean deleted) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.price = price;
        this.delivered_quantity = delivered_quantity;
        this.note = note;
        this.measure_of_unit = measure_of_unit;
        this.goodsDTO = goodsDTO;
        this.dispatch_noteDTO = dispatch_noteDTO;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDelivered_quantity() {
        return delivered_quantity;
    }

    public void setDelivered_quantity(Long delivered_quantity) {
        this.delivered_quantity = delivered_quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMeasure_of_unit() {
        return measure_of_unit;
    }

    public void setMeasure_of_unit(String measure_of_unit) {
        this.measure_of_unit = measure_of_unit;
    }

    public GoodsDTO getGoodsDTO() {
        return goodsDTO;
    }

    public void setGoodsDTO(GoodsDTO goodsDTO) {
        this.goodsDTO = goodsDTO;
    }

    public DispatchNoteDTO getDispatch_noteDTO() {
        return dispatch_noteDTO;
    }

    public void setDispatch_noteDTO(DispatchNoteDTO dispatch_noteDTO) {
        this.dispatch_noteDTO = dispatch_noteDTO;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
