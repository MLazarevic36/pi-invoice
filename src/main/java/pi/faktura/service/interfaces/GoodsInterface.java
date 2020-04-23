package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Goods;

public interface GoodsInterface {

    Goods findOne(Long id);
    Page<Goods> findAll(Pageable pageable);
    Goods save(Goods goods);
    Goods update(Goods goods);
    void delete(Goods goods);
}
