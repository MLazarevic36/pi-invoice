package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Goods_group;
import pi.faktura.repository.GoodsGroupRepository;
import pi.faktura.service.interfaces.GoodsGroupInterface;

@Service
public class GoodsGroupService implements GoodsGroupInterface {

    @Autowired
    private GoodsGroupRepository goodsGroupRepository;

    @Override
    public Goods_group findOne(Long id) {
        return goodsGroupRepository.getOne(id);
    }

    @Override
    public Page<Goods_group> findAll(Pageable pageable) {
        return goodsGroupRepository.findAll(pageable);
    }

    @Override
    public Goods_group save(Goods_group goods_group) {
        return goodsGroupRepository.save(goods_group);
    }

    @Override
    public Goods_group update(Goods_group goods_group) {
        return goodsGroupRepository.save(goods_group);
    }

    @Override
    public void delete(Goods_group goods_group) {

        goods_group.setDeleted(true);
        goodsGroupRepository.save(goods_group);

    }
}
