package pi.faktura.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.PricelistDTO;
import pi.faktura.model.Pricelist;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PricelistMapper implements Mapper<Pricelist, PricelistDTO> {

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    PricelistItemMapper pricelistItemMapper;

    @Override
    public PricelistDTO toDTO(Pricelist entity) {

        PricelistDTO pricelistDTO = new PricelistDTO();
        pricelistDTO.setId(entity.getId());
        pricelistDTO.setSerial_number(entity.getSerial_number());
        pricelistDTO.setExpiration_date(entity.getExpiration_date());
        pricelistDTO.setCreation_date(entity.getCreation_date());
        pricelistDTO.setActive(entity.isActive());
        pricelistDTO.setCompany(companyMapper.toDTO(entity.getCompany()));
        pricelistDTO.setPricelist_itemDTOs(pricelistItemMapper.toDTO(entity.getPricelist_items()));
        pricelistDTO.setDeleted(entity.isDeleted());

        return pricelistDTO;
    }

    @Override
    public Pricelist toEntity(PricelistDTO pricelistDTO) {

        Pricelist pricelist = new Pricelist();
        pricelist.setSerial_number(pricelistDTO.getSerial_number());
        pricelist.setExpiration_date(pricelistDTO.getExpiration_date());
        pricelist.setCreation_date(pricelistDTO.getCreation_date());
        pricelist.setActive(pricelistDTO.isActive());
        pricelist.setCompany(companyMapper.toEntity(pricelistDTO.getCompany()));
        pricelist.setPricelist_items(pricelistItemMapper.toEntity(pricelistDTO.getPricelist_itemDTOs()));
        pricelist.setDeleted(pricelistDTO.isDeleted());

        return pricelist;
    }

    @Override
    public Set<PricelistDTO> toDTO(Collection<Pricelist> entities) {
        return entities
                .stream()
                .map(pricelist -> toDTO(pricelist))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Pricelist> toEntity(Collection<PricelistDTO> pricelistDTOS) {
        return pricelistDTOS
                .stream()
                .map(pricelistDTO -> toEntity(pricelistDTO))
                .collect(Collectors.toSet());
    }
}
