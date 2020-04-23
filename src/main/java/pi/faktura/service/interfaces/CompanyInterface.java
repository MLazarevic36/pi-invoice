package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Company;

public interface CompanyInterface {

    Company findOne(Long id);
    Page<Company> findAll(Pageable pageable);
    Company save(Company company);
    Company update(Company company);
    void delete(Company company);
}
