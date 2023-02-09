package com.example.controller;

import com.example.entity.ThemeParkRide;
import com.example.repository.ThemeParkRideRepository;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@RestController
public class ThemeParkRideController {
	private static final Logger logger = LoggerFactory.getLogger(ThemeParkRideController.class);
	
	private final ThemeParkRideRepository themeParkRideRepository;

    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
        this.themeParkRideRepository = themeParkRideRepository;
    }

    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRide> getRides() {
        logger.info("/ride-getAllRides");
    	return themeParkRideRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide getRide(@PathVariable long id){
    	logger.info("/ride-getRideById - input ID: " +id);
        return themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide) {
    	logger.info("/ride-createRide - input: " +themeParkRide.toString());
        return themeParkRideRepository.save(themeParkRide);
    }
}
