package com.nana.location.controller;

import com.nana.location.entity.Location;
import com.nana.location.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping()
    public List<Location> getLocation() {

        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {

        return locationRepository.save(location);

    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location) {

        return locationRepository.save(location);

    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id) {

        locationRepository.deleteById(id);

    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable("id") int id) {

        return locationRepository.findById(id).get();

    }

}
