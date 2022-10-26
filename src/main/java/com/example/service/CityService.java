package com.example.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.repository.CityRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CityService {

	private CityRepository cityRepository;

	@Cacheable("getCities")
	public List<String> getcities(Integer countryId) {
		log.info("City service");
		return cityRepository.findCitiesByCountryId(countryId);
	}

	@CacheEvict(value = "getCities", allEntries = true)
	public void clearCitiesFromCache() {
		log.info("City service clear");
	}

}
