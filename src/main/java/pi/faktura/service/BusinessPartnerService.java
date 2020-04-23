package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Business_partner;
import pi.faktura.repository.BusinessPartnerRepository;
import pi.faktura.service.interfaces.BusinessPartnerInterface;

@Service
public class BusinessPartnerService implements BusinessPartnerInterface {

    @Autowired
    private BusinessPartnerRepository businessPartnerRepository;

    @Override
    public Business_partner findOne(Long id) {
        return businessPartnerRepository.getOne(id);
    }

    @Override
    public Page<Business_partner> findAll(Pageable pageable) {
        return businessPartnerRepository.findAll(pageable);
    }

    @Override
    public Business_partner save(Business_partner business_partner) {
        return businessPartnerRepository.save(business_partner);
    }

    @Override
    public Business_partner update(Business_partner business_partner) {
        return businessPartnerRepository.save(business_partner);
    }

    @Override
    public void delete(Business_partner business_partner) {

        business_partner.setDeleted(true);
        businessPartnerRepository.save(business_partner);

    }
}
