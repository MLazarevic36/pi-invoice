package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Business_year;

@Repository
public interface BusinessYearRepository extends JpaRepository<Business_year, Long> {
}
