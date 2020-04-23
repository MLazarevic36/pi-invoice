package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Goods;
import pi.faktura.model.Goods_group;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    Goods getByName(String name);
}
