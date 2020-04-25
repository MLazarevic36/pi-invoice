package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.GoodsDTO;
import pi.faktura.model.Goods;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GoodsMapper  {

    @Autowired
    private ModelMapper modelMapper;


    private GoodsDTO convertToDto(Goods goods) {
        GoodsDTO goodsDTO = modelMapper.map(goods, GoodsDTO.class);
        return goodsDTO;
    }

    public  Set<GoodsDTO> convertToDtos(Page<Goods> goodsPage) {
        return goodsPage.stream().map(goods -> convertToDto(goods)).collect(Collectors.toSet());
    }

    private Goods convertToEntity(GoodsDTO goodsDTO) {
        Goods goods = modelMapper.map(goodsDTO, Goods.class);
        return goods;
    }

    public Set<Goods> convertToEntities(Collection<GoodsDTO> goodsDTOS) {
        return goodsDTOS
                .stream()
                .map(goodsDTO -> convertToEntity(goodsDTO))
                .collect(Collectors.toSet());
    }
}
