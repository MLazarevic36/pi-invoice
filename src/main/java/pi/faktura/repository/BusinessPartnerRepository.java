package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Business_partner;

@Repository
public interface BusinessPartnerRepository extends JpaRepository<Business_partner, Long> {

}
