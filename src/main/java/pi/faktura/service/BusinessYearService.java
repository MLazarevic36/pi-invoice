package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Business_year;
import pi.faktura.repository.BusinessYearRepository;
import pi.faktura.service.interfaces.BusinessYearInterface;

@Service
public class BusinessYearService implements BusinessYearInterface {

    @Autowired
    private BusinessYearRepository businessYearRepository;

    @Override
    public Business_year findOne(Long id) {
        return businessYearRepository.getOne(id);
    }

    @Override
    public Page<Business_year> findAll(Pageable pageable) {
        return businessYearRepository.findAll(pageable);
    }

    @Override
    public Business_year save(Business_year business_year) {
        return businessYearRepository.save(business_year);
    }

    @Override
    public Business_year update(Business_year business_year) {
        return businessYearRepository.save(business_year);
    }

    @Override
    public void delete(Business_year business_year) {
        business_year.setFinished(true);
        businessYearRepository.save(business_year);
    }
}
