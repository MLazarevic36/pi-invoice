package pi.faktura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.faktura.dto.LocationDTO;
import pi.faktura.mapper.LocationMapper;
import pi.faktura.model.Location;
import pi.faktura.service.LocationService;

import java.util.Set;

@RestController
@RequestMapping(value = "api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationMapper locationMapper;

    @GetMapping
    public ResponseEntity<Set<LocationDTO>> getLocations(Pageable pageable) {
        try {
            Page<Location> locations = locationService.findAll(pageable);
            return new ResponseEntity<>(locationMapper.convertToDtos(locations),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocationDTO> getLocation(@PathVariable("id") Long id){
        try {
            Location location = locationService.findOne(id);
            return new ResponseEntity<>(locationMapper.convertToDto(location), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<LocationDTO> addLocation(@RequestBody LocationDTO locationDTO) {
        Location location = locationMapper.convertToEntity(locationDTO);
        try {
            location = locationService.save(location);
            return new ResponseEntity<>(locationMapper.convertToDto(location), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<LocationDTO> updateLocation(@RequestBody LocationDTO locationDTO) {
        Location location = locationMapper.convertToEntity(locationDTO);
        try {
            location.setId(locationDTO.getId());
            location = locationService.save(location);
            return new ResponseEntity<>(locationMapper.convertToDto(location), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("id") Long id) {
        try {
            Location location = locationService.findOne(id);
            location.setDeleted(true);
            locationService.save(location);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
