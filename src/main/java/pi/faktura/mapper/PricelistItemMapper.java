package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.PricelistItemDTO;
import pi.faktura.model.Pricelist_item;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class PricelistItemMapper implements Mapper<Pricelist_item, PricelistItemDTO> {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    PricelistMapper pricelistMapper;

    @Override
    public PricelistItemDTO toDTO(Pricelist_item entity) {

        PricelistItemDTO pricelistItemDTO = new PricelistItemDTO();
        pricelistItemDTO.setId(entity.getId());
        pricelistItemDTO.setPrice(entity.getPrice());
        pricelistItemDTO.setGoodsDTO(goodsMapper.toDTO(entity.getGoods()));
        pricelistItemDTO.setPricelistDTO(pricelistMapper.toDTO(entity.getPricelist()));
        pricelistItemDTO.setDeleted(entity.isDeleted());

        return pricelistItemDTO;
    }

    @Override
    public Pricelist_item toEntity(PricelistItemDTO pricelistItemDTO) {

        Pricelist_item pricelist_item = new Pricelist_item();
        pricelist_item.setPrice(pricelistItemDTO.getPrice());
        pricelist_item.setGoods(goodsMapper.toEntity(pricelistItemDTO.getGoodsDTO()));
        pricelist_item.setPricelist(pricelistMapper.toEntity(pricelistItemDTO.getPricelistDTO()));
        pricelist_item.setDeleted(pricelistItemDTO.isDeleted());

        return pricelist_item;
    }

    public Pricelist_item toEntityWithId(PricelistItemDTO pricelistItemDTO) {

        Pricelist_item pricelist_item = new Pricelist_item();

        pricelist_item.setId(pricelistItemDTO.getId());
        pricelist_item.setPrice(pricelistItemDTO.getPrice());
        pricelist_item.setGoods(goodsMapper.toEntity(pricelistItemDTO.getGoodsDTO()));
        pricelist_item.setPricelist(pricelistMapper.toEntity(pricelistItemDTO.getPricelistDTO()));
        pricelist_item.setDeleted(pricelistItemDTO.isDeleted());

        return pricelist_item;
    }

    @Override
    public Set<PricelistItemDTO> toDTO(Collection<Pricelist_item> entities) {
        return entities
                .stream()
                .map(pricelist_item -> toDTO(pricelist_item))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Pricelist_item> toEntity(Collection<PricelistItemDTO> pricelistItemDTOS) {
        return pricelistItemDTOS
                .stream()
                .map(pricelistItemDTO -> toEntity(pricelistItemDTO))
                .collect(Collectors.toSet());
    }



}
