package pi.faktura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.faktura.dto.VatDTO;
import pi.faktura.model.VAT;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class VatMapper implements Mapper<VAT, VatDTO> {

    @Autowired
    VatRateMapper vatRateMapper;

    @Autowired
    GoodsGroupMapper goodsGroupMapper;

    @Override
    public VatDTO toDTO(VAT entity) {

        VatDTO vatDTO = new VatDTO();
        vatDTO.setId(entity.getId());
        vatDTO.setName(entity.getName());
        vatDTO.setRatesDTOs(vatRateMapper.toDTO(entity.getRates()));
        vatDTO.setGroupDTOs(goodsGroupMapper.toDTO(entity.getGroups()));
        vatDTO.setDeleted(entity.isDeleted());

        return vatDTO;
    }

    @Override
    public VAT toEntity(VatDTO vatDTO) {

        VAT vat = new VAT();
        vat.setName(vatDTO.getName());
        vat.setRates(vatRateMapper.toEntity(vatDTO.getRatesDTOs()));
        vat.setGroups(goodsGroupMapper.toEntity(vatDTO.getGroupDTOs()));
        vat.setDeleted(vatDTO.isDeleted());

        return vat;
    }

    public VAT toEntityWithId(VatDTO vatDTO) {

        VAT vat = new VAT();
        vat.setId(vatDTO.getId());
        vat.setName(vatDTO.getName());
        vat.setRates(vatRateMapper.toEntity(vatDTO.getRatesDTOs()));
        vat.setGroups(goodsGroupMapper.toEntity(vatDTO.getGroupDTOs()));
        vat.setDeleted(vatDTO.isDeleted());

        return vat;
    }

    @Override
    public Set<VatDTO> toDTO(Collection<VAT> entities) {
        return entities
                .stream()
                .map(vat -> toDTO(vat))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<VAT> toEntity(Collection<VatDTO> vatDTOS) {
        return vatDTOS
                .stream()
                .map(vatDTO -> toEntity(vatDTO))
                .collect(Collectors.toSet());
    }
}
