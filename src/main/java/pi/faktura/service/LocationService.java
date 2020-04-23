package pi.faktura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pi.faktura.model.Location;
import pi.faktura.repository.LocationRepository;
import pi.faktura.service.interfaces.LocationInterface;

@Service
public class LocationService implements LocationInterface {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location findOne(Long id) {
        return locationRepository.getOne(id);
    }

    @Override
    public Page<Location> findAll(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location update(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void delete(Location location) {

        location.setDeleted(true);
        locationRepository.save(location);

    }
}
