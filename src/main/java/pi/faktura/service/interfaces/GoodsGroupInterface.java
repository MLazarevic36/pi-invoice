package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Goods_group;

public interface GoodsGroupInterface {

    Goods_group findOne(Long id);
    Page<Goods_group> findAll(Pageable pageable);
    Goods_group save(Goods_group goods_group);
    Goods_group update(Goods_group goods_group);
    void delete(Goods_group goods_group);

}
