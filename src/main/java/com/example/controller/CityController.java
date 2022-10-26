package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

	private CityService cityService;

	@GetMapping("/{countryId}")
	public ResponseEntity<List<String>> getCitiesForCountry(@PathVariable Integer countryId) {

		return ResponseEntity.ok(cityService.getcities(countryId));
	}

	@GetMapping("/cache/clear")
	public ResponseEntity<Void> ClearCache() {

		cityService.clearCitiesFromCache();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
