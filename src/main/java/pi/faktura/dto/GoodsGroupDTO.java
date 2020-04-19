package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Goods_group;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class GoodsGroupDTO implements Serializable {

    private Long id;
    private String name;
    private Date creation_date;
    private VatDTO vat;
    private CompanyDTO company;
    private boolean deleted;

    public GoodsGroupDTO(Long id, String name, Date creation_date, VatDTO vat, CompanyDTO company, boolean deleted) {
        this.id = id;
        this.name = name;
        this.creation_date = creation_date;
        this.vat = vat;
        this.company = company;
        this.deleted = deleted;
    }

    public GoodsGroupDTO(Goods_group g) {
        this(g.getId(), g.getName(), g.getCreation_date(),
                new VatDTO(g.getVat()), new CompanyDTO(g.getCompany()), g.isDeleted());
    }

}
