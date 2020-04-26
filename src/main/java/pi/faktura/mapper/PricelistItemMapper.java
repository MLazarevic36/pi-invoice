package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.PricelistItemDTO;
import pi.faktura.model.Pricelist_item;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class PricelistItemMapper {

    @Autowired
    private ModelMapper modelMapper;


    public PricelistItemDTO convertToDto(Pricelist_item pricelist_item) {
        PricelistItemDTO pricelistItemDTO = modelMapper.map(pricelist_item, PricelistItemDTO.class);
        return pricelistItemDTO;
    }

    public  Set<PricelistItemDTO> convertToDtos(Page<Pricelist_item> pricelist_itemPage) {
        return pricelist_itemPage.stream().map(pricelist_item -> convertToDto(pricelist_item)).collect(Collectors.toSet());
    }

    public Pricelist_item convertToEntity(PricelistItemDTO pricelistItemDTO) {
        Pricelist_item pricelist_item = modelMapper.map(pricelistItemDTO, Pricelist_item.class);
        return pricelist_item;
    }

    public Set<Pricelist_item> convertToEntities(Collection<PricelistItemDTO> pricelistItemDTOS) {
        return pricelistItemDTOS
                .stream()
                .map(pricelistItemDTO -> convertToEntity(pricelistItemDTO))
                .collect(Collectors.toSet());
    }

}
