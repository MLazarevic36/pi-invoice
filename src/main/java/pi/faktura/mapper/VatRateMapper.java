package pi.faktura.mapper;

import org.springframework.stereotype.Component;
import pi.faktura.dto.VatRateDTO;
import pi.faktura.model.VAT_rate;

import java.util.Collection;
import java.util.Set;

@Component
public class VatRateMapper implements Mapper<VAT_rate, VatRateDTO> {

    @Override
    public VatRateDTO toDTO(VAT_rate entity) {
        return null;
    }

    @Override
    public VAT_rate toEntity(VatRateDTO vatRateDTO) {
        return null;
    }

    @Override
    public Set<VatRateDTO> toDTO(Collection<VAT_rate> entities) {
        return null;
    }

    @Override
    public Set<VAT_rate> toEntity(Collection<VatRateDTO> vatRateDTOS) {
        return null;
    }
}
