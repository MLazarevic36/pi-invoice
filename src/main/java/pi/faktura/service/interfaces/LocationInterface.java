package pi.faktura.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.faktura.model.Location;

public interface LocationInterface {

    Location findOne(Long id);
    Page<Location> findAll(Pageable pageable);
    Location save(Location location);
    Location update(Location location);
    void delete(Location location);
}
