package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Business_year;

public interface BusinessYearInterface {

    Business_year findOne(Long id);
    Page<Business_year> findAll(Pageable pageable);
    Business_year save(Business_year business_year);
    Business_year update(Business_year business_year);
    void delete(Business_year business_year);


}
