package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.GoodsGroupDTO;
import pi.faktura.model.Goods_group;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GoodsGroupMapper implements Mapper<Goods_group, GoodsGroupDTO> {

    @Autowired
    VatMapper vatMapper;

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public GoodsGroupDTO toDTO(Goods_group entity) {

        GoodsGroupDTO goodsGroupDTO = new GoodsGroupDTO();
        goodsGroupDTO.setId(entity.getId());
        goodsGroupDTO.setName(entity.getName());
        goodsGroupDTO.setCreation_date(entity.getCreation_date());
        goodsGroupDTO.setVat(vatMapper.toDTO(entity.getVat()));
        goodsGroupDTO.setCompanyDTO(companyMapper.toDTO(entity.getCompany()));
        goodsGroupDTO.setGoodsDTOs(goodsMapper.toDTO(entity.getGoods()));
        goodsGroupDTO.setDeleted(entity.isDeleted());

        return goodsGroupDTO;
    }

    @Override
    public Goods_group toEntity(GoodsGroupDTO goodsGroupDTO) {

        Goods_group goods_group = new Goods_group();

        goods_group.setName(goodsGroupDTO.getName());
        goods_group.setCreation_date(goodsGroupDTO.getCreation_date());
        goods_group.setVat(vatMapper.toEntity(goodsGroupDTO.getVat()));
        goods_group.setCompany(companyMapper.toEntity(goodsGroupDTO.getCompanyDTO()));
        goods_group.setGoods(goodsMapper.toEntity(goodsGroupDTO.getGoodsDTOs()));
        goods_group.setDeleted(goodsGroupDTO.isDeleted());

        return goods_group;
    }

    public Goods_group toEntityWithId (GoodsGroupDTO goodsGroupDTO) {

        Goods_group goods_group = new Goods_group();

        goods_group.setId(goodsGroupDTO.getId());
        goods_group.setName(goodsGroupDTO.getName());
        goods_group.setCreation_date(goodsGroupDTO.getCreation_date());
        goods_group.setVat(vatMapper.toEntity(goodsGroupDTO.getVat()));
        goods_group.setCompany(companyMapper.toEntity(goodsGroupDTO.getCompanyDTO()));
        goods_group.setGoods(goodsMapper.toEntity(goodsGroupDTO.getGoodsDTOs()));
        goods_group.setDeleted(goodsGroupDTO.isDeleted());

        return goods_group;
    }


    @Override
    public Set<GoodsGroupDTO> toDTO(Collection<Goods_group> entities) {
        return entities
                .stream()
                .map(goods_group -> toDTO(goods_group))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Goods_group> toEntity(Collection<GoodsGroupDTO> goodsGroupDTOS) {
        return goodsGroupDTOS
                .stream()
                .map(goodsGroupDTO -> toEntity(goodsGroupDTO))
                .collect(Collectors.toSet());
    }
}
