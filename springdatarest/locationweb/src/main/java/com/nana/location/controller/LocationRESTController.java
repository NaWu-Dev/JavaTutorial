package com.nana.location.controller;

import com.nana.location.entity.Location;
import com.nana.location.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
