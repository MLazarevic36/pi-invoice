package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Goods;
import pi.faktura.repository.GoodsRepository;
import pi.faktura.service.interfaces.GoodsInterface;

@Service
public class GoodsService implements GoodsInterface {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods findOne(Long id) {
        return goodsRepository.getOne(id);
    }

    @Override
    public Page<Goods> findAll(Pageable pageable) {
        return goodsRepository.findAll(pageable);
    }

    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public Goods update(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public void delete(Goods goods) {
        goods.setDeleted(true);
        goodsRepository.save(goods);
    }
}
