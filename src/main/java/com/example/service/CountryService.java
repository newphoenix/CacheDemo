package com.example.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.custom.CountryDropDown;
import com.example.repository.CountryRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CountryService {
  
  private CountryRepository countryRepository;


  @Cacheable("getCountries")
  public List<CountryDropDown> getCountries() {
    log.info("Country Service");
    return countryRepository.getCountryNames();
  }

}
