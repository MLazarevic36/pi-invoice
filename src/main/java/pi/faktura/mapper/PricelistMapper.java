package pi.faktura.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.PricelistDTO;
import pi.faktura.model.Pricelist;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PricelistMapper {

    @Autowired
    private ModelMapper modelMapper;


    private PricelistDTO convertToDto(Pricelist pricelist) {
        PricelistDTO pricelistDTO = modelMapper.map(pricelist, PricelistDTO.class);
        return pricelistDTO;
    }

    public  Set<PricelistDTO> convertToDtos(Page<Pricelist> pricelistPage) {
        return pricelistPage.stream().map(pricelist -> convertToDto(pricelist)).collect(Collectors.toSet());
    }

    private Pricelist convertToEntity(PricelistDTO pricelistDTO) {
        Pricelist pricelist = modelMapper.map(pricelistDTO, Pricelist.class);
        return pricelist;
    }

    public Set<Pricelist> convertToEntities(Collection<PricelistDTO> pricelistDTOS) {
        return pricelistDTOS
                .stream()
                .map(pricelistDTO -> convertToEntity(pricelistDTO))
                .collect(Collectors.toSet());
    }
}
