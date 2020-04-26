package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.GoodsGroupDTO;
import pi.faktura.model.Goods_group;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GoodsGroupMapper {

    @Autowired
    private ModelMapper modelMapper;


    public GoodsGroupDTO convertToDto(Goods_group goods_group) {
        GoodsGroupDTO goodsGroupDTO = modelMapper.map(goods_group, GoodsGroupDTO.class);
        return goodsGroupDTO;
    }

    public  Set<GoodsGroupDTO> convertToDtos(Page<Goods_group> goods_groupPage) {
        return goods_groupPage.stream().map(goods_group -> convertToDto(goods_group)).collect(Collectors.toSet());
    }

    public Goods_group convertToEntity(GoodsGroupDTO goodsGroupDTO) {
        Goods_group goods_group = modelMapper.map(goodsGroupDTO, Goods_group.class);
        return goods_group;
    }

    public Set<Goods_group> convertToEntities(Collection<GoodsGroupDTO> goodsGroupDTOS) {
        return goodsGroupDTOS
                .stream()
                .map(goodsGroupDTO -> convertToEntity(goodsGroupDTO))
                .collect(Collectors.toSet());
    }
}
