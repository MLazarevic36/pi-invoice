package pi.faktura.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company getByName(String name);

}
