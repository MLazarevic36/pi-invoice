package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
