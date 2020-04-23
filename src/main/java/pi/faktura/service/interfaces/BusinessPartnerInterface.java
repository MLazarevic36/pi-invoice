package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Business_partner;

public interface BusinessPartnerInterface {

    Business_partner findOne(Long id);
    Page<Business_partner> findAll(Pageable pageable);
    Business_partner save(Business_partner business_partner);
    Business_partner update(Business_partner business_partner);
    void delete(Business_partner business_partner);

}
