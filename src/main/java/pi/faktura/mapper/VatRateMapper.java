package pi.faktura.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pi.faktura.dto.VatRateDTO;
import pi.faktura.model.VAT_rate;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class VatRateMapper {

    @Autowired
    private ModelMapper modelMapper;


    private VatRateDTO convertToDto(VAT_rate vat_rate) {
        VatRateDTO vatRateDTO = modelMapper.map(vat_rate, VatRateDTO.class);
        return vatRateDTO;
    }

    public  Set<VatRateDTO> convertToDtos(Page<VAT_rate> vatRatePage) {
        return vatRatePage.stream().map(vat_rate -> convertToDto(vat_rate)).collect(Collectors.toSet());
    }

    private VAT_rate convertToEntity(VatRateDTO vatRateDTO) {
        VAT_rate vat_rate = modelMapper.map(vatRateDTO, VAT_rate.class);
        return vat_rate;
    }

    public Set<VAT_rate> convertToEntities(Collection<VatRateDTO> vatRateDTOS) {
        return vatRateDTOS
                .stream()
                .map(vatRateDTO -> convertToEntity(vatRateDTO))
                .collect(Collectors.toSet());
    }


}
