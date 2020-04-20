package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.GoodsDTO;
import pi.faktura.model.Goods;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GoodsMapper implements Mapper<Goods, GoodsDTO> {

    @Autowired
    GoodsGroupMapper goodsGroupMapper;

    @Autowired
    PricelistItemMapper pricelistItemMapper;

    @Autowired
    InvoiceItemMapper invoiceItemMapper;

    @Override
    public GoodsDTO toDTO(Goods entity) {

        GoodsDTO goodsDTO = new GoodsDTO();

        goodsDTO.setId(entity.getId());
        goodsDTO.setName(entity.getName());
        goodsDTO.setUnit_of_measure(entity.getUnit_of_measure());
        goodsDTO.setGoods_groupDTO(goodsGroupMapper.toDTO(entity.getGroup()));
        goodsDTO.setPricelist_itemDTOs(pricelistItemMapper.toDTO(entity.getPricelist_items()));
        goodsDTO.setInvoice_itemDTOs(invoiceItemMapper.toDTOList(entity.getInvoice_items()));
        goodsDTO.setDeleted(entity.isDeleted());


        return goodsDTO;
    }

    @Override
    public Goods toEntity(GoodsDTO goodsDTO) {

        Goods goods = new Goods();

        goods.setName(goodsDTO.getName());
        goods.setUnit_of_measure(goodsDTO.getUnit_of_measure());
        goods.setGroup(goodsGroupMapper.toEntity(goodsDTO.getGoods_groupDTO()));
        goods.setPricelist_items(pricelistItemMapper.toEntity(goodsDTO.getPricelist_itemDTOs()));
        goods.setInvoice_items(invoiceItemMapper.toEntityList(goodsDTO.getInvoice_itemDTOs()));
        goods.setDeleted(goodsDTO.isDeleted());

        return goods;
    }

    public Goods toEntityWithId(GoodsDTO goodsDTO) {
        Goods goods = new Goods();

        goods.setId(goodsDTO.getId());
        goods.setName(goodsDTO.getName());
        goods.setUnit_of_measure(goodsDTO.getUnit_of_measure());
        goods.setGroup(goodsGroupMapper.toEntity(goodsDTO.getGoods_groupDTO()));
        goods.setPricelist_items(pricelistItemMapper.toEntity(goodsDTO.getPricelist_itemDTOs()));
        goods.setInvoice_items(invoiceItemMapper.toEntityList(goodsDTO.getInvoice_itemDTOs()));
        goods.setDeleted(goodsDTO.isDeleted());

        return goods;
    }

    @Override
    public Set<GoodsDTO> toDTO(Collection<Goods> entities) {
        return entities
                .stream()
                .map(goods -> toDTO(goods))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Goods> toEntity(Collection<GoodsDTO> goodsDTOS) {
        return goodsDTOS
                .stream()
                .map(goodsDTO -> toEntity(goodsDTO))
                .collect(Collectors.toSet());
    }
}
