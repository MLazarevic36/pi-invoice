package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.VatDTO;
import pi.faktura.model.VAT;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class VatMapper {

    @Autowired
    private ModelMapper modelMapper;


    private VatDTO convertToDto(VAT vat) {
        VatDTO vatDTO = modelMapper.map(vat, VatDTO.class);
        return vatDTO;
    }

    public  Set<VatDTO> convertToDtos(Page<VAT> vatPage) {
        return vatPage.stream().map(vat -> convertToDto(vat)).collect(Collectors.toSet());
    }

    private VAT convertToEntity(VatDTO vatDTO) {
        VAT vat = modelMapper.map(vatDTO, VAT.class);
        return vat;
    }

    public Set<VAT> convertToEntities(Collection<VatDTO> vatDTOS) {
        return vatDTOS
                .stream()
                .map(vatDTO -> convertToEntity(vatDTO))
                .collect(Collectors.toSet());
    }
}
