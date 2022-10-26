package com.example.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.custom.CountryDropDown;
import com.example.service.CountryService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountryController {

  private CountryService countryService;


  @GetMapping
  public ResponseEntity<List<CountryDropDown>> getCountries() {

    return ResponseEntity.ok(countryService.getCountries());
  }

}
